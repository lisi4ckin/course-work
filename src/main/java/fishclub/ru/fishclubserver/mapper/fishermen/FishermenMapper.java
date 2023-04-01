package fishclub.ru.fishclubserver.mapper.fishermen;

import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.reference.FishReferenceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        uses = {FishReferenceMapper.class},
        imports = {})
public interface FishermenMapper {

    @Named("baseFishermenMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "age", source = "age")
    @Mapping(target = "experience", source = "experience")
    @Mapping(target = "fullName", source = "fullName")
    Fishermen mapToEntity(FishermenRequestDto request);

    @Named("baseFishermenDtoMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "experience", source = "experience")
    @Mapping(target ="preferencesFishes", source = "preferencesFishes", qualifiedByName = "fishReferenceBase")
    FishermenResponseDto mapToDto(Fishermen entity);

}
