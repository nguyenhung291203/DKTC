package com.example.be.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="universities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class University {
    @Id
    @Column(length = 10)
    private String id;
    @NotNull
    private String name;
    private String address;

}
