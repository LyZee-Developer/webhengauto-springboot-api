package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.OwnerInfoController;
import api.hgseviceweb.data_model.owner_info.OwnerInfoDataModel;
import api.hgseviceweb.data_model.owner_info.OwnerInfoFilterDataModel;
import api.hgseviceweb.helper.OwnerInfoHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class OwnerInfoApiController {
    private final OwnerInfoController ownerInfoController;
    
    @PostMapping(OwnerInfoHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody OwnerInfoFilterDataModel filter){
        ResponseEntity<?> result = ownerInfoController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(OwnerInfoHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody OwnerInfoDataModel model){
        ResponseEntity<?> result = ownerInfoController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(OwnerInfoHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody OwnerInfoDataModel model){
        ResponseEntity<?> result = ownerInfoController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
    @GetMapping(OwnerInfoHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = ownerInfoController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    @GetMapping(OwnerInfoHelper.URL.DeleteImage)
    public ResponseEntity<?> DeleteImage(@RequestParam(value="imageId") Long Id){
        var result = ownerInfoController.DeleteImage(Id);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
}
