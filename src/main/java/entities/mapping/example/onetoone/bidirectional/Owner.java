package entities.mapping.example.onetoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue
    private Long ownerId;
    private String ownerName;

    @OneToOne
    private Computer ownerComputer;
}
