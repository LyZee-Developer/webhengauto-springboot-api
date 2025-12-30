package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.BlockContentController;
import api.hgseviceweb.data_model.block_content.BlockContentDataModel;
import api.hgseviceweb.data_model.block_content.BlockContentFilterDataModel;
import api.hgseviceweb.helper.BlockContentHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class BlockContentApiController {
    private final BlockContentController blockContentController;
    
    @PostMapping(BlockContentHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody BlockContentFilterDataModel filter){
        ResponseEntity<?> result = blockContentController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(BlockContentHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody BlockContentDataModel model){
        ResponseEntity<?> result = blockContentController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(BlockContentHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody BlockContentDataModel model){
        ResponseEntity<?> result = blockContentController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
    @GetMapping(BlockContentHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = blockContentController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
}
