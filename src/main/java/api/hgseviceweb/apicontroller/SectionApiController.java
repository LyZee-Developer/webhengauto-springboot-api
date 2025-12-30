package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.SectionController;
import api.hgseviceweb.data_model.section.SectionDataModel;
import api.hgseviceweb.data_model.section.SectionFilterDataModel;
import api.hgseviceweb.data_model.section.SectionDataModel;
import api.hgseviceweb.data_model.section.SectionFilterDataModel;
import api.hgseviceweb.helper.SectionHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class SectionApiController {
    private final SectionController sectionDataModel;
       
    @GetMapping("api/test/read")
    public ResponseEntity<?> TestController(){
        ResponseEntity<?> result = sectionDataModel.TestController();
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
    
    @PostMapping(SectionHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody SectionFilterDataModel filter){
        ResponseEntity<?> result = sectionDataModel.List(filter);
        return result;
    }

    @PostMapping(SectionHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody SectionDataModel model){
        ResponseEntity<?> result = sectionDataModel.Create(model);
        return result;
    }

    @PostMapping(SectionHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody SectionDataModel model){
        ResponseEntity<?> result = sectionDataModel.Update(model);
        return result;
    }
    
    @GetMapping(SectionHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = sectionDataModel.Delete(Id);
        return result;
    }
}
