package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.section.SectionDataModel;
import api.hgseviceweb.data_model.section.SectionFilterDataModel;
import api.hgseviceweb.dto.SectionDto;

@Service
public interface SectionService {
    List<SectionDto> List(SectionFilterDataModel filter);
    SectionDto Create(SectionDataModel model);
    SectionDto Update(SectionDataModel model);
    Boolean Delete(Long Id);
    
}
