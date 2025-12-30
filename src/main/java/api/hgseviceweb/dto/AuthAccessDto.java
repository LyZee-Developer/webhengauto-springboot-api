package api.hgseviceweb.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AuthAccessDto extends IBaseDto {
    public Long  id;
    private Long userId;
    private String username;
    private String password;
    private String type;
    private Boolean status;
}
