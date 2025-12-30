package api.hgseviceweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_BLOCK_CONTENT;

public interface  BlockContentRepository extends  JpaRepository<DB_BLOCK_CONTENT, Long>,JpaSpecificationExecutor<DB_BLOCK_CONTENT>{
    List<DB_BLOCK_CONTENT> findByType(String type);
}
