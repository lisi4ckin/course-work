package fishclub.ru.fishclubserver.mapper.fish;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import fishclub.ru.fishclubserver.dto.fish.FishJournalDto;
import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;
import fishclub.ru.fishclubserver.dto.fishermen.list.FishermenListResultDto;
import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.mapper.reference.BaitReferenceMapper;
import fishclub.ru.fishclubserver.mapper.reference.LakeReferenceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {Long.class}, uses = {BaitReferenceMapper.class, LakeReferenceMapper.class})
public interface FishMapper {

    @Named("baseFishMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "startDateOfProhibition", source = "startDateOfProhibition")
    @Mapping(target = "endDateOfProhibition", source = "endDateOfProhibition")
    @Mapping(target = "fishName", source = "fishName")
    @Mapping(target = "averageWeight", source = "avgWeight")
    @Mapping(target = "baits", source = "baits", qualifiedByName = "baseBaitMapper")
    @Mapping(target = "findInLakes", source = "lakes", qualifiedByName = "baseLakeMapper")
    Fish mapToEntity(FishRequestDto dto);

    @Named("baseResponseFish")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(entity.getId().toString())")
    @Mapping(target = "fishName", source = "fishName")
    @Mapping(target = "avgWeight", source = "averageWeight")
    @Mapping(target = "startDateOfProhibition", source = "startDateOfProhibition")
    @Mapping(target = "endDateOfProhibition", source = "endDateOfProhibition")
    @Mapping(target = "lakes", source = "findInLakes", qualifiedByName = "lakeReferenceBase")
    FishResponseDto mapToDto(Fish entity);

    @Named("fishJournalMapper")
    @Mapping(target = "avgWeight", source = "averageWeight")
    FishJournalDto mapToDto(FishJournalEntity entity);

    default List<FishJournalDto> mapToDto(List<FishJournalEntity> entities) {
        List<FishJournalDto> result = new ArrayList<>();
        for (FishJournalEntity fisherman : entities) {
            result.add(mapToDto(fisherman));
        }
        return result;
    }

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
