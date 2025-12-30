package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.user.UserDataModel;
import api.hgseviceweb.data_model.user.UserFilterDataModel;
import api.hgseviceweb.dto.UserDto;

@Service
public interface UserService {
    List<UserDto> List(UserFilterDataModel filter);
    UserDto Create(UserDataModel model);
    UserDto Update(UserDataModel model);
    Boolean CheckCode(String code,Long Id);
    Boolean Delete(Long Id);
    Boolean IsExistedUserById(Long Id);
    Boolean DeleteImage(Long Id);
}
