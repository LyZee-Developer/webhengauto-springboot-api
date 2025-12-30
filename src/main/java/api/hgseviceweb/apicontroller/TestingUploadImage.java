package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.data_model.car.CarTestDataModel;
import api.hgseviceweb.service.FileUploadService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class TestingUploadImage {
    
    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody CarTestDataModel model) {
        var result = fileUploadService.uploadFile(model.getUpload());
        return ResponseEntity.ok(result);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> Delete(@RequestParam(value="filename") String filename) {
        var result = fileUploadService.DeleteImage(filename);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/upload-base64")
    public ResponseEntity<?> uploadBase64(@RequestBody CarTestDataModel model) {
         var result = fileUploadService.uploadFile(model.getUpload());
        return ResponseEntity.ok(result);
    }
}
