package api.hgseviceweb.data_model.section;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SectionFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
