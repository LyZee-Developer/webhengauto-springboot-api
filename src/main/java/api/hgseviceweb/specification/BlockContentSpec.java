package api.hgseviceweb.specification;

import org.springframework.data.jpa.domain.Specification;

import api.hgseviceweb.entity.DB_BLOCK_CONTENT;

public class BlockContentSpec {
    public static Specification<DB_BLOCK_CONTENT> Search(String search) {
        return (root, query, builder) -> {
            if(search==null) return builder.conjunction();
            return builder.or(
                builder.like(root.get("dbCode"),"%"+search+"%"),
                builder.like(root.get("titleEnglish"),"%"+search+"%"),
                builder.like(root.get("title"),"%"+search+"%")
            );
        };
    }
    public static Specification<DB_BLOCK_CONTENT> OrderDir(String dir,String orderBy) {
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
