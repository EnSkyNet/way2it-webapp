package com.way2it.yk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyerDto {
    private Integer id;
    private String name;
    private Integer money;

    public BuyerDto(String name, Integer money) {
        this.name = name;
        this.money = money;
    }
}
