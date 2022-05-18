package ua.com.cyberdone.chemistrymicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.chemistrymicroservice.exception.FormulaException;
import ua.com.cyberdone.chemistrymicroservice.exception.NotFoundException;
import ua.com.cyberdone.chemistrymicroservice.model.FormulaDto;
import ua.com.cyberdone.chemistrymicroservice.model.FormulaElementsDto;
import ua.com.cyberdone.chemistrymicroservice.model.FormulaElementsWeightDto;
import ua.com.cyberdone.chemistrymicroservice.service.ChemicalElementExtractorService;
import ua.com.cyberdone.chemistrymicroservice.service.ChemicalElementWeightCalcService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/formula")
public class FormulaController {
    private final ChemicalElementExtractorService chemicalElementExtractorService;
    private final ChemicalElementWeightCalcService chemicalElementWeightCalcService;

    @GetMapping("/elements")
    public ResponseEntity<List<FormulaElementsDto>> getFormulaElements(@RequestParam("formula") List<String> formulaList)
            throws FormulaException {
        return ResponseEntity.ok(chemicalElementExtractorService.extractElementsAmountFromFormulaList(formulaList));
    }

    @PostMapping("/elements/weight")
    public ResponseEntity<FormulaElementsWeightDto> getElementsWeightByFormulas(@RequestBody List<FormulaDto> formulaList)
            throws FormulaException, NotFoundException {
        return ResponseEntity.ok(chemicalElementWeightCalcService.calculateElementsWeightByFormulas(formulaList));
    }
}
