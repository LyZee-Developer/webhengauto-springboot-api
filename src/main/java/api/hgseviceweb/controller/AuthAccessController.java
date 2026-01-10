package api.hgseviceweb.controller;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.auth_access.AuthAccessDataModel;
import api.hgseviceweb.data_model.auth_access.AuthAccessFilterDataModel;
import api.hgseviceweb.helper.AuthAccessHelper;
import api.hgseviceweb.helper.UserHelper;
import api.hgseviceweb.implement_service.AuthAccessImplement;
import api.hgseviceweb.implement_service.UserImplement;
import api.hgseviceweb.repository.AuthAccessRepository;
import api.hgseviceweb.security.ApiResponseHandler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthAccessController {
    private final AuthAccessImplement authAccessImplement;
    private final AuthAccessRepository authAccessRepository;
    private final UserImplement userImplement;

    public ResponseEntity<?> List(AuthAccessFilterDataModel filter) {
        try {
            var result = authAccessImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(AuthAccessDataModel model) {
        try {
            // if (Objects.isNull(model.getUserId()) || model.getUserId() < 1) {
            //     return new ResponseEntity<>(new ApiResponseHandler().SetDetail("UserId is required!"),
            //             HttpStatus.BAD_REQUEST);
            // }
            // var checkType = AuthAccessHelper.Type.Type.contains(model.getType());
            // if(!checkType) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Invalid type A(Admin) O(Other))!"),HttpStatus.BAD_REQUEST);
            //  var ListType = authAccessRepository.findAll().stream().filter(s ->s.getType().trim().equals(model.getType()) && s.getStatus() && s.getUserId().longValue()==model.getUserId()).collect(Collectors.toList());
            // if(!ListType.isEmpty()){
            //      return new ResponseEntity<>(new ApiResponseHandler().SetDetail("This user have already type"+(model.getType().trim().equals("A")?"(Admin)":"(Other)")),HttpStatus.BAD_REQUEST);
            // }
            // var existed = userImplement.IsExistedUserById(model.getUserId());
            // if(existed) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("User not found"),HttpStatus.NOT_FOUND);
            // var existedName = authAccessImplement.CheckUsername(model.getUserName(),0L);
            // if(existedName) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Username have already!"),HttpStatus.NOT_FOUND);
            var result = authAccessImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(AuthAccessDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            if (Objects.isNull(model.getUserId()) || model.getUserId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("UserId is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            var checkType = AuthAccessHelper.Type.Type.contains(model.getType());
            if(!checkType) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Invalid type A(Admin) O(Other))!"),HttpStatus.BAD_REQUEST);
            var existed = userImplement.IsExistedUserById(model.getUserId());
            if(existed) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("User not found"),HttpStatus.NOT_FOUND);
            var existedName = authAccessImplement.CheckUsername(model.getUserName(),model.getId());
            if(existedName) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Username have already!"),HttpStatus.NOT_FOUND);
            }
            var isExisted = authAccessRepository.findById(model.getId());
            if (!isExisted.isPresent())
                return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
            var result = authAccessImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = authAccessRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(AuthAccessHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        var result = authAccessImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> IsLoginSuccess(String username,String password) {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            return new ApiResponseHandler().SetDetail(AuthAccessHelper.Message.RequiredUserPw, HttpStatus.NOT_FOUND);
        }
        var result = authAccessImplement.IsLoginSuccess(username,password);
        return  ResponseEntity.ok(result);
    }
}
