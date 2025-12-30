package api.hgseviceweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import api.hgseviceweb.dto.BookingAppointmentListDto;
import api.hgseviceweb.entity.DB_BOOKING_APPOINTMENT;

public interface BookingAppointmentRepository extends  JpaRepository<DB_BOOKING_APPOINTMENT, Long> ,JpaSpecificationExecutor<DB_BOOKING_APPOINTMENT>{
    @Query(value="""
                SELECT 
                bk.id Id,
                bk.full_name  Fullname,
                bk.email Email,
                bk.phone Phone,
                sv.id ServiceId,
                sv.name ServiceName,
                sv.name_en ServiceEnglishName,
                bk.problem Problem,
                car.id CarId,
                car.name CarName,
                car.name_en CarEnglishName,
                bk.year Years,
                bk.is_complete IsComplete,
                bk.created_by CreatedBy,
                bk.updated_by UpdatedBy,
                bk.created_date CreatedDate,
                bk.updated_date UpdatedDate
                FROM db_booking_appointment bk
                INNER JOIN db_car car
                ON car.id = bk.car_id
                INNER JOIN db_service_type sv
                ON sv.id = bk.service_id """, nativeQuery = true)
    List<BookingAppointmentListDto> GetListByJoin();
}
