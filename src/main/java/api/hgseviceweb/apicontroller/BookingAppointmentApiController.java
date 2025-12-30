package api.hgseviceweb.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.hgseviceweb.controller.BookingAppointmentController;
import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentDataModel;
import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentFilterDataModel;
import api.hgseviceweb.helper.BookingAppointmentHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class BookingAppointmentApiController {
    private final BookingAppointmentController bookingAppointmentController;

    @PostMapping(BookingAppointmentHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody BookingAppointmentFilterDataModel filer){
        var result = bookingAppointmentController.List(filer);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(BookingAppointmentHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody BookingAppointmentDataModel model){
        var result = bookingAppointmentController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(BookingAppointmentHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody BookingAppointmentDataModel model){
        var result = bookingAppointmentController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @GetMapping(BookingAppointmentHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="Id") Long Id){
        var result = bookingAppointmentController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
    @GetMapping(BookingAppointmentHelper.URL.ChangeStatus)
    public ResponseEntity<?> ChangeStatus(@RequestParam(value="Id") Long Id,@RequestParam(value="Status") Boolean status){
        var result = bookingAppointmentController.ChangeStatus(Id,status);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
   
}
