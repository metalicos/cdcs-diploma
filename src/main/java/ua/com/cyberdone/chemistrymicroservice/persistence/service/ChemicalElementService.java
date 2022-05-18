package ua.com.cyberdone.chemistrymicroservice.persistence.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.cyberdone.chemistrymicroservice.exception.NotFoundException;
import ua.com.cyberdone.chemistrymicroservice.persistence.entity.ChemicalElement;
import ua.com.cyberdone.chemistrymicroservice.persistence.repository.ChemicalElementRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemicalElementService {
    private final ChemicalElementRepository chemicalElementRepository;

    public ChemicalElement findChemicalElementBySymbol(String symbol) throws NotFoundException {
        var chemicalElement = chemicalElementRepository.findBySymbol(symbol).orElseThrow(
                () -> new NotFoundException("Chemical Element With Symbol='" + symbol + "' is not found."));
        log.info("Input: '{}', found element='{}'", symbol, chemicalElement);
        return chemicalElement;
    }
}
