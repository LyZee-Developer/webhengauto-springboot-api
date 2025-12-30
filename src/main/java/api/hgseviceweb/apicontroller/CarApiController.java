package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.CarController;
import api.hgseviceweb.data_model.car.CarDataModel;
import api.hgseviceweb.data_model.car.CarFilterDataModel;
import api.hgseviceweb.helper.CarHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class CarApiController {
    private final CarController carController;
     
    @PostMapping(CarHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody CarFilterDataModel filter){
        ResponseEntity<?> result = carController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(CarHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody CarDataModel model){
        ResponseEntity<?> result = carController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(CarHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody CarDataModel model){
        ResponseEntity<?> result = carController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
    @GetMapping(CarHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = carController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    @GetMapping(CarHelper.URL.DeleteImage)
    public ResponseEntity<?> DeleteImage(@RequestParam(value="imageId")  Long Id){
        var result = carController.DeleteImage(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
   
}
