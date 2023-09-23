package lk.ijse.gdse61.assignment2.service;

import lk.ijse.gdse61.assignment2.dto.TechLeadDTO;

public interface TLService {
    TechLeadDTO saveTechLead (TechLeadDTO techLeadDTO);
    void deleteTechLead (String tlID);
    void updateTechLead (String tlID, TechLeadDTO techLeadDTO);
    TechLeadDTO getTLById(String tlID);

}
