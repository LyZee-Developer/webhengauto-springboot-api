package api.hgseviceweb.data_model.booking_appointment;

import api.hgseviceweb.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingAppointmentDataModel extends  IBaseDataModel{
    public Long id;
    @Size(max = 50, message = "Full Name cannot exceed 50 characters")
    private String fullName;
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;
    @Size(max = 20, message = "Phone cannot exceed 20 characters")
    private String phone;
    @Size(max = 20)
    private String phone1;
    @Size(max = 1000, message = "Problem cannot exceed 1000 characters")
    private String problem;
    private String serviceId;
    private Long carId;
    private String year;
    private Boolean isComplete;
}
