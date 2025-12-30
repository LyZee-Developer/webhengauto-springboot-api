package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.partner_support.PartnerSupportDataModel;
import api.hgseviceweb.dto.PartnerSupportDto;
import api.hgseviceweb.entity.DB_PARTNER_SUPPORT;
import api.hgseviceweb.helper.GlobalHelper;

public class PartnerSupportMapper {
    public  static DB_PARTNER_SUPPORT MaptoEntity(PartnerSupportDataModel model){
        var data = new DB_PARTNER_SUPPORT();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setStatus(model.getStatus());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static PartnerSupportDto MaptoDto(DB_PARTNER_SUPPORT model,int recordCount,String pathImage){
        var data = new PartnerSupportDto();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setStatus(model.getStatus());
        data.setEnglishName(model.getNameEn());
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setPathImage(pathImage);
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
