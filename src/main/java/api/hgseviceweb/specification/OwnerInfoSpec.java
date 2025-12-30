package api.hgseviceweb.specification;

import org.springframework.data.jpa.domain.Specification;

import api.hgseviceweb.entity.DB_OWNER_INFO;

public class OwnerInfoSpec {
    public static Specification<DB_OWNER_INFO> Search(String search) {
        return (root, query, builder) -> {
            if(search==null) return builder.conjunction();
            return builder.or(
                builder.like(root.get("DB_CODE"),"%"+search+"%")
            );
        };
    }
    public static Specification<DB_OWNER_INFO> OrderDir(String dir,String orderBy) {
        return (root, query, builder) -> {
            query.orderBy(builder.desc(root.get("id")));
            if(orderBy==null || orderBy.isEmpty()) return builder.conjunction();
            String dirr = dir == null ?"desc":dir;
            if(dirr.equals("asc")) query.orderBy(builder.asc(root.get(orderBy)));
            else if (dirr.equals("desc")) query.orderBy(builder.desc(root.get(orderBy)));
            return builder.conjunction();
        };
    }
    public static Specification<DB_OWNER_INFO> SearchCode(String Code){
        return (root,query,builder)->{
            if(Code.isEmpty()) return builder.conjunction();
            builder.equal(root.get("USER_CODE"), Code);
            return builder.conjunction();
        };
    }
    public static Specification<DB_OWNER_INFO> FilterStatus(Boolean status){
        return (root,query,builder)->{
            builder.equal(root.get("STATUS"), status);
            return builder.conjunction();
        };
    }
}
