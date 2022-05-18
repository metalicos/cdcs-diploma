package ua.com.cyberdone.chemistrymicroservice.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.util.Objects;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "periodic_table")
public class ChemicalElement extends BasicEntity {

    @Serial
    private static final long serialVersionUID = 234232342L;

    @Column(name = "atomic_number")
    private Integer atomicNumber;
    @Column(name = "element")
    private String element;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "atomic_mass")
    private Double atomicMass;
    @Column(name = "number_of_neutrons")
    private Integer numberOfNeutrons;
    @Column(name = "number_of_protons")
    private Integer numberOfProtons;
    @Column(name = "number_of_electrons")
    private Integer numberOfElectrons;
    @Column(name = "period")
    private Integer period;
    @Column(name = "group")
    private Integer group;
    @Column(name = "phase")
    private String phase;
    @Column(name = "radioactive")
    private Boolean radioactive;
    @Column(name = "natural")
    private Boolean natural;
    @Column(name = "metal")
    private Boolean metal;
    @Column(name = "nonmetal")
    private Boolean nonmetal;
    @Column(name = "metalloid")
    private Boolean metalloid;
    @Column(name = "type")
    private String type;
    @Column(name = "atomic_radius")
    private Double atomicRadius;
    @Column(name = "electronegativity")
    private Double electronegativity;
    @Column(name = "first_ionization")
    private Double firstIonization;
    @Column(name = "density")
    private Double density;
    @Column(name = "melting_point")
    private Double meltingPoint;
    @Column(name = "boiling_point")
    private Double boilingPoint;
    @Column(name = "number_of_isotopes")
    private Integer numberOfIsotopes;
    @Column(name = "discoverer")
    private String discoverer;
    @Column(name = "year")
    private Integer year;
    @Column(name = "specific_heat")
    private Double specificHeat;
    @Column(name = "number_of_shells")
    private Integer numberOfShells;
    @Column(name = "number_of_valence")
    private Integer numberOfValence;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ChemicalElement that = (ChemicalElement) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
