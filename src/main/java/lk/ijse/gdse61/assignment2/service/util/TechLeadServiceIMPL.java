package lk.ijse.gdse61.assignment2.service.util;

import lk.ijse.gdse61.assignment2.dto.TechLeadDTO;

public interface TechLeadServiceIMPL {
    TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO);

    void deleteTechLead(String tlId);

    void updateTechLead(String tlID, TechLeadDTO techLeadDTO);

    TechLeadDTO getTLbyId(String tlID);
}
