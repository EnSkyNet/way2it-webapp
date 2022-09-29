package com.way2it.yk.web.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cart")

public class CartEntityMTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    private BuyerEntityMTM buyerEntityMTM;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntityMTM productEntityMTM;
    @Column
    private Integer product_quantity;
    @Column
    private String shop;


}
