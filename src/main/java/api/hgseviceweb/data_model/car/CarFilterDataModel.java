package api.hgseviceweb.data_model.car;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CarFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
