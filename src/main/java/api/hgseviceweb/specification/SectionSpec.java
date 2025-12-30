package api.hgseviceweb.specification;

import org.springframework.data.jpa.domain.Specification;

import api.hgseviceweb.entity.DB_SECTION;

public class SectionSpec {
    public static Specification<DB_SECTION> Search(String search) {
        return (root, query, builder) -> {
            if(search==null) return builder.conjunction();
            return builder.or(
                builder.like(root.get("DB_CODE"),"%"+search+"%"),
                builder.like(root.get("NAME_EN"),"%"+search+"%"),
                builder.like(root.get("NAME"),"%"+search+"%")
            );
        };
    }
    public static Specification<DB_SECTION> OrderDir(String dir,String orderBy) {
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
