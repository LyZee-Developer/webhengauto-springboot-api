package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailDataModel;
import api.hgseviceweb.dto.BlockContentDetailDto;
import api.hgseviceweb.entity.DB_BLOCK_CONTENT_DEL;
import api.hgseviceweb.helper.GlobalHelper;

public class BlockContentDetailMapper {
    public  static DB_BLOCK_CONTENT_DEL  MaptoEntity(BlockContentDetailDataModel model){
        var data = new DB_BLOCK_CONTENT_DEL();
        data.setTitle(model.getTitle());
        data.setBlockContentId(model.getBlockContentId());
        data.setTitleEnglish(model.getTitleEnglish());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setStatus(model.getStatus());
        data.setCreatedBy(GlobalHelper.Str.ADMIN); 
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static BlockContentDetailDto MaptoDto(DB_BLOCK_CONTENT_DEL model,int recordCount,String PathImage){
        var data = new BlockContentDetailDto();
        data.setId(model.getId());
        data.setTitle(model.getTitle());
        data.setTitleEnglish(model.getTitleEnglish());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setStatus(model.getStatus());
        data.setPathImage(PathImage);
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
