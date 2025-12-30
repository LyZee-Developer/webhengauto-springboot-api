package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.service_type.ServiceTypeDataModel;
import api.hgseviceweb.dto.ServiceTypeDto;
import api.hgseviceweb.entity.DB_SERVICE_TYPE;
import api.hgseviceweb.helper.GlobalHelper;

public class ServiceTypeMapper {
    public  static DB_SERVICE_TYPE MaptoEntity(ServiceTypeDataModel model){
        var data = new DB_SERVICE_TYPE();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setStatus(model.getStatus());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static ServiceTypeDto MaptoDto(DB_SERVICE_TYPE model,int recordCount){
        var data = new ServiceTypeDto();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setStatus(model.getStatus());
        data.setEnglishName(model.getNameEn());
        data.setCreatedBy(model.getCreatedBy());
        data.setRecordCount(recordCount);
        data.setCreatedDate(model.getCreatedDate());
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
