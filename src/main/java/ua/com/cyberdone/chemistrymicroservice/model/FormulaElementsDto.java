package ua.com.cyberdone.chemistrymicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormulaElementsDto {
    private String inputFormula;
    private Map<String, Integer> elementsAmount;
}
