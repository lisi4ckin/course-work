package fishclub.ru.fishclubserver.mapper.fish;

import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;
import fishclub.ru.fishclubserver.entity.Fish;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        imports = {}, uses = {Long.class})
public interface FishMapper {

    @Named("baseFishMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "startDateOfProhibition", source = "startDateOfProhibition")
    @Mapping(target = "endDateOfProhibition", source = "endDateOfProhibition")
    @Mapping(target = "fishName", source = "fishName")
    @Mapping(target = "averageWeight", source = "avgWeight")
    Fish mapToEntity(FishRequestDto dto);

    @Named("baseResponseFish")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(entity.getId().toString())")
    @Mapping(target = "fishName", source = "fishName")
    @Mapping(target = "avgWeight", source = "averageWeight")
    @Mapping(target = "startDateOfProhibition", source = "startDateOfProhibition")
    @Mapping(target = "endDateOfProhibition", source = "endDateOfProhibition")
    FishResponseDto mapToDto(Fish entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fishermen", ignore = true)
    @Mapping(target = "averageWeight")
    @Mapping(target = "fishName")
    @Mapping(target = "baits")
    @Mapping(target = "startDateOfProhibition")
    @Mapping(target = "endDateOfProhibition")
    @Mapping(target = "findInLakes")
    void updateFish(Fish curFish, @MappingTarget Fish updFish);

}
