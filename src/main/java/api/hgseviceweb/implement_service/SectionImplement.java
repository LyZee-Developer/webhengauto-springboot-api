package api.hgseviceweb.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.section.SectionDataModel;
import api.hgseviceweb.data_model.section.SectionFilterDataModel;
import api.hgseviceweb.dto.SectionDto;
import api.hgseviceweb.mapper.SectionMapper;
import api.hgseviceweb.repository.SectionRepository;
import api.hgseviceweb.service.SectionService;
import api.hgseviceweb.specification.SectionSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SectionImplement implements  SectionService {
    private final SectionRepository  sectionRepository;
    @Override
    public List<SectionDto> List(SectionFilterDataModel filter){
        var list = sectionRepository.findAll(SectionSpec.Search(filter.getSearch()).and(SectionSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
       
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->SectionMapper.MaptoDto(s)).collect(Collectors.toList());
    }

    @Override
    public  SectionDto  Create(SectionDataModel model){
        var mapData = SectionMapper.MaptoEntity(model);
        var data = sectionRepository.save(mapData);
        var result = SectionMapper.MaptoDto(data);
        return result;
    }

    @Override
    public SectionDto Update(SectionDataModel model){
        var data = sectionRepository.findById(model.getId()).get();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setUpdatedBy(model.getUsername());
        data.setStatus(model.getStatus());
        data.setUpdatedDate(new Date());
        data.setDbCode(model.getDatabase());
        sectionRepository.save(data);
        var result = SectionMapper.MaptoDto(data);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        sectionRepository.deleteById(Id);
        return true;
    }
   
    
}
