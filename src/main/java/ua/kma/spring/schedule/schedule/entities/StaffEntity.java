package ua.kma.spring.schedule.schedule.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StaffEntity extends UserEntity {
    //Change to enum
    @Column(name = "position")
    private String position;

}
