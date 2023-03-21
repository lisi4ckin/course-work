package fishclub.ru.fishclubserver.entity;

import fishclub.ru.fishclubserver.entity.base.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "FISHES")
@SequenceGenerator(name = "seq_gen", sequenceName = "FISH_ID_SEQ", allocationSize = 1, initialValue = 1000)
@AttributeOverride(name = "id", column = @Column(name = "FISH_ID"))
public class Fish extends BaseEntity {
    @Column(name = "NAME")
    private String fishName;
    @Column(name = "AVERAGE_WEIGHT")
    private Float averageWeight;
    @Column(name = "START_DATE_OF_PROHIBITION")
    private String startDateOfProhibition;
    @Column(name = "END_DATE_OF_PROHIBITION")
    private String endDateOfProhibition;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "preferencesFishes",
            targetEntity = Fishermen.class)
    @JsonIgnore
    private List<Fishermen> fishermen;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {})
    @JoinTable(name = "FINDINGS",
            joinColumns = {@JoinColumn(name = "FISH_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "LAKE_ID")}
    )
    private List<Lake> findInLakes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {})
    @JoinTable(name = "BITINGS",
            joinColumns = {@JoinColumn(name = "FISH_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "BAIT_ID")}
    )
    private List<Bait> baits;
}
