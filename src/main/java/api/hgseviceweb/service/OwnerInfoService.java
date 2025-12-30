package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.owner_info.OwnerInfoDataModel;
import api.hgseviceweb.data_model.owner_info.OwnerInfoFilterDataModel;
import api.hgseviceweb.dto.OwnerInfoDto;

@Service
public interface OwnerInfoService {
    List<OwnerInfoDto> List(OwnerInfoFilterDataModel filter);
    OwnerInfoDto Create(OwnerInfoDataModel model);
    OwnerInfoDto Update(OwnerInfoDataModel model);
    Boolean Delete(Long Id);
    Boolean IsExistedCar(Long CarId);
    Boolean DeleteImage(Long imageId);
}
