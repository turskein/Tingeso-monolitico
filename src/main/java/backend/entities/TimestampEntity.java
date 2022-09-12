package backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "timestamp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimestampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter
    private Long id_timestamp;

    @Getter
    @Setter
    @Column(name = "id_staff")
    private Long id_staff;

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
