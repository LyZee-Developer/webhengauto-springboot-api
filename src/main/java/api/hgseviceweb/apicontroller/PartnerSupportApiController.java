package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.PartnerSupportController;
import api.hgseviceweb.data_model.partner_support.PartnerSupportDataModel;
import api.hgseviceweb.data_model.partner_support.PartnerSupportFilterDataModel;
import api.hgseviceweb.helper.PartnerSupportHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class PartnerSupportApiController {
    private final PartnerSupportController partnerSupportController;
    
    @PostMapping(PartnerSupportHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody PartnerSupportFilterDataModel filter){
        ResponseEntity<?> result = partnerSupportController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(PartnerSupportHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody PartnerSupportDataModel model){
        ResponseEntity<?> result = partnerSupportController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(PartnerSupportHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody PartnerSupportDataModel model){
        ResponseEntity<?> result = partnerSupportController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
    @GetMapping(PartnerSupportHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = partnerSupportController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    @GetMapping(PartnerSupportHelper.URL.DeleteImage)
    public ResponseEntity<?> DeleteImage(@RequestParam(value="imageId") Long Id){
        var result = partnerSupportController.DeleteImage(Id);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
}
