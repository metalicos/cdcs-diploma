package ua.com.cyberdone.chemistrymicroservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.cyberdone.chemistrymicroservice.persistence.entity.PeriodicTable;

@Repository
public interface PeriodicTableRepository extends JpaRepository<PeriodicTable, Long> {
}
