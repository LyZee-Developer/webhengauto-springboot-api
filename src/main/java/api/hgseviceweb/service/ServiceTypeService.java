package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.service_type.ServiceTypeDataModel;
import api.hgseviceweb.data_model.service_type.ServiceTypeFilterDataModel;
import api.hgseviceweb.dto.ServiceTypeDto;

@Service
public interface ServiceTypeService {
    List<ServiceTypeDto> List(ServiceTypeFilterDataModel filter);
    ServiceTypeDto Create(ServiceTypeDataModel model);
    ServiceTypeDto Update(ServiceTypeDataModel model);
    Boolean Delete(Long Id);
    Boolean IsExistService(Long Id);
}
