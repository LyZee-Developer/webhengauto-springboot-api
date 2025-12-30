package api.hgseviceweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.partner_support.PartnerSupportDataModel;
import api.hgseviceweb.data_model.partner_support.PartnerSupportFilterDataModel;
import api.hgseviceweb.dto.PartnerSupportDto;

@Service
public interface PartnerSupportService {
    List<PartnerSupportDto> List(PartnerSupportFilterDataModel filter);
    PartnerSupportDto Create(PartnerSupportDataModel model);
    PartnerSupportDto Update(PartnerSupportDataModel model);
    Boolean Delete(Long Id);
    Boolean DeleteImage(Long Id);
}
