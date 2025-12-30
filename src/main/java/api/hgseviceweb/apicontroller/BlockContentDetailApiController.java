package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.BlockContentDetailController;
import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailDataModel;
import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailFilterDataModel;
import api.hgseviceweb.helper.BlockContentDetailHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class BlockContentDetailApiController {
    private final BlockContentDetailController blockContentDetailController;
    @PostMapping(BlockContentDetailHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody BlockContentDetailFilterDataModel filter){
        ResponseEntity<?> result = blockContentDetailController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(BlockContentDetailHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody BlockContentDetailDataModel model){
        ResponseEntity<?> result = blockContentDetailController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(BlockContentDetailHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody BlockContentDetailDataModel model){
        ResponseEntity<?> result = blockContentDetailController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
    @GetMapping(BlockContentDetailHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = blockContentDetailController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
}
