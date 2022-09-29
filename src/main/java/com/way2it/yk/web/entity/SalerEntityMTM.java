package com.way2it.yk.web.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "saler")
@Data

public class SalerEntityMTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "buyer_saler", inverseJoinColumns =
            @JoinColumn(name = "buyer_id"),
            joinColumns = @JoinColumn(name = "saler_id"))
    private List<BuyerEntityMTM> buyerEntityMTMList = new ArrayList<>();

    @Override
    public String toString() {
        return "SalerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buyers= {" + buyerEntityMTMList.stream().map(BuyerEntityMTM::getName)
                .collect(Collectors.joining( ", "))
                +'}';
    }
}
