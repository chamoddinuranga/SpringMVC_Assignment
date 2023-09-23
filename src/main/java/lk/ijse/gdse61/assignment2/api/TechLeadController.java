package lk.ijse.gdse61.assignment2.api;

import lk.ijse.gdse61.assignment2.dto.TechLeadDTO;
import lk.ijse.gdse61.assignment2.service.TLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lk.ijse.gdse61.assignment2.exception.InvalidException;

@RestController
@RequestMapping("/api/v1/tl")
public class TechLeadController {
    @Autowired
     TLService tlService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    TechLeadDTO saveTechLead(
            @RequestPart String tlName,
            @RequestPart String tlEmail,
            @RequestPart String expertise){

        if(tlName == null || !tlName.matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (tlEmail == null) {
            throw new InvalidException("Invalid Email");
        } else if (expertise == null) {
            throw new InvalidException("Invalid Department Id");
        }

        TechLeadDTO tmpTL = new TechLeadDTO();
        tmpTL.setTlName(tlName);
        tmpTL.setTlEmail(tlEmail);
        tmpTL.setExpertise(expertise);

        return tlService.saveTechLead(tmpTL);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteTechLead(@PathVariable String id){
        tlService.deleteTechLead(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("{id}")
    void updateEmployee(
            @PathVariable String id,
            @RequestPart String tlName,
            @RequestPart String tlEmail,
            @RequestPart String expertise
    ){

        if(tlName == null || !tlName.matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (tlEmail == null) {
            throw new InvalidException("Invalid Email");
        } else if (expertise == null) {
            throw new InvalidException("Invalid expertise");
        } else if (!id.matches("[A-Fa-f0-9\\-]{36}")) {
            throw new InvalidException("Invalid TechLead Id");
        }

        TechLeadDTO updateTL = new TechLeadDTO();
        updateTL.setTlName(tlName);
        updateTL.setTlEmail(tlEmail);
        updateTL.setExpertise(expertise);
        tlService.updateTechLead(id,updateTL);
    }
    @GetMapping(value = "{tlId}",produces = MediaType.APPLICATION_JSON_VALUE)
    TechLeadDTO getSelectedTL(@PathVariable String tlId){
        if(!tlId.matches("[A-Fa-f0-9\\-]{36}")) throw new InvalidException("Id is invalid");
        return tlService.getTLById(tlId);
    }



}
