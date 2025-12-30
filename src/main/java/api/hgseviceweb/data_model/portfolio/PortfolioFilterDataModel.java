package api.hgseviceweb.data_model.portfolio;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioFilterDataModel extends  IBaseFilterDataModel{
    private Boolean status;
}
