package com.way2it.yk.web.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")

public class OrderEntityMTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer total;

    @OneToOne(cascade = CascadeType.ALL)
    private BuyerEntityMTM buyer;

    public OrderEntityMTM(Integer total, BuyerEntityMTM buyer) {
        this.total = total;
        this.buyer = buyer;
    }
}

