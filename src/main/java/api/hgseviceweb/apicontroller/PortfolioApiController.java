package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.PortfolioController;
import api.hgseviceweb.data_model.portfolio.PortfolioDataModel;
import api.hgseviceweb.data_model.portfolio.PortfolioFilterDataModel;
import api.hgseviceweb.helper.PortfolioHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class PortfolioApiController {
    private final PortfolioController portfolioController;
     
    @PostMapping(PortfolioHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody PortfolioFilterDataModel filter){
        ResponseEntity<?> result = portfolioController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(PortfolioHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody PortfolioDataModel model){
        ResponseEntity<?> result = portfolioController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
    
    @GetMapping(PortfolioHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = portfolioController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    @GetMapping(PortfolioHelper.URL.DeleteImage)
    public ResponseEntity<?> DeleteImage(@RequestParam(value="imageId")  Long Id){
        var result = portfolioController.DeleteImage(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
   
}
