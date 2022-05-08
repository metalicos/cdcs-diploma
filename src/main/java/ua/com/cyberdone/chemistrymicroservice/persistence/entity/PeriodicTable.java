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
public class PeriodicTable extends BasicEntity {

    @Serial
    private static final long serialVersionUID = 234232342L;

    @Column(name = "atomic_number")
    private int atomicNumber;
    @Column(name = "element")
    private String element;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "atomic_mass")
    private double atomicMass;
    @Column(name = "number_of_neutrons")
    private int numberOfNeutrons;
    @Column(name = "number_of_protons")
    private int numberOfProtons;
    @Column(name = "number_of_electrons")
    private int numberOfElectrons;
    @Column(name = "period")
    private int period;
    @Column(name = "group")
    private int group;
    @Column(name = "phase")
    private String phase;
    @Column(name = "radioactive")
    private boolean radioactive;
    @Column(name = "natural")
    private boolean natural;
    @Column(name = "metal")
    private boolean metal;
    @Column(name = "nonmetal")
    private boolean nonmetal;
    @Column(name = "metalloid")
    private boolean metalloid;
    @Column(name = "type")
    private String type;
    @Column(name = "atomic_radius")
    private double atomicRadius;
    @Column(name = "electronegativity")
    private double electronegativity;
    @Column(name = "first_Ionization")
    private double firstIonization;
    @Column(name = "density")
    private double density;
    @Column(name = "melting_point")
    private double meltingPoint;
    @Column(name = "boiling_point")
    private double boilingPoint;
    @Column(name = "number_of_isotopes")
    private int numberOfIsotopes;
    @Column(name = "discoverer")
    private String discoverer;
    @Column(name = "year")
    private int year;
    @Column(name = "specific_heat")
    private double specificHeat;
    @Column(name = "number_of_shells")
    private int numberOfShells;
    @Column(name = "number_of_valence")
    private int numberOfValence;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        PeriodicTable that = (PeriodicTable) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
