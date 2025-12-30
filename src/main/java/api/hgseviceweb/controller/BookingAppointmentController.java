package api.hgseviceweb.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentDataModel;
import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentFilterDataModel;
import api.hgseviceweb.helper.BookingAppointmentHelper;
import api.hgseviceweb.helper.UserHelper;
import api.hgseviceweb.implement_service.BookingAppointmentImplement;
import api.hgseviceweb.implement_service.CarImplement;
import api.hgseviceweb.implement_service.ServiceTypeImplement;
import api.hgseviceweb.repository.BookingAppointmentRepository;
import api.hgseviceweb.security.ApiResponseHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookingAppointmentController {
    private final BookingAppointmentImplement bookingAppointmentImplement;
    private final BookingAppointmentRepository bookingAppointmentRepository;
    private final CarImplement carImplement;
    private final ServiceTypeImplement serviceTypeImplement;

    public ResponseEntity<?> List(BookingAppointmentFilterDataModel filter) {
        try {
            var result = bookingAppointmentImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(BookingAppointmentDataModel model) {
        try {
            String[] splitServiceId = model.getServiceId().split(",");
            for (String service : splitServiceId) {
                if(!serviceTypeImplement.IsExistService(Long.parseLong(service))) {
                    return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Service was not found!"),
                        HttpStatus.BAD_REQUEST);
                } 
            }
           
            if(!carImplement.IsExistedCar(model.getCarId())) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Car was not found!"),
                    HttpStatus.BAD_REQUEST);
            } 
            var result = bookingAppointmentImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(BookingAppointmentDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            String[] splitServiceId = model.getServiceId().split(",");
            for (String service : splitServiceId) {
                if(!serviceTypeImplement.IsExistService(Long.parseLong(service))) {
                    return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Service was not found!"),
                        HttpStatus.BAD_REQUEST);
                } 
            }
            if(!carImplement.IsExistedCar(model.getCarId())) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Car was not found!"),
                    HttpStatus.BAD_REQUEST);
            } 
            var isExisted = bookingAppointmentRepository.findById(model.getId());
            if (!isExisted.isPresent()){
                return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
            }
            var result = bookingAppointmentImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = bookingAppointmentRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(BookingAppointmentHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        var result = bookingAppointmentImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> ChangeStatus(Long id,Boolean status) {
        var isExisted = bookingAppointmentRepository.findById(id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(BookingAppointmentHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        if(isExisted.get().getIsComplete().booleanValue()==status){
             return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Current your status have change already!"),HttpStatus.BAD_REQUEST); 
        }
        var result = bookingAppointmentImplement.ChangeStatus(id,status);
        return ResponseEntity.ok(new ApiResponseHandler().SetSuccess(result));
    }

}
