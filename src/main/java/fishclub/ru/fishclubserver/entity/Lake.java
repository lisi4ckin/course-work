package fishclub.ru.fishclubserver.entity;

import fishclub.ru.fishclubserver.entity.base.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "LAKES")
@AttributeOverride(name = "id", column = @Column(name = "LAKE_ID"))
@SequenceGenerator(name = "seq_gen", sequenceName = "LAKE_ID_SEQ", allocationSize = 1, initialValue = 1000)
public class Lake extends BaseEntity {
    @Column(name = "NAME")
    private String lakeName;
    @Column(name = "DEPTH")
    private Long depth;
    @Column(name = "START_SEASON_DATE")
    private String startSeasonDate;
    @Column(name = "END_SEASON_DATE")
    private String endSeasonDate;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "distancesToLakes",
            targetEntity = Fishermen.class)
    @JsonIgnore
    private List<Fishermen> fishermenDistance;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "findInLakes",
            targetEntity = Fish.class)
    @JsonIgnore
    private List<Fish> fishInLake;
}
