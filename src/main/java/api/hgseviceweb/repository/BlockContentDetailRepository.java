package api.hgseviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_BLOCK_CONTENT_DEL;

public interface  BlockContentDetailRepository extends  JpaRepository<DB_BLOCK_CONTENT_DEL, Long>,JpaSpecificationExecutor<DB_BLOCK_CONTENT_DEL>{
}
