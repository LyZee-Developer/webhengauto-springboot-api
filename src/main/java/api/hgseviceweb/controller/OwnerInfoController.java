package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.owner_info.OwnerInfoDataModel;
import api.hgseviceweb.data_model.owner_info.OwnerInfoFilterDataModel;
import api.hgseviceweb.helper.OwnerInfoHelper;
import api.hgseviceweb.implement_service.OwnerInfoImplement;
import api.hgseviceweb.repository.OwnerInfoRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OwnerInfoController {
    private final OwnerInfoImplement ownerInfoImplement;
    private final OwnerInfoRepository ownerInfoRepository;

    public ResponseEntity<?> List(OwnerInfoFilterDataModel filter) {
        try {
            var result = ownerInfoImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(OwnerInfoDataModel model) {
        try {
            
            var existed = ownerInfoRepository.findAll();
            if(!existed.isEmpty()) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Currently, You have information already!"),
                        HttpStatus.BAD_REQUEST);
            }
            var result = ownerInfoImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(OwnerInfoDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            var isExisted = ownerInfoRepository.findById(model.getId());
            if (!isExisted.isPresent())
                return new ApiResponseHandler().SetDetail(OwnerInfoHelper.Message.NotFound, HttpStatus.NOT_FOUND);
            var result = ownerInfoImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = ownerInfoRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(OwnerInfoHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        var result = ownerInfoImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }
    public  ResponseEntity<?> DeleteImage(Long Id){
         if(Id < 1 ) return new ApiResponseHandler().SetDetail("imageId is required!",HttpStatus.BAD_REQUEST);
        var result = ownerInfoImplement.DeleteImage(Id);
        return ResponseEntity.ok(result);
    }

   
}
