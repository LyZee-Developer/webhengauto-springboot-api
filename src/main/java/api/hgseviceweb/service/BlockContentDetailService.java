package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailDataModel;
import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailFilterDataModel;
import api.hgseviceweb.dto.BlockContentDetailDto;

@Service
public interface BlockContentDetailService {
    List<BlockContentDetailDto> List(BlockContentDetailFilterDataModel filter);
    BlockContentDetailDto Create(BlockContentDetailDataModel model);
    BlockContentDetailDto Update(BlockContentDetailDataModel model);
    Boolean Delete(Long Id);
}
