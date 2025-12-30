package api.hgseviceweb.data_model.owner_info;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class OwnerInfoFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
