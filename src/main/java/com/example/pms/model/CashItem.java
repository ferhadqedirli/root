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
@Table(name = "cash_item")
public class CashItem implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "expense_id")
    private Integer expenseId;

    @Column(name = "income_id")
    private Integer incomeId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "description")
    private String description;

}
