package com.way2it.yk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    private Integer total;
    private Integer buyerId;
}
