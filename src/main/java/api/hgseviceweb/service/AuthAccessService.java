package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.auth_access.AuthAccessDataModel;
import api.hgseviceweb.data_model.auth_access.AuthAccessFilterDataModel;
import api.hgseviceweb.dto.AuthAccessDto;

@Service
public interface AuthAccessService {
    List<AuthAccessDto> List(AuthAccessFilterDataModel filter);
    AuthAccessDto Create(AuthAccessDataModel model);
    AuthAccessDto Update(AuthAccessDataModel model);
    Boolean IsLoginSuccess(String username,String password);
    Boolean Delete(Long Id);
    Boolean CheckUsername(String name,Long Id);
}
