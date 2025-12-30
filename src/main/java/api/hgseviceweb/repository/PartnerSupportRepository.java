package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_PARTNER_SUPPORT;

public interface  PartnerSupportRepository extends  JpaRepository<DB_PARTNER_SUPPORT, Long>,JpaSpecificationExecutor<DB_PARTNER_SUPPORT>{
}
