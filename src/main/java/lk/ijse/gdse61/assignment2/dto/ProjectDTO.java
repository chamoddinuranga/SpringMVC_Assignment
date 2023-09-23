package lk.ijse.gdse61.assignment2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProjectDTO {
    private String projectID;
    private String projectName;
    private String projectDesc;
    private String projectStatus;

}
