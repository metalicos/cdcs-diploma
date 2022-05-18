package ua.com.cyberdone.chemistrymicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormulaElementsWeightDto {
    private List<FormulaDto> inputFormulas;
    private Map<String, Double> elementsWeightMg;
}
