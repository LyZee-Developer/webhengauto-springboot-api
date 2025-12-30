package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.block_content.BlockContentDataModel;
import api.hgseviceweb.dto.BlockContentDto;
import api.hgseviceweb.entity.DB_BLOCK_CONTENT;
import api.hgseviceweb.helper.GlobalHelper;

public class BlockContentMapper {
    public  static DB_BLOCK_CONTENT MaptoEntity(BlockContentDataModel model){
        var data = new DB_BLOCK_CONTENT();
        data.setTitle(model.getTitle());
        data.setTitleEnglish(model.getTitleEnglish());
        data.setSubTitle(model.getSubTitle());
        data.setSubTitleEnglish(model.getSubTitleEnglish());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setType(model.getType());
        data.setStatus(model.getStatus());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static BlockContentDto MaptoDto(DB_BLOCK_CONTENT model,int recordCount){
        var data = new BlockContentDto();
        data.setId(model.getId());
        data.setTitle(model.getTitle());
        data.setTitleEnglish(model.getTitleEnglish());
        data.setSubTitle(model.getSubTitle());
        data.setSubTitleEnglish(model.getSubTitleEnglish());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setType(model.getType());
        data.setStatus(model.getStatus());
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
