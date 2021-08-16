/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
public class Invoice {
    private String id;
    private String reference;
    private LocalDateTime date;
    private BigDecimal amount;
    private String buyerName;
    private String sellerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

}