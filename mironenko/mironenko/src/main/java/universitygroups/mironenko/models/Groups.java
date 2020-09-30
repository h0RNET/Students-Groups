package universitygroups.mironenko.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String number;

    @OneToMany(targetEntity = Students.class, cascade = CascadeType.ALL,mappedBy = "groups")
    private List<Students> students;


}
