package api.hgseviceweb.data_model.block_content;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BlockContentFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
