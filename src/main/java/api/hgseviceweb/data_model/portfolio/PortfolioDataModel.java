package api.hgseviceweb.data_model.portfolio;

import java.util.List;

import api.hgseviceweb.data_model.IBaseDataModel;
import api.hgseviceweb.data_model.upload.UploadDataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioDataModel extends  IBaseDataModel{
    private List<UploadDataModel> uploads;
    private Boolean status;
}
