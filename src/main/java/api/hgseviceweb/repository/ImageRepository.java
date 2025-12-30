package api.hgseviceweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import api.hgseviceweb.entity.DB_IMAGE;

public interface  ImageRepository extends  JpaRepository<DB_IMAGE, Long>,JpaSpecificationExecutor<DB_IMAGE>{
    DB_IMAGE findByRefId(Long refId);
    DB_IMAGE findByRefIdAndType(Long refId,String type);
    List<DB_IMAGE> findAllByRefIdAndType(Long refId,String type);
}
