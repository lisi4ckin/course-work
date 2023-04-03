package fishclub.ru.fishclubserver.mapper.fishermen;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.dto.fishermen.list.FishermenListResultDto;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.reference.FishReferenceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {FishReferenceMapper.class},
        imports = {})
public interface FishermenMapper {

    @Named("baseFishermenMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "age", source = "request.age")
    @Mapping(target = "experience", source = "request.experience")
    @Mapping(target = "fullName", source = "request.fullName")
    @Mapping(target = "preferencesFishes", source = "fishesIds", qualifiedByName = "fishes")
    Fishermen mapToEntity(FishermenRequestDto request, List<Long> fishesIds);

    @Named("baseFishermenDtoMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "experience", source = "experience")
    @Mapping(target ="preferencesFishes", source = "preferencesFishes", qualifiedByName = "fishReferenceBase")
    FishermenResponseDto mapToDto(Fishermen entity);

    @Named("fishermenJournalMapper")
    @Mapping(target = "fishermenFullName", source = "name")
    FishermenListResultDto mapToDto(FishermenJournalEntity entity);
    @InheritConfiguration
    List<FishermenListResultDto> mapToDto(List<FishermenJournalEntity> entities);

    @Named("fishermenUpdate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "age")
    @Mapping(target = "preferencesFishes")
    @Mapping(target = "experience")
    @Mapping(target = "fullName")
    @Mapping(target = "distancesToLakes")
    void updateFishermen(Fishermen curFishermen, @MappingTarget Fishermen updFishermen);

}
