package com.camus.starter.Models;


import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Where(clause = "active = 1")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "active", columnDefinition = "int default 1")
    private Integer active;

    public int getId() {
        return id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
