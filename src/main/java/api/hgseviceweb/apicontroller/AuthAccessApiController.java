package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.AuthAccessController;
import api.hgseviceweb.data_model.auth_access.AuthAccessDataModel;
import api.hgseviceweb.data_model.auth_access.AuthAccessFilterDataModel;
import api.hgseviceweb.helper.AuthAccessHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class AuthAccessApiController {
    private final AuthAccessController authAccessController;
    @PostMapping(AuthAccessHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody AuthAccessFilterDataModel filer){
        var result = authAccessController.List(filer);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(AuthAccessHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody AuthAccessDataModel model){
        var result = authAccessController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(AuthAccessHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody AuthAccessDataModel model){
        var result = authAccessController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @GetMapping(AuthAccessHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="Id") Long Id){
        var result = authAccessController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
    @GetMapping(AuthAccessHelper.URL.Login)
    public ResponseEntity<?> IsLoginSuccess(@RequestParam(value="username") String Username,@RequestParam(value="password") String Password){
        var result = authAccessController.IsLoginSuccess(Username, Password);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
}
