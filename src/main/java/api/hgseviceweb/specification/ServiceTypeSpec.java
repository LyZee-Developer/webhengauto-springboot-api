package api.hgseviceweb.specification;

import org.springframework.data.jpa.domain.Specification;

import api.hgseviceweb.entity.DB_SERVICE_TYPE;

public class ServiceTypeSpec {
    public static Specification<DB_SERVICE_TYPE> Search(String search) {
        return (root, query, builder) -> {
            if(search==null || search.equals("")) return builder.conjunction();
            return builder.or(
                builder.like(root.get("dbCode"),"%"+search+"%"),
                builder.like(root.get("nameEn"),"%"+search+"%"),
                builder.like(root.get("name"),"%"+search+"%")
            );
        };
    }
    public static Specification<DB_SERVICE_TYPE> OrderDir(String dir,String orderBy) {
        return (root, query, builder) -> {
            query.orderBy(builder.desc(root.get("id")));
            if(orderBy==null || orderBy.isEmpty()) return builder.conjunction();
            String dirr = dir == null ?"desc":dir;
            if(dirr.equals("asc")) query.orderBy(builder.asc(root.get(orderBy)));
            else if (dirr.equals("desc")) query.orderBy(builder.desc(root.get(orderBy)));
            return builder.conjunction();
        };
    }
}
