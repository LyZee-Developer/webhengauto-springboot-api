package api.hgseviceweb.data_model.owner_info;

import api.hgseviceweb.data_model.IBaseDataModel;
import api.hgseviceweb.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerInfoDataModel extends  IBaseDataModel{
    public Long id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String name;
    @Size(max = 50, message = "EnglishName cannot exceed 50 characters")
    public String englishName;
    @Size(max = 15, message = "Phone cannot exceed 15 characters")
    private String phone;
    @Size(max = 15, message = "Phone1 cannot exceed 15 characters")
    private String phone1;
    private String email;
    private String subDescription;
    private String subDescriptionEnglish;
    private String description;
    private String descriptionEnglish;
    private String facebookUrl;
    private String instagramUrl;
    private String inUrl;
    private String youtubeUrl;
    private String telegramUrl;
    @Size(max = 255, message = "WorkingInfo cannot exceed 255 characters")
    private String workingInfo;
    private UploadDataModel upload;
}
