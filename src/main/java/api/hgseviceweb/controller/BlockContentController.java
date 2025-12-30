package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.block_content.BlockContentDataModel;
import api.hgseviceweb.data_model.block_content.BlockContentFilterDataModel;
import api.hgseviceweb.helper.BlockContentHelper;
import api.hgseviceweb.implement_service.BlockContentImplement;
import api.hgseviceweb.repository.BlockContentRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class BlockContentController {
    private final BlockContentImplement blockContentImplement;
    private final BlockContentRepository blockContentRepository;
    
    public  ResponseEntity<?> List(BlockContentFilterDataModel filter){
        try {
            var result = blockContentImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(BlockContentDataModel model){
        try {
            if(!BlockContentHelper.Type.Type.contains(model.getType())){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Invalid type!"),HttpStatus.BAD_REQUEST);
            }
            var types = blockContentRepository.findByType(model.getType());
            if(types.size()>0) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("We have this content already!"),HttpStatus.BAD_REQUEST);
            }
            var result = blockContentImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
               return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public  ResponseEntity<?> Update(BlockContentDataModel model){ 
        try {
            if(Objects.isNull(model.getId()) || model.getId() <1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),HttpStatus.BAD_REQUEST);
            }
            if(!BlockContentHelper.Type.Type.contains(model.getType())){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Invalid type!"),HttpStatus.BAD_REQUEST);
            }
            var isExistedType = blockContentRepository.findByType(model.getType());
            if(isExistedType!=null) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("We have this content already!"),HttpStatus.BAD_REQUEST);
            }
            var isExisted = blockContentRepository.findById(model.getId());
            if(!isExisted.isPresent()) return  new ApiResponseHandler().SetDetail(BlockContentHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
             var result = blockContentImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = blockContentRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(BlockContentHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = blockContentImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }
}
