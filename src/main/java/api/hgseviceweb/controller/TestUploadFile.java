package api.hgseviceweb.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class TestUploadFile {
    private final String uploadBasePath;
    public TestUploadFile(@Value("${app.upload.base-path}") String uploadBasePath){
        this.uploadBasePath = uploadBasePath;
    }

    @PostMapping("/car")
    public ResponseEntity<?> uploadCarImage(
            @RequestParam("file") MultipartFile file) {

        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            String folder = uploadBasePath + "/test";
            Files.createDirectories(Paths.get(folder));

            // String filename = System.currentTimeMillis()
            //         + "_" + file.getOriginalFilename().replace(" ", "_");

            // Path filePath = Paths.get(folder, filename);
            // Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // String previewUrl = "/upload/test/" + filename;

            return ResponseEntity.ok(Map.of(
                    "fileName", "testpro",
                    "previewUrl", "testpro"
            ));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
