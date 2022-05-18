package ua.com.cyberdone.chemistrymicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.cyberdone.chemistrymicroservice.exception.FormulaException;
import ua.com.cyberdone.chemistrymicroservice.exception.NotFoundException;
import ua.com.cyberdone.chemistrymicroservice.model.AtomicMassDto;
import ua.com.cyberdone.chemistrymicroservice.persistence.service.ChemicalElementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtomicMassService {

    private final ChemicalElementExtractorService chemicalElementExtractorService;
    private final ChemicalElementService chemicalElementService;

    public List<AtomicMassDto> getAtomicMassByFormulaList(List<String> formulaList) throws FormulaException, NotFoundException {
        List<AtomicMassDto> atomicMassDtoList = new ArrayList<>();
        for (var formula : formulaList) {
            atomicMassDtoList.add(getAtomicMassByFormula(formula));
        }
        return atomicMassDtoList;
    }

    public AtomicMassDto getAtomicMassByFormula(String formula) throws FormulaException, NotFoundException {
        var elementsAmount = chemicalElementExtractorService.extractElementsAmountFromFormula(formula);
        double formulaAtomicMass = 0;
        for (var entry : elementsAmount.entrySet()) {
            formulaAtomicMass += getAtomicMassOfElement(entry.getKey(), entry.getValue());
        }
        return new AtomicMassDto(formula, formulaAtomicMass);
    }

    public Double getAtomicMassOfElement(String symbol, Integer amount) throws NotFoundException {
        return chemicalElementService.findChemicalElementBySymbol(symbol).getAtomicMass() * amount;
    }

    public Map<String, Double> getAtomicMassForElements(Map<String, Integer> elements) throws NotFoundException {
        Map<String, Double> elementsAtomicMass = new HashMap<>();
        for (var elementEntry : elements.entrySet()) {
            elementsAtomicMass.put(elementEntry.getKey(), getAtomicMassOfElement(elementEntry.getKey(), elementEntry.getValue()));
        }
        return elementsAtomicMass;
    }
}
