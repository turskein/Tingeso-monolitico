package backend.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "timestamp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false,name = "id_timestamp")
    @Getter
    private Long idTimestamp;

    @Getter
    @Setter
    @Column(name = "id_staff")
    private Long idStaff;

    @Getter
    @Setter
    @Column(name = "time")
    private Time time;

    @Setter
    @Getter
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date date;
}
