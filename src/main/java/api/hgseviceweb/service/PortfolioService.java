package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.portfolio.PortfolioDataModel;
import api.hgseviceweb.data_model.portfolio.PortfolioFilterDataModel;
import api.hgseviceweb.dto.PortfolioDto;

@Service
public interface PortfolioService {
    List<PortfolioDto> List(PortfolioFilterDataModel filter);
    PortfolioDto Create(PortfolioDataModel model);
    Boolean Delete(Long Id);
    Boolean DeleteImage(Long imageId);
}
