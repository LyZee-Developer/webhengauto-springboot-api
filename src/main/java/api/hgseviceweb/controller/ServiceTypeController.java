package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.service_type.ServiceTypeDataModel;
import api.hgseviceweb.data_model.service_type.ServiceTypeFilterDataModel;
import api.hgseviceweb.helper.ServiceTypeHelper;
import api.hgseviceweb.implement_service.ServiceTypeImplement;
import api.hgseviceweb.repository.ServiceTypeRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class ServiceTypeController {
    private final ServiceTypeImplement serviceTypeImplement;
    private final ServiceTypeRepository serviceTypeRepository;
    
    public  ResponseEntity<?> List(ServiceTypeFilterDataModel filter){
        try {
            var result = serviceTypeImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(ServiceTypeDataModel model){
        try {
            var result = serviceTypeImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
               return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public  ResponseEntity<?> Update(ServiceTypeDataModel model){
        try {
            if(Objects.isNull(model.getId()) || model.getId() <1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),HttpStatus.BAD_REQUEST);
            }
            var isExisted = serviceTypeRepository.findById(model.getId());
            if(!isExisted.isPresent()) return  new ApiResponseHandler().SetDetail(ServiceTypeHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
             var result = serviceTypeImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = serviceTypeRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(ServiceTypeHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = serviceTypeImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }
}
