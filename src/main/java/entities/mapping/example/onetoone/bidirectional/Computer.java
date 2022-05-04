package entities.mapping.example.onetoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "computers")
@NoArgsConstructor
@Getter
@Setter
public class Computer {
    @Id
    @GeneratedValue
    private Long computerId;
    private String computerName;

    // the mappedBy attribute means the mapping is already done by other side and don’t create additional column.
    @OneToOne(mappedBy = "ownerComputer")
    private Owner owner;
}
