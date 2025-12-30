package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.car.CarDataModel;
import api.hgseviceweb.data_model.car.CarFilterDataModel;
import api.hgseviceweb.dto.CarDto;

@Service
public interface CarService {
    List<CarDto> List(CarFilterDataModel filter);
    CarDto Create(CarDataModel model);
    CarDto Update(CarDataModel model);
    Boolean Delete(Long Id);
    Boolean IsExistedCar(Long CarId);
    Boolean DeleteImage(Long imageId);
}
