package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.block_content.BlockContentDataModel;
import api.hgseviceweb.data_model.block_content.BlockContentFilterDataModel;
import api.hgseviceweb.dto.BlockContentDto;

@Service
public interface BlockContentService {
    List<BlockContentDto> List(BlockContentFilterDataModel filter);
    BlockContentDto Create(BlockContentDataModel model);
    BlockContentDto Update(BlockContentDataModel model);
    Boolean Delete(Long Id);
    Boolean IsExistedCar(Long CarId);
}
