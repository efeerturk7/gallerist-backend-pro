package com.efeerturk.gallery_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{
    private String firstName;


    private String lastName;


    private String tckn;


    private Date birthOfDate;

    @OneToOne
    private Address address;

    @OneToOne
    private Account account;
}
