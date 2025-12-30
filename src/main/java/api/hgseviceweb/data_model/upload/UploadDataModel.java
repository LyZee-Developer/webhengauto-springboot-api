package api.hgseviceweb.data_model.upload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadDataModel {
    private Long  id;
    private Long refId;
    private String type;
    private String pathImage;
    private String typeImage;
    private String hostImage;
    private Long size;
    private String name;
    private String base64Text;
}
