package com.example.pms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank")
public class Bank implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "correspondent_number")
    private String correspondentNumber;

    @Column(name = "code")
    private String code;

    @Column(name = "swift")
    private String swift;

    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "address_line")
    private String addressLine;

}
