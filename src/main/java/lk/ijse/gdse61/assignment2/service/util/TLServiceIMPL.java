package lk.ijse.gdse61.assignment2.service.util;

import lk.ijse.gdse61.assignment2.dto.TechLeadDTO;
import lk.ijse.gdse61.assignment2.entity.TechLead;
import lk.ijse.gdse61.assignment2.exception.InvalidException;
import lk.ijse.gdse61.assignment2.exception.NotFoundException;
import lk.ijse.gdse61.assignment2.repository.TechLeadRepository;
import lk.ijse.gdse61.assignment2.util.EntityDTOConversion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class TLServiceIMPL implements TechLeadServiceIMPL {
    @Autowired
    TechLeadRepository techLeadRepository;

    @Autowired
    EntityDTOConversion conversion;

    @Override
    public TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO) {
        techLeadDTO.setTlID(UUID.randomUUID().toString());
        TechLead tlEntity = conversion.getTLEntity(techLeadDTO);
        techLeadRepository.save(tlEntity);
        return techLeadDTO;
    }

    @Override
    public void deleteTechLead(String tlId) {
        if(!techLeadRepository.existsById(tlId)) throw new NotFoundException("TechLead Not Found");
        techLeadRepository.deleteByTlID(tlId);
    }

    @Override
    public void updateTechLead(String tlID, TechLeadDTO techLead) {
        Optional<TechLead> tmpTL = techLeadRepository.findById(tlID);
        if(!tmpTL.isPresent()) throw new NotFoundException("TechLead not found");
        tmpTL.get().setTlName(techLead.getTlName());
        tmpTL.get().setExpertise(techLead.getExpertise());
        tmpTL.get().setTlEmail(techLead.getTlEmail());
    }

    @Override
    public TechLeadDTO getTLbyId(String tlID) {
        if(!techLeadRepository.existsById(tlID)) throw new InvalidException("Invalid TechLead ID");
        TechLead techLeadByTlID = techLeadRepository.findTechLeadByTlID(tlID);
        return conversion.getTLDTO(techLeadByTlID);
    }
}
