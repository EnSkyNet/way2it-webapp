package com.way2it.yk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Integer id;
    private String shop;
    private Integer buyerId;
    private Integer productId;
    private Integer productQuantity;
}