package universitygroups.mironenko.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import universitygroups.mironenko.models.Groups;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    private Integer id;
    private String fullName;
    @JsonIgnore
    private Date enrollmentDate;
    @JsonIgnore
    private Groups groups;

    private int idGroup;
    @JsonIgnore
    private String groupNumber;
}
