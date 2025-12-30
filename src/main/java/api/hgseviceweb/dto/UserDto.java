package api.hgseviceweb.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto extends IBaseDto {
    public Long  id;
    private String name;
    private String englishName;
    private String email;
    private String phone;
    private String code;
    private Boolean status;
    private String phone1;
    private Boolean gender;
    private String pathImage;
}
