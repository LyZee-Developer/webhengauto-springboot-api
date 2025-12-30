package api.hgseviceweb.specification;

import org.springframework.data.jpa.domain.Specification;

import api.hgseviceweb.entity.DB_BOOKING_APPOINTMENT;

public class BookingAppointmentSpec{
    public static Specification<DB_BOOKING_APPOINTMENT> Search(String search) {
        return (root, query, builder) -> {
            if(search==null) return builder.conjunction();
            return builder.or(
                builder.like(root.get("DB_CODE"),"%"+search+"%"),
                builder.like(root.get("FULL_NAME"),"%"+search+"%"),
                builder.like(root.get("EMAIL"),"%"+search+"%"),
                builder.like(root.get("PHONE"),"%"+search+"%")
            );
        };
    }
    public static Specification<DB_BOOKING_APPOINTMENT> OrderDir(String dir,String orderBy) {
        return (root, query, builder) -> {
            query.orderBy(builder.desc(root.get("id")));
            if(orderBy==null || orderBy.isEmpty()) return builder.conjunction();
            String dirr = dir == null ?"desc":dir;
            if(dirr.equals("asc")) query.orderBy(builder.asc(root.get(orderBy)));
            else if (dirr.equals("desc")) query.orderBy(builder.desc(root.get(orderBy)));
            return builder.conjunction();
        };
    }
    public static Specification<DB_BOOKING_APPOINTMENT> SearchCode(String Code){
        return (root,query,builder)->{
            if(Code.isEmpty()) return builder.conjunction();
            builder.equal(root.get("USER_CODE"), Code);
            return builder.conjunction();
        };
    }
}
