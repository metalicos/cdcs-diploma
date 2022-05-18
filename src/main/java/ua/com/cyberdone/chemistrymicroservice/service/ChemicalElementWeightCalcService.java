package ua.com.cyberdone.chemistrymicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.cyberdone.chemistrymicroservice.exception.FormulaException;
import ua.com.cyberdone.chemistrymicroservice.exception.NotFoundException;
import ua.com.cyberdone.chemistrymicroservice.model.FormulaDto;
import ua.com.cyberdone.chemistrymicroservice.model.FormulaElementsWeightDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemicalElementWeightCalcService {
    private final ChemicalElementExtractorService chemicalElementExtractorService;
    private final AtomicMassService atomicMassService;

    public FormulaElementsWeightDto calculateElementsWeightByFormulas(List<FormulaDto> formulas)
            throws FormulaException, NotFoundException {
        Map<String, Double> elementWeightMap = new HashMap<>();
        for (var formula : formulas) {
            var elements = chemicalElementExtractorService.extractElementsAmountFromFormula(formula.getFormula());
            for (var elem : elements.entrySet()) {
                var elemWeight = calculateElementWeightInMg(formula.getAmountMg(), formula.getFormula(), elem.getKey());
                elementWeightMap.put(elem.getKey(), Optional.ofNullable(elementWeightMap.get(elem.getKey())).orElse(0.0) + elemWeight);
            }
        }
        return new FormulaElementsWeightDto(formulas, elementWeightMap);
    }

    private Double calculateElementWeightInMg(Double mg, String formula, String element)
            throws NotFoundException, FormulaException {
        var elements = chemicalElementExtractorService.extractElementsAmountFromFormula(formula);
        var elementsAtomicMass = atomicMassService.getAtomicMassForElements(elements);
        var elementAtomicMassPerAmount = elementsAtomicMass.get(element);
        var formulaAtomicMass = atomicMassService.getAtomicMassByFormula(formula).getAtomicMass();
        return elementAtomicMassPerAmount * mg / formulaAtomicMass;
    }
}
