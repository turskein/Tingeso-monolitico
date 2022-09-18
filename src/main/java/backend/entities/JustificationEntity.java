package backend.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "justification")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JustificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false,name = "id_justification")
    @Getter
    private Long idJustification;

    @Getter
    @Setter
    @Column(name = "id_staff")
    private Long idStaff;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date date;
}
