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
@Table(name = "requisite")
public class Requisite implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "customer_id")
    private Integer customerId;

}
