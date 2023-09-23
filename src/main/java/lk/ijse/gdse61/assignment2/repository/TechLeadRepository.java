package lk.ijse.gdse61.assignment2.repository;

import lk.ijse.gdse61.assignment2.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechLeadRepository extends JpaRepository<TechLead,String> {
    TechLead findTechLeadByTlID(String id);
    void deleteByTlID(String id);
}
