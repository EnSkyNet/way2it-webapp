package com.way2it.yk.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "saler")

public class SalerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "buyer_saler", inverseJoinColumns =
            @JoinColumn(name = "buyer_id"),
            joinColumns = @JoinColumn(name = "saler_id"))
    private List<BuyerEntity> buyerEntityList = new ArrayList<>();

    @Override
    public String toString() {
        return "SalerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buyers= {" + buyerEntityList.stream().map(BuyerEntity::getName)
                .collect(Collectors.joining( ", "))
                +'}';
    }
}
