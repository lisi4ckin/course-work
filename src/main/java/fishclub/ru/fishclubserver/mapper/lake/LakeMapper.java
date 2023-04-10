package fishclub.ru.fishclubserver.mapper.lake;

import fishclub.ru.fishclubserver.dto.lake.LakeRequestDto;
import fishclub.ru.fishclubserver.dto.lake.LakeResponseDto;
import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.entity.Lake;
import fishclub.ru.fishclubserver.mapper.reference.FishReferenceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        imports = {}, uses = {FishReferenceMapper.class})
public interface LakeMapper {

    @Named("baseLakeMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "startSeasonDate", source = "startSeasonDate")
    @Mapping(target = "endSeasonDate", source = "endSeasonDate")
    @Mapping(target = "lakeName", source = "lakeName")
    @Mapping(target = "depth")
    Lake mapToEntity(LakeRequestDto dto);

    @Named("baseResponseLake")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(entity.getId().toString())")
    @Mapping(target = "lakeName", source = "lakeName")
    @Mapping(target = "startSeasonDate", source = "startSeasonDate")
    @Mapping(target = "endSeasonDate", source = "endSeasonDate")
    @Mapping(target = "depth", source = "depth")
    @Mapping(target = "fishInLakes", source = "fishInLake", qualifiedByName = "fishReferenceBase")
    LakeResponseDto mapToDto(Lake entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fishermenDistance", ignore = true)
    @Mapping(target = "lakeName")
    @Mapping(target = "startSeasonDate")
    @Mapping(target = "endSeasonDate")
    @Mapping(target = "fishInLake")
    void updateLake(Lake curLake, @MappingTarget Lake updLake);
}
