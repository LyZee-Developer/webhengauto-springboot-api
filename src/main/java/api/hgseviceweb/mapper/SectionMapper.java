package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.section.SectionDataModel;
import api.hgseviceweb.dto.SectionDto;
import api.hgseviceweb.entity.DB_SECTION;

public class SectionMapper {
    public  static DB_SECTION MaptoEntity(SectionDataModel model){
        var data = new DB_SECTION();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setStatus(model.getStatus());
        data.setCreatedBy(model.getUsername());
        data.setCreatedDate(new Date());
        data.setDbCode(model.getDatabase());
        return data;
    }
    public  static SectionDto MaptoDto(DB_SECTION model){
        var data = new SectionDto();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setStatus(model.getStatus());
        data.setEnglishName(model.getNameEn());
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
