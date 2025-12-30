package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_SECTION;

public interface  SectionRepository extends  JpaRepository<DB_SECTION, Long>,JpaSpecificationExecutor<DB_SECTION>{
}
