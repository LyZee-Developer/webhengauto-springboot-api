package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentDataModel;
import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentFilterDataModel;
import api.hgseviceweb.dto.BookingAppointmentDto;

@Service
public interface BookingAppointmentService {
    List<BookingAppointmentDto> List(BookingAppointmentFilterDataModel filter);
    BookingAppointmentDto Create(BookingAppointmentDataModel model);
    BookingAppointmentDto Update(BookingAppointmentDataModel model);
    Boolean Delete(Long Id);
    String ChangeStatus(Long Id,Boolean status);
    Boolean IsExistedUserById(Long Id);
}
