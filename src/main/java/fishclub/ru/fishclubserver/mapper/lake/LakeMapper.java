package fishclub.ru.fishclubserver.mapper.lake;

import fishclub.ru.fishclubserver.dto.lake.LakeRequestDto;
import fishclub.ru.fishclubserver.dto.lake.LakeResponseDto;
import fishclub.ru.fishclubserver.entity.Lake;
import fishclub.ru.fishclubserver.mapper.reference.FishReferenceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        imports = {}, uses = {FishReferenceMapper.class})
public interface LakeMapper {

    @Named("baseLakeMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "startSeasonDate", source = "startSeasonDate")
    @Mapping(target = "endSeasonDate", source = "endSeasonDate")
    @Mapping(target = "lakeName", source = "lakeName")
    @Mapping(target = "fishInLake", source = "fishInLakes", qualifiedByName = "fishesReference")
    Lake mapToEntity(LakeRequestDto dto);

    @Named("baseResponseLake")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(entity.getId().toString())")
    @Mapping(target = "lakeName", source = "lakeName")
    @Mapping(target = "startSeasonDate", source = "startSeasonDate")
    @Mapping(target = "endSeasonDate", source = "endSeasonDate")
    @Mapping(target = "fishInLakes", source = "fishInLake", qualifiedByName = "fishReferenceBase")
    LakeResponseDto mapToDto(Lake entity);
}
