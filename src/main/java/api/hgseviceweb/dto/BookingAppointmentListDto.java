package api.hgseviceweb.dto;
import java.util.Date;

public interface BookingAppointmentListDto {
    Long getId();
    String getFullname();
    String getEmail();
    String getPhone();
    String getPhone1();
    String getServiceId();
    String getServiceName();
    String getServiceEnglishName();
    String getProblem();
    Long getCarId();
    String getCarName();
    String getCarEnglishName();
    String getYears();
    Boolean getIsComplete();
    String getCreatedBy();
    String getUpdatedBy();
    Date getCreatedDate();
    Date getUpdatedDate();
}

