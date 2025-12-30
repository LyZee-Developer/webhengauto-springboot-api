package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailDataModel;
import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailFilterDataModel;
import api.hgseviceweb.helper.BlockContentDetailHelper;
import api.hgseviceweb.implement_service.BlockContentDetailImplement;
import api.hgseviceweb.repository.BlockContentDetailRepository;
import api.hgseviceweb.repository.BlockContentRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class BlockContentDetailController {
    private final BlockContentDetailImplement blockContentDetailImplement;
    private final BlockContentDetailRepository blockContentDetailRepository;
    private final BlockContentRepository blockContentRepository;
    
    public  ResponseEntity<?> List(BlockContentDetailFilterDataModel filter){
        try {
            var result = blockContentDetailImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(BlockContentDetailDataModel model){
        try {
            var find = blockContentRepository.findById(model.getBlockContentId());
            if(find.isEmpty()) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Block content was not found!"),HttpStatus.BAD_REQUEST);
            var result = blockContentDetailImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
               return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public  ResponseEntity<?> Update(BlockContentDetailDataModel model){ 
        try {
            if(Objects.isNull(model.getId()) || model.getId() <1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),HttpStatus.BAD_REQUEST);
            }
            var isExisted = blockContentDetailRepository.findById(model.getId());
            if(!isExisted.isPresent()) return  new ApiResponseHandler().SetDetail(BlockContentDetailHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
             var result = blockContentDetailImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = blockContentDetailRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(BlockContentDetailHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = blockContentDetailImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }
}
