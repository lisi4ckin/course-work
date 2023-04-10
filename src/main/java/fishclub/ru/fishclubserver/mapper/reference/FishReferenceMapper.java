package fishclub.ru.fishclubserver.mapper.reference;

import fishclub.ru.fishclubserver.dto.base.BaseReferenceDto;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.service.fish.FishService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FishReferenceMapper {

    @Resource(name = "fishService")
    private FishService fishService;

    @Named("fishReferenceBase")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "referenceName", source = "fishName")
    public abstract FishReferenceDto mapToDto(Fish entity);

    @InheritConfiguration
    public abstract List<FishReferenceDto> mapToDto(List<Fish> entity);

    @Named("fishes")
    public Fish mapToEntity(Long fishId) {
        return fishService.getFishById(fishId);
    }
    @InheritConfiguration
    public List<Fish> mapToEntity(List<Long> fishIds) {
        return fishService.getFishesByIds(fishIds);
    }

    @Named("fishesReference")
    public Fish mapRefToEntity(FishReferenceDto reference) {
        return fishService.getFishById(Long.parseLong(reference.getId()));
    }
    @InheritConfiguration
    public List<Fish> mapRefToEntity(List<FishReferenceDto> reference) {
        return fishService.getFishesByIds((List<Long>) reference.stream().map(BaseReferenceDto::getId));
    }
}
