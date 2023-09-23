package lk.ijse.gdse61.assignment2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class TechLeadDTO {
    private String tlID;
    private String tlName;
    private String tlEmail;
    private String expertise;

}
