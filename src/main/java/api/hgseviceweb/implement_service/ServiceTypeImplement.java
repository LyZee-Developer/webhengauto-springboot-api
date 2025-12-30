package api.hgseviceweb.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.service_type.ServiceTypeDataModel;
import api.hgseviceweb.data_model.service_type.ServiceTypeFilterDataModel;
import api.hgseviceweb.dto.ServiceTypeDto;
import api.hgseviceweb.helper.GlobalHelper;
import api.hgseviceweb.mapper.ServiceTypeMapper;
import api.hgseviceweb.repository.ServiceTypeRepository;
import api.hgseviceweb.service.ServiceTypeService;
import api.hgseviceweb.specification.ServiceTypeSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceTypeImplement implements  ServiceTypeService {
    private final ServiceTypeRepository  serviceTypeRepository;
    @Override
    public List<ServiceTypeDto> List(ServiceTypeFilterDataModel filter){
        var list = serviceTypeRepository.findAll(ServiceTypeSpec.Search(filter.getSearch()).and(ServiceTypeSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
      
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
        if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->ServiceTypeMapper.MaptoDto(s,totalRecord)).collect(Collectors.toList());
    }

    @Override
    public  ServiceTypeDto  Create(ServiceTypeDataModel model){
        var mapData = ServiceTypeMapper.MaptoEntity(model);
        var data = serviceTypeRepository.save(mapData);
        var result = ServiceTypeMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public ServiceTypeDto Update(ServiceTypeDataModel model){
        var data = serviceTypeRepository.findById(model.getId()).get();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setUpdatedBy(GlobalHelper.Str.ADMIN);
        data.setStatus(model.getStatus());
        data.setUpdatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        serviceTypeRepository.save(data);
        var result = ServiceTypeMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        serviceTypeRepository.deleteById(Id);
        return true;
    }
     @Override
    public Boolean IsExistService(Long Id){
        var service = serviceTypeRepository.findById(Id);
        return service.isPresent();
    }
    
}
