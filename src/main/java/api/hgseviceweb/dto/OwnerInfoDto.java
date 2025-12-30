package api.hgseviceweb.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OwnerInfoDto extends IBaseDto{
    private Long id;
    private String name;
    private String englishName;
    private String phone;
    private String phone1;
    private String email;
    private String description;
    private String subDescription;
    private String subDescriptionEnglish;
    private String descriptionEnglish;
    private String faceboolUrl;
    private String inUrl;
    private String instagramUrl;
    private String youtubeUrl;
    private String telegramUrl;
    private String workingInfo;
    private String pathImage;
}
