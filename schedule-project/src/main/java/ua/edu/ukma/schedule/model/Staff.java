package ua.edu.ukma.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "staff")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Staff extends User {
    //Change to enum
    @Column(name = "position")
    private String position;

}
