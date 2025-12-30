package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.owner_info.OwnerInfoDataModel;
import api.hgseviceweb.dto.OwnerInfoDto;
import api.hgseviceweb.entity.DB_OWNER_INFO;
import api.hgseviceweb.helper.GlobalHelper;

public class OwnerInfoMapper {
    public  static DB_OWNER_INFO MaptoEntity(OwnerInfoDataModel model){
        var data = new DB_OWNER_INFO();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setEmail(model.getEmail());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone1());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setSubDescriptionEnglish(model.getSubDescriptionEnglish());
        data.setSubDescription(model.getSubDescription());
        data.setFacebookUrl(model.getFacebookUrl());
        data.setInUrl(model.getInUrl());
        data.setInstagramUrl(model.getInstagramUrl());
        data.setTelegramUrl(model.getTelegramUrl());
        data.setYoutubeUrl(model.getYoutubeUrl());
        data.setWorkingInfo(model.getWorkingInfo());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static OwnerInfoDto MaptoDto(DB_OWNER_INFO model,int recordCount,String pathImage){
        var data = new OwnerInfoDto();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setEnglishName(model.getNameEn());
        data.setCreatedBy(model.getCreatedBy());
        data.setEmail(model.getEmail());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone1());
        data.setFaceboolUrl(model.getFacebookUrl());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setSubDescription(model.getSubDescription());
        data.setSubDescriptionEnglish(model.getSubDescriptionEnglish());
        data.setInstagramUrl(model.getInstagramUrl());
        data.setPathImage(pathImage);
        data.setInUrl(model.getInUrl());
        data.setWorkingInfo(model.getWorkingInfo());
        data.setTelegramUrl(model.getTelegramUrl());
        data.setYoutubeUrl(model.getYoutubeUrl());
        data.setRecordCount(recordCount);
        data.setCreatedDate(model.getCreatedDate());
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
