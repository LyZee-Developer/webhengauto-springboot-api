package api.hgseviceweb.data_model;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class IBaseDataModel {
    protected String username;
    protected String database;
    protected Date date;
}
