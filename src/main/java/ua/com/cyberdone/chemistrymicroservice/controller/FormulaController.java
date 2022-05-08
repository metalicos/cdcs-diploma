package ua.com.cyberdone.chemistrymicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.chemistrymicroservice.exception.FormulaException;
import ua.com.cyberdone.chemistrymicroservice.model.FormulaElementsDto;
import ua.com.cyberdone.chemistrymicroservice.service.ChemicalElementExtractorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/formula")
public class FormulaController {
    private final ChemicalElementExtractorService chemicalElementExtractorService;

    @GetMapping("/elements")
    public ResponseEntity<FormulaElementsDto> getFormulaElements(@RequestParam String formula) throws FormulaException {
        var elementsAmount = chemicalElementExtractorService.extractElementsAmountFromFormula(formula);
        return ResponseEntity.ok(new FormulaElementsDto(formula, elementsAmount));
    }
}
