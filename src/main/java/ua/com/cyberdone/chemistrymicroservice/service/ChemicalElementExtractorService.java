package ua.com.cyberdone.chemistrymicroservice.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import ua.com.cyberdone.chemistrymicroservice.exception.FormulaException;
import ua.com.cyberdone.chemistrymicroservice.model.FormulaElementsDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class ChemicalElementExtractorService {
    private static final Pattern COMPLEX_CHEMICAL_FORMULA_REGEX =
            Pattern.compile("\\*?[0-9A-Za-z]*[A-Z][a-z]?\\d*|\\([^()]*(?:\\(.*\\))?[^()]*\\)\\d+");
    private static final Pattern CHEMICAL_FORMULA_REGEX =
            Pattern.compile("[A-Z][a-z]?\\d*|\\([^()]*(?:\\(.*\\))?[^()]*\\)\\d+");
    private static final Pattern SINGLE_ELEMENT_REGEX =
            Pattern.compile("^([A-Z][a-z]{0,1})([0-9]+){0,}$");
    private static final Pattern NESTED_ELEMENT_REGEX =
            Pattern.compile("^\\(([A-Za-z0-9()]{1,})\\)([0-9])$");
    private static final Pattern MULTIPLY_FORMULA_REGEX =
            Pattern.compile("\\*(\\d)([A-Za-z0-9]{1,})");

    public List<FormulaElementsDto> extractElementsAmountFromFormulaList(List<String> formulaList) throws FormulaException {
        List<FormulaElementsDto> formulaElementsDtoList = new ArrayList<>();
        for (var formula : formulaList) {
            formulaElementsDtoList.add(new FormulaElementsDto(formula, extractElementsAmountFromFormula(formula)));
        }
        return formulaElementsDtoList;
    }

    public Map<String, Integer> extractElementsAmountFromFormula(String formula) throws FormulaException {
        var elementsAmount = new HashMap<String, Integer>();
        extractElementAmount(elementsAmount, formula);
        log.info("Formula={} elements are extracted={}", formula, elementsAmount);
        return elementsAmount;
    }

    private void extractElementAmount(Map<String, Integer> elementsAmount, String input)
            throws FormulaException {
        var complexFormulaMatcher = COMPLEX_CHEMICAL_FORMULA_REGEX.matcher(input);
        while (complexFormulaMatcher.find()) {
            var element = complexFormulaMatcher.group();
            var multiplyFormulaMatcher = MULTIPLY_FORMULA_REGEX.matcher(element);
            if (multiplyFormulaMatcher.find()) {
                var formulaMultiplier = Integer.parseInt(multiplyFormulaMatcher.group(1));
                var formula = multiplyFormulaMatcher.group(2);
                processChemicalFormula(elementsAmount, formula, formulaMultiplier);
            } else {
                processChemicalFormula(elementsAmount, element, 1);
            }
        }
    }

    private void processChemicalFormula(Map<String, Integer> elementsAmount, String input, int multiplier) throws FormulaException {
        var formulaMatcher = CHEMICAL_FORMULA_REGEX.matcher(input);
        while (formulaMatcher.find()) {
            var foundElement = formulaMatcher.group();
            var singleElementMatcher = SINGLE_ELEMENT_REGEX.matcher(foundElement);
            if (singleElementMatcher.find()) {
                var element = singleElementMatcher.group(1);
                var extractedAmount = singleElementMatcher.group(2);
                var amount = isNull(extractedAmount) || Strings.EMPTY.equals(extractedAmount) ? 1 : Integer.parseInt(extractedAmount);
                elementsAmount.put(element, Optional.ofNullable(elementsAmount.get(element)).orElse(0) + amount * multiplier);
            } else {
                var nestedElementMatcher = NESTED_ELEMENT_REGEX.matcher(foundElement);
                if (nestedElementMatcher.find()) {
                    var element = nestedElementMatcher.group(1);
                    System.out.println(element);
                    var amount = Integer.parseInt(nestedElementMatcher.group(2));
                    processChemicalFormula(elementsAmount, element, amount * multiplier);
                } else {
                    throw new FormulaException("Error: Unknown formula.");
                }
            }
        }
    }
}
