package entities.mapping.example.onetomany.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private Long employerId;
    private String employeeName;

    // now creates third table, containing primary keys from both sides
    @OneToMany
    private List<Task> tasks;
}
