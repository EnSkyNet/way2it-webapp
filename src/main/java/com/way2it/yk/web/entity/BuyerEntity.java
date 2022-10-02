package com.way2it.yk.web.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "buyer")

public class BuyerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer money;
    @OneToMany(mappedBy = "buyerEntity", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CartEntity> cartEntityList = new ArrayList<>();

    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private OrderEntity orderEntity;

    @ManyToMany(mappedBy = "buyerEntityList", cascade = CascadeType.ALL)
    private List<SalerEntity> salerEntityList = new ArrayList<>();

    @Override
    public String toString() {
        return "BuyerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                /*", shop=" + cartEntityOTOList
                .stream().map(CartEntityOTO::getShop).toList()*/
               /* salerEntityMTMList.stream().map(SalerEntityMTM::getName)
                        .collect(Collectors.joining(", "))*/
                +'}';
    }

    public BuyerEntity(String name, Integer money) {
        this.name = name;
        this.money = money;
    }
}
