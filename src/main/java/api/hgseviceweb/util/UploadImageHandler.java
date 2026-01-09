package api.hgseviceweb.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import api.hgseviceweb.config.PortReader;
import api.hgseviceweb.data_model.upload.UploadDataModel;
import api.hgseviceweb.dto.UploadDto;
import api.hgseviceweb.helper.GlobalHelper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadImageHandler {
    private PortReader portReader;
    private String FolderName;
    private Environment environment;
    private String folderUpload;
    public UploadImageHandler(String FolderName) {
        this.FolderName = FolderName.toLowerCase();
        this.folderUpload = "upload/"+this.FolderName;
    }
    @Async
    public UploadDto Upload(MultipartFile file) {
        try {
            var dto = new UploadDto();
            var folderPath = GlobalHelper.Path.upload + "\\" + this.FolderName;
            // Create folder if not exists
            Path uploadPath = Paths.get(folderPath);
            if (!Files.exists(uploadPath))
                Files.createDirectories(uploadPath);
            // Create storage path
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().replace(" ", "_");
            Path filePath = uploadPath.resolve(fileName);
            // Save file
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            dto.setFilename(fileName);
            dto.setHostName("localhost:8989");
            dto.setPathFilename(folderUpload+"/"+fileName);
            dto.setType(file.getContentType());
            dto.setSize(file.getSize());
            return dto;

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }
    @Async
    public UploadDto Upload(UploadDataModel model) {
        try {
            var dto = new UploadDto();
              String base64 = model.getBase64Text();

            // REMOVE data:image/...;base64, part
            if (base64.contains(",")) {
                base64 = base64.substring(base64.indexOf(",") + 1);
            }
            byte[] fileBytes = Base64.getDecoder().decode(base64);
            var folderPath = GlobalHelper.Path.upload + "\\" + this.FolderName;
            // Create folder if not exists
            Path uploadPath = Paths.get(folderPath);
            if (!Files.exists(uploadPath))
                Files.createDirectories(uploadPath);
            // Create storage path
            String fileName = System.currentTimeMillis() + "_" + model.getName().replace(" ", "_");
            Path filePath = uploadPath.resolve(fileName);
            // Save file
            Files.write(filePath, fileBytes);
            dto.setFilename(fileName);
            dto.setHostName("localhost:8989");
            dto.setPathFilename(this.folderUpload+"/"+fileName);
            dto.setType(model.getTypeImage());
            dto.setSize(model.getSize());
            return dto;

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }
    @Async
    public List<UploadDto> Upload(List<UploadDataModel> model) {
        try {
            var multiDto = new ArrayList<UploadDto>();
            for(UploadDataModel upload : model){
                var dto = new UploadDto();
                byte[] fileBytes = Base64.getDecoder().decode(upload.getBase64Text());
                var folderPath = GlobalHelper.Path.upload + "\\" + this.FolderName;
                // Create folder if not exists
                Path uploadPath = Paths.get(folderPath);
                if (!Files.exists(uploadPath))
                    Files.createDirectories(uploadPath);
                // Create storage path
                String fileName = System.currentTimeMillis() + "_" + upload.getName().replace(" ", "_")+"."+upload.getTypeImage();
                Path filePath = uploadPath.resolve(fileName);
                // Save file
                Files.write(filePath, fileBytes);
                dto.setFilename(fileName);
                dto.setHostName("localhost:8989");
                dto.setPathFilename(this.folderUpload+"/"+fileName);
                dto.setType(upload.getTypeImage());
                dto.setSize(upload.getSize());
                multiDto.add(dto);
            }
            return multiDto;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }

    public Boolean DeleteImage(String filename){
        try {
             var folderPath = GlobalHelper.Path.upload + "\\" + this.FolderName;
            Path filePath = Paths.get(folderPath,filename);
            if(Files.exists(filePath)) {
                Files.delete(filePath);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw  new RuntimeException("Error deleting file: ", e);
        }
    }

}
