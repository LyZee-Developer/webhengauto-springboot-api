package api.hgseviceweb.data_model.block_content_detail;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BlockContentDetailFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
    private Long contentBlockId;
}
