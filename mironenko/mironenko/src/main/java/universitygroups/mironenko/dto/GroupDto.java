package universitygroups.mironenko.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//Data transfer object - класс для переноса данных из модели
public class GroupDto {
    @JsonIgnore
    private int id;
    private String number;
    private long count;
}
