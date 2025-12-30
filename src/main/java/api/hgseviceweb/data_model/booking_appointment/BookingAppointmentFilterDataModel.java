package api.hgseviceweb.data_model.booking_appointment;

import api.hgseviceweb.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BookingAppointmentFilterDataModel extends IBaseFilterDataModel  {
    private Boolean isComplete;
}
