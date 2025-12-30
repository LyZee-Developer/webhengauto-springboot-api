package api.hgseviceweb.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingAppointmentDto {
    private Long id;
    private String fullName;
    private String email;
    private String  phone;
    private String  phone1;
    private String serviceId;
    private String serviceName;
    private String serviceEnglishName;
    private String  problem;
    private Long carId;
    private String  carName;
    private String  carEnglishName;
    private String  years;
    private int  recordCount;
    private Boolean  isComplete;
    private String  createdBy;
    private String  updatedBy;
    private Date  createdDate;
    private Date  updatedDate;
}

