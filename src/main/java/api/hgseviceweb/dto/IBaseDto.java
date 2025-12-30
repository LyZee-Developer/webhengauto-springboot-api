package api.hgseviceweb.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class IBaseDto {
    private String createdBy;
    private Date createdDate;
    private String database;
    private String updatedBy;
    private Date updatedDate;
    private int recordCount;
}
