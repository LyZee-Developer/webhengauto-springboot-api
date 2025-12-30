package api.hgseviceweb.data_model.auth_access;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AuthAccessFilterDataModel extends IBaseFilterDataModel  {
    Boolean status;
}
