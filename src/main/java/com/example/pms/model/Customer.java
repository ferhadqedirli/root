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
@Table(name = "customer")
public class Customer  implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "email")
    private String email;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "customer_legal_status_type")
    private Integer customerLegalStatusType;

    @Column(name = "description")
    private String description;

    @Column(name = "address_line")
    private String addressLine;

}
