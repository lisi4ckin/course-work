package fishclub.ru.fishclubserver.mapper.fishermen;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.dto.fishermen.list.FishermenListResultDto;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.reference.FishReferenceMapper;
import fishclub.ru.fishclubserver.mapper.reference.LakeReferenceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {FishReferenceMapper.class, LakeReferenceMapper.class},
        imports = {})
public interface FishermenMapper {

    @Named("baseFishermenMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "age", source = "request.age")
    @Mapping(target = "experience", source = "request.experience")
    @Mapping(target = "fullName", source = "request.fullName")
    @Mapping(target = "passportSeries", source = "request.passportSeries")
    @Mapping(target = "passportNumber", source = "request.passportNumber")
    @Mapping(target = "preferencesFishes", source = "fishesIds", qualifiedByName = "fishes")
    @Mapping(target = "distancesToLakes", source = "request.distances", qualifiedByName = "baseLakeMapper")
    Fishermen mapToEntity(FishermenRequestDto request, List<Long> fishesIds);

    @Named("baseFishermenDtoMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "passportSeries", source = "passportSeries")
    @Mapping(target = "passportNumber", source = "passportNumber")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "experience", source = "experience")
    @Mapping(target ="preferencesFishes", source = "preferencesFishes", qualifiedByName = "fishReferenceBase")
    @Mapping(target = "lakes", source = "distancesToLakes", qualifiedByName = "lakeReferenceBase")
    FishermenResponseDto mapToDto(Fishermen entity);

    @Named("fishermenJournalMapper")
    @Mapping(target = "fishermenFullName", source = "name")
    FishermenListResultDto mapToDto(FishermenJournalEntity entity);

    default List<FishermenListResultDto> mapToDto(List<FishermenJournalEntity> entities) {
        List<FishermenListResultDto> result = new ArrayList<>();
        for (FishermenJournalEntity fisherman : entities) {
            result.add(mapToDto(fisherman));
        }
        return result;
    }

    @Named("fishermenUpdate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "age")
    @Mapping(target = "preferencesFishes")
    @Mapping(target = "experience")
    @Mapping(target = "fullName")
    @Mapping(target = "passportSeries")
    @Mapping(target = "passportNumber")
    @Mapping(target = "distancesToLakes")
    void updateFishermen(Fishermen curFishermen, @MappingTarget Fishermen updFishermen);

}
