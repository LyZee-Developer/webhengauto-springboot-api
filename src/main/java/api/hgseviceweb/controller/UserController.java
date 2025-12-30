package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.user.UserDataModel;
import api.hgseviceweb.data_model.user.UserFilterDataModel;
import api.hgseviceweb.helper.UserHelper;
import api.hgseviceweb.implement_service.UserImplement;
import api.hgseviceweb.repository.UserRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserController {
    private final UserImplement userImplement;
    private final UserRepository userRepository;

    public ResponseEntity<?> List(UserFilterDataModel filter) {
        try {
            var result = userImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(UserDataModel model) {
        try {
            
            if (model.getUserCode().isEmpty()){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field usercode is required!"),HttpStatus.BAD_REQUEST);
            }
            var existedCode = userImplement.CheckCode(model.getUserCode(),0L);
            if(existedCode) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("UserCode already existed!"),HttpStatus.NOT_FOUND);
            var result = userImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(UserDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            if (model.getUserCode().isEmpty()){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field usercode is required!"),
                    HttpStatus.BAD_REQUEST);
            }
            var existedCode = userImplement.CheckCode(model.getUserCode(),model.getId());
            if(existedCode) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("UserCode already existed!"),HttpStatus.NOT_FOUND);
            var isExisted = userRepository.findById(model.getId());
            if (!isExisted.isPresent())
                return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
            var result = userImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = userRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        var result = userImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> CheckCode(String Code) {
        var result = userImplement.CheckCode(Code,0L);
        return  ResponseEntity.ok(result);
    }
    public ResponseEntity<?> DeleteImage(Long Id) {
        var result = userImplement.DeleteImage(Id);
        return  ResponseEntity.ok(result);
    }
}
