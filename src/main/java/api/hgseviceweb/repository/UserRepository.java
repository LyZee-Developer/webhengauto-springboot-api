package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_USER;

public interface UserRepository extends  JpaRepository<DB_USER, Long> ,JpaSpecificationExecutor<DB_USER>{
}
