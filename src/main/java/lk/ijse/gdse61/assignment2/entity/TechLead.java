package lk.ijse.gdse61.assignment2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "techlead")
public class TechLead implements SuperEntity{
    @Id
    private String tlID;
    @Column(nullable = false)
    private String tlName;
    @Column(nullable = false)
    private String tlEmail;
    @Column(nullable = false)
    private String expertise;

    @OneToMany(mappedBy = "techLead", cascade = CascadeType.ALL) // Specify cascade type
    private List<Project> projects;
}
