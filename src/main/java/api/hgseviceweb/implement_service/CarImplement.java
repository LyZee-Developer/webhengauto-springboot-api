package api.hgseviceweb.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.car.CarDataModel;
import api.hgseviceweb.data_model.car.CarFilterDataModel;
import api.hgseviceweb.dto.CarDto;
import api.hgseviceweb.entity.DB_IMAGE;
import api.hgseviceweb.helper.CarHelper;
import api.hgseviceweb.helper.GlobalHelper;
import api.hgseviceweb.mapper.CarMapper;
import api.hgseviceweb.repository.CarRepository;
import api.hgseviceweb.repository.ImageRepository;
import api.hgseviceweb.service.CarService;
import api.hgseviceweb.specification.CarSpec;
import api.hgseviceweb.util.UploadImageHandler;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CarImplement implements  CarService {
    private final CarRepository  carRepository; 
    private final ImageRepository  imageRepository;
    @Override
    public List<CarDto> List(CarFilterDataModel filter){
        var list = carRepository.findAll(CarSpec.Search(filter.getSearch()).and(CarSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
       
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
             list = list.stream().skip((filter.getPage()-1) * filter.getRecord()).limit(filter.getRecord()).collect(Collectors.toList());
        }
        return list.stream().map(s->{
            var pathImage = "";
            var img = imageRepository.findByRefIdAndType(s.getId(), CarHelper.FolderName.Car.toUpperCase());
            if(img!=null) pathImage = img.getPathImage();
            return CarMapper.MaptoDto(s,totalRecord,pathImage);
        }).collect(Collectors.toList());
    }

    @Override
    public  CarDto  Create(CarDataModel model){
        var mapData = CarMapper.MaptoEntity(model);
        var data = carRepository.save(mapData);
        var image = new DB_IMAGE();
        //upload image
        var PathImage = "";
        if(model.getUpload().getBase64Text()!=null){
            var upload = new UploadImageHandler(CarHelper.FolderName.Car);
            var dto = upload.Upload(model.getUpload());
            image.setHostImage(dto.getHostName());
            image.setNameImage(dto.getFilename());
            image.setSizeImage(dto.getSize());
            image.setRefId(data.getId());
            image.setType(CarHelper.FolderName.Car.toUpperCase());
            image.setTypeImage(dto.getType());
            image.setPathImage(dto.getPathFilename());
            imageRepository.save(image);
            PathImage=image.getHostImage()+"/"+image.getPathImage();
        }
        var result = CarMapper.MaptoDto(data,1,image.getPathImage());
        return result;
    }

    @Override
    public CarDto Update(CarDataModel model){
        var PathImage = "";
        var data = carRepository.findById(model.getId()).get();
        var image = imageRepository.findByRefIdAndType(model.getId(), CarHelper.FolderName.Car.toUpperCase());
        var upload = new UploadImageHandler(CarHelper.FolderName.Car);
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setUpdatedBy(GlobalHelper.Str.ADMIN);
        data.setStatus(model.getStatus());
        data.setUpdatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        carRepository.save(data);
        if(model.getUpload().getBase64Text()!=null){
            if(image!=null) {
                upload.DeleteImage(image.getNameImage());
                imageRepository.delete(image);
            }
            var dto = upload.Upload(model.getUpload());
            var newImg = new DB_IMAGE();
            newImg.setHostImage(dto.getHostName());
            newImg.setNameImage(dto.getFilename());
            newImg.setSizeImage(dto.getSize());
            newImg.setRefId(data.getId());
            newImg.setType(CarHelper.FolderName.Car.toUpperCase());
            newImg.setTypeImage(dto.getType());
            newImg.setPathImage(dto.getPathFilename());
            imageRepository.save(newImg);
            PathImage=newImg.getHostImage()+"/"+newImg.getPathImage();
        }
        var result = CarMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        carRepository.deleteById(Id);
        return true;
    }
    
    @Override
    public Boolean IsExistedCar(Long CarId){
        var getCar = carRepository.findById(CarId);
        return getCar.isPresent();
    }

    @Override
    public Boolean DeleteImage(Long imageId){
        var upload = new UploadImageHandler(CarHelper.FolderName.Car);
        var image = imageRepository.findById(imageId);
        if(!image.isEmpty()){
            upload.DeleteImage(image.get().getNameImage());
            imageRepository.delete(image.get());
            return true;
        }
        return false;
    }
    
}
