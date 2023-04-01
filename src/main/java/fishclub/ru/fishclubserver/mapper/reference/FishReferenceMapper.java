package fishclub.ru.fishclubserver.mapper.reference;

import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.entity.Fish;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FishReferenceMapper {

    @Named("fishReferenceBase")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "referenceName", source = "fishName")
    FishReferenceDto mapToDto(Fish entity);

    @InheritConfiguration
    List<FishReferenceDto> mapToDto(List<Fish> entity);
}
