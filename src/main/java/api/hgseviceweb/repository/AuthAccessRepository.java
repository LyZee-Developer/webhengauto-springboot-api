package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_AUTH_ACCESS;

public interface AuthAccessRepository extends  JpaRepository<DB_AUTH_ACCESS, Long> ,JpaSpecificationExecutor<DB_AUTH_ACCESS>{
}
