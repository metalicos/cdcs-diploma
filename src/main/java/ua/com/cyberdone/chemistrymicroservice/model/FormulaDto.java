package ua.com.cyberdone.chemistrymicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormulaDto {
    private Double amountMg;
    private String formula;
}
