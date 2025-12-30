package api.hgseviceweb.data_model.car;

import api.hgseviceweb.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarTestDataModel{
    private Long id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String englishName;
    private Boolean status;
    private UploadDataModel upload;
}
