package api.hgseviceweb.data_model.service_type;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ServiceTypeFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
