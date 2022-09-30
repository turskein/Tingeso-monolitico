package backend.entities;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "extra_hours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class ExtraHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false,name = "id_extra_hours")
    private Long idExtraHours;

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

    @Getter
    @Setter
    @Column(name = "amount")
    private int amount;
}
