package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.car.CarDataModel;
import api.hgseviceweb.data_model.car.CarFilterDataModel;
import api.hgseviceweb.helper.CarHelper;
import api.hgseviceweb.implement_service.CarImplement;
import api.hgseviceweb.repository.CarRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class CarController {
    private final CarImplement carImplement;
    private final CarRepository carRepository;
    
    public  ResponseEntity<?> List(CarFilterDataModel filter){
        try {
            var result = carImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(CarDataModel model){
        try {
            var result = carImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
               return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public  ResponseEntity<?> Update(CarDataModel model){
        try {
            if(Objects.isNull(model.getId()) || model.getId() <1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),HttpStatus.BAD_REQUEST);
            }
            var isExisted = carRepository.findById(model.getId());
            if(!isExisted.isPresent()) return  new ApiResponseHandler().SetDetail(CarHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
             var result = carImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = carRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(CarHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = carImplement.Delete(Id);
        carImplement.DeleteImage(Id);
        return ResponseEntity.ok(result);
    }

    public  ResponseEntity<?> DeleteImage(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("imageId is required!",HttpStatus.BAD_REQUEST);
        var result = carImplement.DeleteImage(Id);
        return ResponseEntity.ok(result);
    }

    
}
