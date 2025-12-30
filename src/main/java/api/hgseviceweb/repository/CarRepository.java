package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_CAR;

public interface  CarRepository extends  JpaRepository<DB_CAR, Long>,JpaSpecificationExecutor<DB_CAR>{
}
