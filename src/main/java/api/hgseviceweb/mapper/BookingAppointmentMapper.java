package api.hgseviceweb.mapper;


import java.util.Date;

import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentDataModel;
import api.hgseviceweb.dto.BookingAppointmentDto;
import api.hgseviceweb.dto.BookingAppointmentListDto;
import api.hgseviceweb.entity.DB_BOOKING_APPOINTMENT;
import api.hgseviceweb.helper.GlobalHelper;

public class BookingAppointmentMapper {
    public  static DB_BOOKING_APPOINTMENT MaptoEntity(BookingAppointmentDataModel model){
        var data = new DB_BOOKING_APPOINTMENT();
        data.setFullName(model.getFullName());
        data.setEmail(model.getEmail());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone1());
        data.setProblem(model.getProblem());
        data.setServiceId(model.getServiceId());
        data.setIsComplete(false);
        data.setYear(model.getYear());
        data.setCarId(model.getCarId());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static BookingAppointmentDto MaptoDto(DB_BOOKING_APPOINTMENT model,int recordCount){
        var data = new BookingAppointmentDto();
        data.setId(model.getId());
        data.setFullName(model.getFullName());
        data.setEmail(model.getEmail());
        data.setCarId(model.getCarId());
        data.setPhone(model.getPhone());
        data.setYears(model.getYear());
        data.setServiceId(model.getServiceId());
        data.setIsComplete(model.getIsComplete());
        data.setProblem(model.getProblem());
        // data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
    public  static BookingAppointmentDto MaptoList(BookingAppointmentListDto model,int recordCount){
        var data = new BookingAppointmentDto();
        data.setId(model.getId());
        data.setFullName(model.getFullname());
        data.setEmail(model.getEmail());
        data.setCarId(model.getCarId());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone1());
        data.setYears(model.getYears());
        data.setCarEnglishName(model.getCarEnglishName());
        data.setCarName(model.getCarName());
        data.setServiceId(model.getServiceId());
        data.setServiceEnglishName(model.getServiceEnglishName());
        data.setServiceName(model.getServiceName());
        data.setIsComplete(model.getIsComplete());
        data.setProblem(model.getProblem());
        data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
