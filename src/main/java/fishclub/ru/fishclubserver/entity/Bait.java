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
@Table(name = "BAITS")
@SequenceGenerator(name = "seq_gen", sequenceName = "BAIT_ID_SEQ", allocationSize = 1, initialValue = 1000)
@AttributeOverride(name = "id", column = @Column(name = "BAIT_ID"))
public class Bait extends BaseEntity {
    @Column(name = "NAME")
    private String baitName;
    //todo При нормальной реализации сделать на справочники через связи
    @Column(name = "TYPE")
    private String baitType;
    @Column(name = "TECHNIC")
    private String baitTechnic;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "baits",
            targetEntity = Fish.class)
    @JsonIgnore
    private List<Fish> fishOnBait;
}
