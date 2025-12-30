package api.hgseviceweb.data_model.user;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UserFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
