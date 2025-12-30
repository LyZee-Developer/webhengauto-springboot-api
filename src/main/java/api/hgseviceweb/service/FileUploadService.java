package api.hgseviceweb.service;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.upload.UploadDataModel;
import api.hgseviceweb.dto.UploadDto;
import api.hgseviceweb.util.UploadImageHandler;
@Service
public class FileUploadService {
    UploadImageHandler upload = new UploadImageHandler("car");
    public UploadDto uploadFile(UploadDataModel file) {
        var dto = upload.Upload(file);
        return dto;
    }
    public Boolean DeleteImage(String filename) {
        var isDeleteSuccess = upload.DeleteImage(filename);
        return isDeleteSuccess;
    }
}
