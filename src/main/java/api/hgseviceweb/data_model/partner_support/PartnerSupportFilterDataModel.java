package api.hgseviceweb.data_model.partner_support;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PartnerSupportFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
