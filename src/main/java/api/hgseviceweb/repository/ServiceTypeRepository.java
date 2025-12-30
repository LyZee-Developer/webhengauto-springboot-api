package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_SERVICE_TYPE;

public interface  ServiceTypeRepository extends  JpaRepository<DB_SERVICE_TYPE, Long>,JpaSpecificationExecutor<DB_SERVICE_TYPE>{
}
