package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_OWNER_INFO;

public interface  OwnerInfoRepository extends  JpaRepository<DB_OWNER_INFO, Long>,JpaSpecificationExecutor<DB_OWNER_INFO>{
}
