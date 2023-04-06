package fishclub.ru.fishclubserver.mapper.reference;

import fishclub.ru.fishclubserver.dto.bait.BaitReferenceDto;
import fishclub.ru.fishclubserver.entity.Bait;
import fishclub.ru.fishclubserver.service.bait.BaitService;
import jakarta.annotation.Resource;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BaitReferenceMapper {

    @Resource(name = "baitService")
    private BaitService baitService;

    @Named("baitReferenceBase")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "referenceName", source = "baitName")
    public abstract BaitReferenceDto mapToDto(Bait entity);
    @InheritConfiguration
    public abstract List<BaitReferenceDto> mapToDto(List<Bait> entity);

    @Named("baseBaitMapper")
    public Bait mapToEntity(BaitReferenceDto dto) {
        return baitService.getBaitById(Long.parseLong(dto.getId()));
    }
    @InheritConfiguration
    public List<Bait> mapToEntity(List<BaitReferenceDto> dto) {
        List<Long> ids = dto.stream().map(i -> Long.parseLong(i.getId())).toList();
        return baitService.getBaitByIds(ids);
    }
}
