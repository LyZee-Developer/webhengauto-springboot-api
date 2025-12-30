package api.hgseviceweb.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.auth_access.AuthAccessDataModel;
import api.hgseviceweb.data_model.auth_access.AuthAccessFilterDataModel;
import api.hgseviceweb.dto.AuthAccessDto;
import api.hgseviceweb.helper.GlobalHelper;
import api.hgseviceweb.mapper.AuthAccessMapper;
import api.hgseviceweb.repository.AuthAccessRepository;
import api.hgseviceweb.service.AuthAccessService;
import api.hgseviceweb.specification.AuthAccessSpec;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class AuthAccessImplement implements  AuthAccessService {
    private final AuthAccessRepository  authAccessRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<AuthAccessDto> List(AuthAccessFilterDataModel filter){
        var list = authAccessRepository.findAll(AuthAccessSpec.Search(filter.getSearch()).and(AuthAccessSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
       
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        var total = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->AuthAccessMapper.MaptoDto(s,total)).collect(Collectors.toList());
    }

    @Override
    public  AuthAccessDto  Create(AuthAccessDataModel model){
        String hashedPassword = passwordEncoder.encode(model.getPassword());
        model.setPassword(hashedPassword);
        var mapData = AuthAccessMapper.MaptoEntity(model);
        var data = authAccessRepository.save(mapData);
        var result = AuthAccessMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public AuthAccessDto Update(AuthAccessDataModel model){
        var data = authAccessRepository.findById(model.getId()).get();
        String hashedPassword = passwordEncoder.encode(model.getPassword());
        data.setPassword(hashedPassword);
        data.setUserId(model.getUserId());
        data.setUsername(model.getUserName());
        data.setStatus(model.getStatus());
        data.setUpdatedDate(new Date());
        data.setUpdatedBy(GlobalHelper.Str.ADMIN);
        authAccessRepository.save(data);
        var result = AuthAccessMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        authAccessRepository.deleteById(Id);
        return true;
    }

    @Override
    public Boolean IsLoginSuccess(String username,String password){
        var usernameLog = authAccessRepository.findAll().stream().filter(s->s.getUsername().equals(username)).findFirst();
        if(usernameLog.isEmpty()) return false;
        var user = usernameLog.get();
        boolean isMatch = passwordEncoder.matches(password, user.getPassword());
        return  isMatch;
    }

    @Override
    public Boolean CheckUsername(String name,Long Id){
        var isExisted = authAccessRepository.findAll().stream().filter(s->s.getUsername().equals(name)).collect(Collectors.toList());
        if(Id>0){
            isExisted = isExisted.stream().filter(s->!s.getId().equals(Id)).collect(Collectors.toList());
        }
        return  !isExisted.isEmpty();
    }
    
}
