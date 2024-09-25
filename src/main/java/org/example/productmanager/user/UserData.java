package org.example.productmanager.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String title;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String todo;
}

