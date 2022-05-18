
package ua.com.cyberdone.chemistrymicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cyberdone.chemistrymicroservice.exception.FormulaException;
import ua.com.cyberdone.chemistrymicroservice.exception.NotFoundException;
import ua.com.cyberdone.chemistrymicroservice.model.AtomicMassDto;
import ua.com.cyberdone.chemistrymicroservice.service.AtomicMassService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atomic")
public class AtomicController {
    private final AtomicMassService atomicMassService;

    @GetMapping("/mass")
    public ResponseEntity<List<AtomicMassDto>> getAtomicMassByFormula(@RequestParam("formula") List<String> formulaList)
            throws FormulaException, NotFoundException {
        return ResponseEntity.ok(atomicMassService.getAtomicMassByFormulaList(formulaList));
    }
}
