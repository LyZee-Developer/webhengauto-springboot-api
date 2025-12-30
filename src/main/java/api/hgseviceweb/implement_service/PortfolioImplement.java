package api.hgseviceweb.implement_service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.portfolio.PortfolioDataModel;
import api.hgseviceweb.data_model.portfolio.PortfolioFilterDataModel;
import api.hgseviceweb.data_model.upload.UploadDataModel;
import api.hgseviceweb.dto.ImageDto;
import api.hgseviceweb.dto.PortfolioDto;
import api.hgseviceweb.entity.DB_IMAGE;
import api.hgseviceweb.helper.PortfolioHelper;
import api.hgseviceweb.mapper.PortfolioMapper;
import api.hgseviceweb.repository.ImageRepository;
import api.hgseviceweb.repository.PortfolioRepository;
import api.hgseviceweb.service.PortfolioService;
import api.hgseviceweb.specification.PortfolioSpec;
import api.hgseviceweb.util.UploadImageHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PortfolioImplement implements  PortfolioService {
    private final PortfolioRepository  portfolioRepository;
    private final ImageRepository  imageRepository;
    @Override
    public List<PortfolioDto> List(PortfolioFilterDataModel filter){
        var list = portfolioRepository.findAll(PortfolioSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy()));
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->{
            var pathImage = new ArrayList<ImageDto>();
            var imgs = imageRepository.findAllByRefIdAndType(s.getId(), PortfolioHelper.FolderName.Portfolio.toUpperCase());
            if(imgs!=null){
                for (DB_IMAGE image : imgs) {
                    var img = new ImageDto();
                    img.setId(image.getId());
                    img.setRefId(image.getRefId());
                    img.setType(PortfolioHelper.FolderName.Portfolio);
                    img.setPathImage(image.getPathImage());
                    img.setTypeImage(image.getTypeImage());
                    img.setSize(image.getSizeImage());
                    img.setHostUrl("http://localhost:8989");
                    img.setName(image.getNameImage());
                    pathImage.add(img);
                }
            }
            return PortfolioMapper.MaptoDto(s,totalRecord,pathImage);
        }).collect(Collectors.toList());
    }

    @Override
    public  PortfolioDto  Create(PortfolioDataModel model){
        var mapData = PortfolioMapper.MaptoEntity(model);
        var data = portfolioRepository.save(mapData);
        
        var listImages = new ArrayList<ImageDto>();
      
        if(model.getUploads()!=null){
            for (UploadDataModel elm : model.getUploads()) {
                var upload = new UploadImageHandler(PortfolioHelper.FolderName.Portfolio.toLowerCase());
                var dto = upload.Upload(elm);
                var image = new DB_IMAGE();
                image.setHostImage(dto.getHostName());
                image.setNameImage(dto.getFilename());
                image.setSizeImage(dto.getSize());
                image.setRefId(data.getId());
                image.setType(PortfolioHelper.FolderName.Portfolio);
                image.setTypeImage(dto.getType());
                image.setPathImage(dto.getPathFilename());
                imageRepository.save(image);
                var imageDto = new ImageDto();
                imageDto.setId(image.getId());
                imageDto.setRefId(image.getRefId());
                imageDto.setType(PortfolioHelper.FolderName.Portfolio);
                imageDto.setPathImage(image.getPathImage());
                imageDto.setTypeImage(image.getTypeImage());
                imageDto.setSize(image.getSizeImage());
                imageDto.setName(image.getNameImage());
                listImages.add(imageDto);
            }
        }
        var result = PortfolioMapper.MaptoDto(data,1,listImages);
        return result;
    }
    @Override
    public Boolean Delete(Long Id){
        portfolioRepository.deleteById(Id);
        return true;
    }

    @Override
    public Boolean DeleteImage(Long imageId){
        var upload = new UploadImageHandler(PortfolioHelper.FolderName.Portfolio.toLowerCase());
        var image = imageRepository.findById(imageId);
        if(!image.isEmpty()){
            upload.DeleteImage(image.get().getNameImage());
            imageRepository.delete(image.get());
            return true;
        }
        return false;
    }
    
}
