package fishclub.ru.fishclubserver.mapper.bait;

import fishclub.ru.fishclubserver.dto.bait.BaitRequestDto;
import fishclub.ru.fishclubserver.dto.bait.BaitResponseDto;
import fishclub.ru.fishclubserver.entity.Bait;
import fishclub.ru.fishclubserver.mapper.reference.FishReferenceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        uses = {FishReferenceMapper.class}
)
public interface BaitMapper {

    @Named("baitBaseMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "baitName", source = "baitName")
    @Mapping(target = "baitType", source = "baitType")
    @Mapping(target = "baitTechnic", source = "baitTechnic")
    Bait mapToEntity(BaitRequestDto dto);


    @Named("baitResponseMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "baitType", source = "baitType")
    @Mapping(target = "baitName", source = "baitName")
    @Mapping(target = "baitTechnic", source = "baitTechnic")
    @Mapping(target = "fishes", source = "fishOnBait", qualifiedByName = "fishReferenceBase")
    BaitResponseDto mapToDto(Bait entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "baitName")
    @Mapping(target = "baitType")
    @Mapping(target = "baitTechnic")
    @Mapping(target = "fishOnBait")
    void updateBait(Bait curBait, @MappingTarget Bait updBait);
}
