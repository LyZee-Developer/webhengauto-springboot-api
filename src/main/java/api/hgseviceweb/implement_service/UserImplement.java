package api.hgseviceweb.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.user.UserDataModel;
import api.hgseviceweb.data_model.user.UserFilterDataModel;
import api.hgseviceweb.dto.UserDto;
import api.hgseviceweb.entity.DB_IMAGE;
import api.hgseviceweb.helper.UserHelper;
import api.hgseviceweb.mapper.UserMapper;
import api.hgseviceweb.repository.ImageRepository;
import api.hgseviceweb.repository.UserRepository;
import api.hgseviceweb.service.UserService;
import api.hgseviceweb.specification.UserSpec;
import api.hgseviceweb.util.UploadImageHandler;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class UserImplement implements  UserService {
    private final UserRepository  userRepository;
    private final ImageRepository  imageRepository;
    @Override
    public List<UserDto> List(UserFilterDataModel filter){
        var list = userRepository.findAll(UserSpec.Search(filter.getSearch()).and(UserSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
         if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        var total = list.size();
        if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->{
             var pathImage = "";
            var img = imageRepository.findByRefIdAndType(s.getId(), UserHelper.FolderName.User.toUpperCase());
            if(img!=null) pathImage = img.getHostImage()+"/"+img.getPathImage();
            return UserMapper.MaptoDto(s,total,pathImage);
        }).collect(Collectors.toList());
    }

    @Override
    public  UserDto  Create(UserDataModel model){
        var mapData = UserMapper.MaptoEntity(model);
        var data = userRepository.save(mapData);
        var image = new DB_IMAGE();
        var PathImage = "";
        if(model.getUpload()!=null){
            var upload = new UploadImageHandler(UserHelper.FolderName.User);
            var dto = upload.Upload(model.getUpload());
            image.setHostImage(dto.getHostName());
            image.setNameImage(dto.getFilename());
            image.setSizeImage(dto.getSize());
            image.setRefId(data.getId());
            image.setType(UserHelper.FolderName.User.toUpperCase());
            image.setTypeImage(dto.getType());
            image.setPathImage(dto.getPathFilename());
            imageRepository.save(image);
            PathImage=image.getHostImage()+"/"+image.getPathImage();
        }
        var result = UserMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public UserDto Update(UserDataModel model){
        var image = imageRepository.findByRefIdAndType(model.getId(), UserHelper.FolderName.User);
        var data = userRepository.findById(model.getId()).get();
        var upload = new UploadImageHandler(UserHelper.FolderName.User.toLowerCase());
        var PathImage="";
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setUpdatedBy(model.getUsername());
        data.setGender(model.getGender());
        data.setStatus(model.getStatus());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone1());
        data.setUserCode(model.getUserCode());
        data.setEmail(model.getEmail());
        data.setUpdatedDate(new Date());
        userRepository.save(data);
        if(model.getUpload()!=null){
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
            newImg.setType(UserHelper.FolderName.User);
            newImg.setTypeImage(dto.getType());
            newImg.setPathImage(dto.getPathFilename());
            imageRepository.save(newImg);
            PathImage=newImg.getHostImage()+"/"+newImg.getPathImage();
        }
        var result = UserMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        userRepository.deleteById(Id);
        return true;
    }

    @Override
    public Boolean CheckCode(String code,Long Id){
        var codes = userRepository.findAll().stream().filter(s->s.getUserCode().equals(code)).collect(Collectors.toList());
        if(Id>0){
            var lists = codes.stream().filter(s->!s.getId().equals(Id)).collect(Collectors.toList());
            return !lists.isEmpty();
        } 
        return  !codes.isEmpty();
    }

    @Override
    public Boolean IsExistedUserById(Long Id){
        var users = userRepository.findAll().stream().filter(s->s.getId().equals(Id)).collect(Collectors.toList());
        return  users.isEmpty();
    }
    @Override
    public Boolean DeleteImage(Long imageId){
        var upload = new UploadImageHandler(UserHelper.FolderName.User.toLowerCase());
        var image = imageRepository.findById(imageId);
        if(!image.isEmpty()){
            upload.DeleteImage(image.get().getNameImage());
            imageRepository.delete(image.get());
            return true;
        }
        return false;
    }
    
}
