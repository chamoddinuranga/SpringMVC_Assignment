package lk.ijse.gdse61.assignment2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "project")
public class Project implements SuperEntity{
    @Id
    private String projectID;
    @Column(nullable = false)
    private String projectName;
    @Column(nullable = false)
    private String projectDesc;
    @Column(nullable = false)
    private String projectStatus;

    @ManyToOne
    @JoinColumn(name = "tech_lead_id")
    public TechLead techLead;


}
