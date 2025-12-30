package api.hgseviceweb.data_model.auth_access;

import api.hgseviceweb.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthAccessDataModel extends  IBaseDataModel{
    public Long id;
    @Size(max = 1, message = "Type cannot exceed 1 characters")
    private String type; //A(Admin) || O(Other)
    private Long userId;
    @Size(max = 30, message = "Username cannot exceed 30 characters")
    private String userName;
    @Size(max = 500, message = "Password cannot exceed 500 characters")
    private String password;
    private Boolean status;
}
