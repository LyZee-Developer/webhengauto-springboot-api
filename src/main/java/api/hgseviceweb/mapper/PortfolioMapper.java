package api.hgseviceweb.mapper;


import java.util.Date;
import java.util.List;

import api.hgseviceweb.data_model.portfolio.PortfolioDataModel;
import api.hgseviceweb.dto.ImageDto;
import api.hgseviceweb.dto.PortfolioDto;
import api.hgseviceweb.entity.DB_PORTFOLIO;
import api.hgseviceweb.helper.GlobalHelper;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class PortfolioMapper {
    public  static DB_PORTFOLIO MaptoEntity(PortfolioDataModel model){
        var data = new DB_PORTFOLIO();
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setStatus(model.getStatus());
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static PortfolioDto MaptoDto(DB_PORTFOLIO model,int recordCount,List<ImageDto> Image){
        var data = new PortfolioDto();
        data.setId(model.getId());
        data.setImages(Image);
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
