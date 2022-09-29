package com.way2it.yk.web.entity;

import lombok.*;

import javax.persistence.*;
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

public class BuyerEntityMTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer money;
    @OneToMany(mappedBy = "buyerEntityMTM", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CartEntityMTM> cartEntityMTMList = new ArrayList<>();

    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private OrderEntityMTM orderEntityMTM;

    @ManyToMany(mappedBy = "buyerEntityMTMList", cascade = CascadeType.ALL)
    private List<SalerEntityMTM> salerEntityMTMList = new ArrayList<>();

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

    public BuyerEntityMTM(String name, Integer money) {
        this.name = name;
        this.money = money;
    }
}
