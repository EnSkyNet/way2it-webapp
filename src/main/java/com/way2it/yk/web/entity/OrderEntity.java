package com.way2it.yk.web.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "orders")

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer total;

    @OneToOne(cascade = CascadeType.ALL)
    private BuyerEntity buyer;

    public OrderEntity(Integer total, BuyerEntity buyer) {
        this.total = total;
        this.buyer = buyer;
    }
}

