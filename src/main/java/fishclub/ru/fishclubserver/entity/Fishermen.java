package fishclub.ru.fishclubserver.entity;

import fishclub.ru.fishclubserver.entity.base.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
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

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "FISHERMEN")
@SequenceGenerator(name = "seq_gen", sequenceName = "FISHERMAN_ID_SEQ", allocationSize = 1, initialValue = 1000)
@AttributeOverride(name = "id", column = @Column(name = "FISHERMAN_ID"))
public class Fishermen extends BaseEntity {

    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "EXPERIENCE")
    private Integer experience;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "PREFERENCES",
            joinColumns = {@JoinColumn(name = "FISHERMAN_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "FISH_ID")}
    )
    private List<Fish> preferencesFishes;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {})
    @JoinTable(name = "DISTANCES",
            joinColumns = {@JoinColumn(name = "FISHERMAN_ID")},
            inverseJoinColumns = {@JoinColumn(name = "LAKE_ID")}
    )
    private List<Lake> distancesToLakes;
}
