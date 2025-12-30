package api.hgseviceweb.data_model.user;

import api.hgseviceweb.data_model.IBaseDataModel;
import api.hgseviceweb.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataModel extends  IBaseDataModel{
    private Long id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String englishName;
    @Size(max = 20, message = "Phone cannot exceed 20 characters")
    private String phone;
    @Size(max = 20, message = "Phone1 cannot exceed 20 characters")
    private String phone1;
    @Size(max = 100, message = "Name cannot exceed 50 characters")
    private String email;
     @Size(max = 20, message = "UserCode cannot exceed 20 characters")
    private String userCode;
    private Boolean gender;
    private Boolean status;
    private UploadDataModel upload;
}
