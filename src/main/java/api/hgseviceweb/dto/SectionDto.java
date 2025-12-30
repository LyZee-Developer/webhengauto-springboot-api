package api.hgseviceweb.dto;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SectionDto {
    public Long  id;
    private String name;
    private String englishName;
    private Boolean status;
    private String createdBy;
    private Date createdDate;
    private String database;
    private String updatedBy;
    private Date updatedDate;
}
