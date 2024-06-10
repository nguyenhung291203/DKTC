package com.example.be.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="teachers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @Column(length = 8)
    private String id;
    @NotNull
    private String name;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="unit_id",nullable = false)
    private Unit unit;
    private String position;
    @OneToOne()
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;
}
