package com.example.medicframe_test.entity;

import com.example.medicframe_test.entity.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {

    @NotBlank
    @Column(name = "account_id", unique = true, nullable = false)
    private String accountId;

    @Id
    @NotBlank
    @Column(name = "transaction_id", unique = true, nullable = false)
    private String transactionId;

    //identifies a group of transactions
    // a SALE and REFUND would have the same orderId ???
    @NotBlank
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @NotBlank
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @NotBlank
    @Min(3)
    @Max(3)
    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Transaction() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
}
