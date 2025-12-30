package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.partner_support.PartnerSupportDataModel;
import api.hgseviceweb.data_model.partner_support.PartnerSupportFilterDataModel;
import api.hgseviceweb.helper.PartnerSupportHelper;
import api.hgseviceweb.implement_service.PartnerSupportImplement;
import api.hgseviceweb.repository.PartnerSupportRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class PartnerSupportController {
    private final PartnerSupportImplement partnerSupportImplement;
    private final PartnerSupportRepository partnerSupportRepository;
    
    public  ResponseEntity<?> List(PartnerSupportFilterDataModel filter){
        try {
            var result = partnerSupportImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(PartnerSupportDataModel model){
        try {
            var result = partnerSupportImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
               return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public  ResponseEntity<?> Update(PartnerSupportDataModel model){
        try {
            if(Objects.isNull(model.getId()) || model.getId() <1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),HttpStatus.BAD_REQUEST);
            }
            var isExisted = partnerSupportRepository.findById(model.getId());
            if(!isExisted.isPresent()) return  new ApiResponseHandler().SetDetail(PartnerSupportHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
             var result = partnerSupportImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = partnerSupportRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(PartnerSupportHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = partnerSupportImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

     public  ResponseEntity<?> DeleteImage(Long Id){
         if(Id < 1 ) return new ApiResponseHandler().SetDetail("imageId is required!",HttpStatus.BAD_REQUEST);
        var result = partnerSupportImplement.DeleteImage(Id);
        return ResponseEntity.ok(result);
    }
}
