package ua.edu.ukma.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Staff extends User {
    //Change to enum
    @Column(name = "position")
    private String position;

}
