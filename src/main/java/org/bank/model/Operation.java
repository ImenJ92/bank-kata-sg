package org.bank.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Long accountId;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private OPERATION_TYPE type;
    private double amount;

    private double balance;

    public Operation() {
    }

    public Operation(Long accountId, OPERATION_TYPE type, double amount, double balance, Date creationDate) {
        this.accountId = accountId;
        this.creationDate = creationDate;
        this.type = type;
        this.amount = amount;
        this.balance = balance;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public OPERATION_TYPE getType() {
        return type;
    }

    public void setType(OPERATION_TYPE type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
