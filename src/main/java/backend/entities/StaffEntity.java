package backend.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_staff", unique = true, nullable = false)
    @Getter
    private Long idStaff;

    @Setter
    @Column(name = "rut")
    private String rut;

    @Setter
    @Column(name = "lastname")
    private String lastname;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    @Setter
    @Column(name = "id_category")
    private Long idCategory;

    @Setter
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ingress")
    private Date ingress;
}
