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
@Table(name = "cash")
public class Cash implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cash_name_id")
    private Integer cashNameId;

    @Column(name = "first_balance")
    private Double firstBalance;

    @Column(name = "income")
    private Double income;

    @Column(name = "expense")
    private Double expense;

    @Column(name = "last_balance")
    private Double lastBalance;

    @Column(name = "operation_type")
    private Integer operationType;

    @Column(name = "data_date")
    private java.sql.Timestamp dataDate;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "employee_id")
    private Long employeeId;

}
