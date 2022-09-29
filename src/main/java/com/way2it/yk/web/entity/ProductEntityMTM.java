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
@Table(name = "product")

public class ProductEntityMTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer price;


    public ProductEntityMTM(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}