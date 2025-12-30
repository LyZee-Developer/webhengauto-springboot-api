package api.hgseviceweb.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailDataModel;
import api.hgseviceweb.data_model.block_content_detail.BlockContentDetailFilterDataModel;
import api.hgseviceweb.dto.BlockContentDetailDto;
import api.hgseviceweb.entity.DB_IMAGE;
import api.hgseviceweb.helper.BlockContentDetailHelper;
import api.hgseviceweb.helper.GlobalHelper;
import api.hgseviceweb.mapper.BlockContentDetailMapper;
import api.hgseviceweb.repository.BlockContentDetailRepository;
import api.hgseviceweb.repository.ImageRepository;
import api.hgseviceweb.service.BlockContentDetailService;
import api.hgseviceweb.specification.BlockContentDetailSpec;
import api.hgseviceweb.util.UploadImageHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BlockContentDetailImplement implements  BlockContentDetailService {
    private final BlockContentDetailRepository  blockContentDetailRepository;
    private final ImageRepository  imageRepository;
    @Override
    public List<BlockContentDetailDto> List(BlockContentDetailFilterDataModel filter){
        var list = blockContentDetailRepository.findAll(BlockContentDetailSpec.Search(filter.getSearch()).and(BlockContentDetailSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        if(filter.getId()>0){
            list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        }
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }

        return list.stream().filter(ss->ss.getBlockContentId().equals(filter.getContentBlockId())).map(s->{
            var pathImage = "";
            var img = imageRepository.findByRefIdAndType(s.getId(), BlockContentDetailHelper.FolderName.icon);
            if(img!=null) pathImage = img.getHostImage()+"/"+img.getPathImage();
            return BlockContentDetailMapper.MaptoDto(s,totalRecord,pathImage);
        }).collect(Collectors.toList());
    }

    @Override
    public  BlockContentDetailDto  Create(BlockContentDetailDataModel model){
          var image = new DB_IMAGE();
        var mapData = BlockContentDetailMapper.MaptoEntity(model);
        var data = blockContentDetailRepository.save(mapData);
        var PathImage= "";
        if(model.getUpload()!=null){
            var upload = new UploadImageHandler(BlockContentDetailHelper.FolderName.icon.toLowerCase());
            var dto = upload.Upload(model.getUpload());
            image.setHostImage(dto.getHostName());
            image.setNameImage(dto.getFilename());
            image.setSizeImage(dto.getSize());
            image.setRefId(data.getId());
            image.setType(BlockContentDetailHelper.FolderName.icon);
            image.setTypeImage(dto.getType());
            image.setPathImage(dto.getPathFilename());
            imageRepository.save(image);
            PathImage=image.getHostImage()+"/"+image.getPathImage();
        }
        var result = BlockContentDetailMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public BlockContentDetailDto Update(BlockContentDetailDataModel model){
         var image = imageRepository.findByRefIdAndType(model.getId(), BlockContentDetailHelper.FolderName.icon);
        var upload = new UploadImageHandler(BlockContentDetailHelper.FolderName.icon.toLowerCase());
        var PathImage="";
        var data = blockContentDetailRepository.findById(model.getId()).get();
        data.setUpdatedBy(GlobalHelper.Str.ADMIN);
        data.setTitle(model.getTitle());
        data.setTitleEnglish(model.getTitleEnglish());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setStatus(model.getStatus());
        data.setUpdatedDate(new Date());
        blockContentDetailRepository.save(data);
        if(model.getUpload()!=null){
            if(image!=null) {
                upload.DeleteImage(image.getNameImage());
                imageRepository.delete(image);
            }
            var dto = upload.Upload(model.getUpload());
            var newImg = new DB_IMAGE();
            newImg.setHostImage(dto.getHostName());
            newImg.setNameImage(dto.getFilename());
            newImg.setSizeImage(dto.getSize());
            newImg.setRefId(data.getId());
            newImg.setType(BlockContentDetailHelper.FolderName.icon);
            newImg.setTypeImage(dto.getType());
            newImg.setPathImage(dto.getPathFilename());
            imageRepository.save(newImg);
            PathImage=newImg.getHostImage()+"/"+newImg.getPathImage();
        }
        var result = BlockContentDetailMapper.MaptoDto(data,1,PathImage);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        blockContentDetailRepository.deleteById(Id);
        return true;
    }
    
}
