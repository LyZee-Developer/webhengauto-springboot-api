package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_PORTFOLIO;

public interface  PortfolioRepository extends  JpaRepository<DB_PORTFOLIO, Long>,JpaSpecificationExecutor<DB_PORTFOLIO>{
}
