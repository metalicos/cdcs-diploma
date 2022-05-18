package ua.com.cyberdone.chemistrymicroservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.cyberdone.chemistrymicroservice.persistence.entity.ChemicalElement;

import java.util.Optional;

@Repository
public interface ChemicalElementRepository extends JpaRepository<ChemicalElement, Long> {

    Optional<ChemicalElement> findBySymbol(String symbol);
}
