package ua.com.cyberdone.chemistrymicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtomicMassDto {
    private String inputFormula;
    private Double atomicMass;
}
