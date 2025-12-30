package api.hgseviceweb.data_model.section;

import api.hgseviceweb.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDataModel extends  IBaseDataModel{
    private Long id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String englishName;
    private Boolean status;
}
