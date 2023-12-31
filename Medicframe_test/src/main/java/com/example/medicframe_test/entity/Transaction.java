package com.example.medicframe_test.entity;

import com.example.medicframe_test.entity.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @NotNull
    @Column(name = "transaction_id", unique = true, nullable = false)
    private String transactionId;

    @NotNull
    @Column(name = "account_id", nullable = false)
    private String accountId;

    //identifies a group of transactions
    //SALE and REFUND would have the same orderId ???
    @NotNull
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @NotNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @NotNull
    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;



    public Transaction() {
    }

    public Transaction(String transactionId, String accountId, String orderId, TransactionType transactionType, BigDecimal amount, String currency, String description) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.orderId = orderId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
