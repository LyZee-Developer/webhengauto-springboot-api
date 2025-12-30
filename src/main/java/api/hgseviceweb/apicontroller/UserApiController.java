package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.UserController;
import api.hgseviceweb.data_model.user.UserDataModel;
import api.hgseviceweb.data_model.user.UserFilterDataModel;
import api.hgseviceweb.helper.UserHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class UserApiController {
    private final UserController userControllers;
    @PostMapping(UserHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody UserFilterDataModel filer){
        var result = userControllers.List(filer);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(UserHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody UserDataModel model){
        var result = userControllers.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(UserHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody UserDataModel model){
        var result = userControllers.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @GetMapping(UserHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="Id") Long Id){
        var result = userControllers.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
    @GetMapping(UserHelper.URL.CheckCode)
    public ResponseEntity<?> CheckCode(@RequestParam(value="Code") String Code){
        var result = userControllers.CheckCode(Code);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
    @GetMapping(UserHelper.URL.DeleteImage)
    public ResponseEntity<?> DeleteImage(@RequestParam(value="imageId") Long Id){
        var result = userControllers.DeleteImage(Id);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
}
