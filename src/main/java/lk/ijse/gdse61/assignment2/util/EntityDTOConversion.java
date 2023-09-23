package lk.ijse.gdse61.assignment2.util;
import lk.ijse.gdse61.assignment2.dto.TechLeadDTO;
import lk.ijse.gdse61.assignment2.entity.TechLead;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {

    private final ModelMapper modelMapper;
    EntityDTOConversion(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public TechLead getTLEntity(TechLeadDTO techLeadDTO){
        return modelMapper.map(techLeadDTO, TechLead.class);
    }
    public TechLeadDTO getTLDTO(TechLead techLead){
        return modelMapper.map(techLead,TechLeadDTO.class);
    }
}
