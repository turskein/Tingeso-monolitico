package backend.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class Salary {

    @Getter
    @Setter
    String rut;

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String lastName;

    @Getter
    @Setter
    String category;

    @Getter
    @Setter
    int serviceYears;

    @Getter
    @Setter
    int bonificationsSalary;

    @Getter
    @Setter
    int fixedSalary;

    @Getter
    @Setter
    int extraHoursSalary;

    @Getter
    @Setter
    int discountsSalary;

    @Getter
    @Setter
    int rawSalary;

    @Getter
    @Setter
    int previsionalSalary;

    @Getter
    @Setter
    int healthSalary;

    @Getter
    @Setter
    int realSsalary;
}
