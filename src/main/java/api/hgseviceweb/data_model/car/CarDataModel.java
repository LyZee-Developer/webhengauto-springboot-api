package api.hgseviceweb.data_model.car;

import api.hgseviceweb.data_model.IBaseDataModel;
import api.hgseviceweb.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDataModel extends  IBaseDataModel{
    public Long id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String englishName;
    public Boolean status;
    private UploadDataModel upload;
}
