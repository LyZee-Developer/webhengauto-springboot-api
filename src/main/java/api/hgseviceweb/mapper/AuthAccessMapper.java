package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.auth_access.AuthAccessDataModel;
import api.hgseviceweb.dto.AuthAccessDto;
import api.hgseviceweb.entity.DB_AUTH_ACCESS;
import api.hgseviceweb.helper.GlobalHelper;

public class AuthAccessMapper {
    public  static DB_AUTH_ACCESS MaptoEntity(AuthAccessDataModel model){
        var data = new DB_AUTH_ACCESS();
        data.setType("A");
        data.setUserId(1L);
        data.setUsername(model.getUserName());
        data.setPassword(model.getPassword());
        data.setStatus(model.getStatus());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static AuthAccessDto MaptoDto(DB_AUTH_ACCESS model,int recordCount){
        var data = new AuthAccessDto();
        data.setId(model.getId());
        data.setUserId(model.getUserId());
        data.setUsername(model.getUsername());
        data.setPassword(model.getPassword());
        data.setType(model.getType());
        data.setStatus(model.getStatus());
        data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
