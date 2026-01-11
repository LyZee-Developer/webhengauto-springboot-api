package api.hgseviceweb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.upload.UploadDataModel;
import api.hgseviceweb.dto.UploadDto;
import api.hgseviceweb.util.UploadImageHandler;
@Service
public class FileUploadService {
    private final String port;
    public FileUploadService(@Value("${server.port}") String serverPort){
        this.port = serverPort;
    }
    public UploadDto uploadFile(UploadDataModel file) {
        UploadImageHandler upload = new UploadImageHandler("car",this.port);
        var dto = upload.Upload(file);
        return dto;
    }
    public Boolean DeleteImage(String filename) {
        UploadImageHandler upload = new UploadImageHandler("car",this.port);
        var isDeleteSuccess = upload.DeleteImage(filename);
        return isDeleteSuccess;
    }
}
