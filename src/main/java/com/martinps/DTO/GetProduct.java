package com.martinps.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProduct {

    private long productId;
    private String productName;
    private String price;
    private LocalDateTime creationDate;
    private GetCategory productCategory;

}
