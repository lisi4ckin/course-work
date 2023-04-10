package fishclub.ru.fishclubserver.mapper.reference;

import fishclub.ru.fishclubserver.dto.lake.LakeReferenceDto;
import fishclub.ru.fishclubserver.entity.Lake;
import fishclub.ru.fishclubserver.service.lake.LakeService;
import jakarta.annotation.Resource;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class LakeReferenceMapper {

    @Resource
    private LakeService lakeService;

    @Named("lakeReferenceBase")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "referenceName", source = "lakeName")
    public abstract LakeReferenceDto mapToDto(Lake entity);
    @InheritConfiguration
    public abstract List<LakeReferenceDto> mapToDto(List<Lake> entity);

    @Named("baseLakeMapper")
    public Lake mapToEntity(LakeReferenceDto dto) {
        return lakeService.getLakeById(Long.parseLong(dto.getId()));
    }
    @InheritConfiguration
    public List<Lake> mapToEntity(List<LakeReferenceDto> dto) {
        List<Long> ids = dto.stream().map(i -> Long.parseLong(i.getId())).toList();
        return lakeService.getLakesByIds(ids);
    }

}
