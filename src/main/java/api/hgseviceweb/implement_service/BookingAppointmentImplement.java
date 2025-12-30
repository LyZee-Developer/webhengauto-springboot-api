package api.hgseviceweb.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentDataModel;
import api.hgseviceweb.data_model.booking_appointment.BookingAppointmentFilterDataModel;
import api.hgseviceweb.dto.BookingAppointmentDto;
import api.hgseviceweb.helper.GlobalHelper;
import api.hgseviceweb.mapper.BookingAppointmentMapper;
import api.hgseviceweb.repository.BookingAppointmentRepository;
import api.hgseviceweb.service.BookingAppointmentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BookingAppointmentImplement implements  BookingAppointmentService {
    private final BookingAppointmentRepository  bookingAppointmentRepository;
    @Override
    public List<BookingAppointmentDto> List(BookingAppointmentFilterDataModel filter){
        // var list = bookingAppointmentRepository.findAll(BookingAppointmentSpec.Search(filter.getSearch()).and(BookingAppointmentSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        var list = bookingAppointmentRepository.GetListByJoin();
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
         if (filter.getIsComplete() != null) {
                list = list.stream()
                        .filter(s -> s.getIsComplete().equals(filter.getIsComplete()))
                        .collect(Collectors.toList());
        }
        var total = list.size();
        if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->BookingAppointmentMapper.MaptoList(s, total)).collect(Collectors.toList());
    }

    @Override
    public  BookingAppointmentDto  Create(BookingAppointmentDataModel model){
        var mapData = BookingAppointmentMapper.MaptoEntity(model);
        var data = bookingAppointmentRepository.save(mapData);
        var result = BookingAppointmentMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public BookingAppointmentDto Update(BookingAppointmentDataModel model){
        var data = bookingAppointmentRepository.findById(model.getId()).get();
        data.setFullName(model.getFullName());
        data.setEmail(model.getEmail());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone());
        data.setProblem(model.getProblem());
        data.setServiceId(model.getServiceId());
        data.setIsComplete(model.getIsComplete());
        data.setYear(model.getYear());
        data.setCarId(model.getCarId());
        data.setUpdatedBy(GlobalHelper.Str.ADMIN);
        data.setUpdatedDate(new Date());
        bookingAppointmentRepository.save(data);
        var result = BookingAppointmentMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        bookingAppointmentRepository.deleteById(Id);
        return true;
    }

    @Override
    public Boolean IsExistedUserById(Long Id){
        var users = bookingAppointmentRepository.findAll().stream().filter(s->s.getId().equals(Id)).collect(Collectors.toList());
        return  users.isEmpty();
    }

    @Override
    public String ChangeStatus(Long Id,Boolean status){
        var getBook = bookingAppointmentRepository.findById(Id);
        var book = getBook.get();
        book.setIsComplete(status);
        book.setUpdatedBy(GlobalHelper.Str.ADMIN);
        book.setUpdatedDate(new Date());
        bookingAppointmentRepository.save(book);
        return  "Change status already";
    }
    
}
