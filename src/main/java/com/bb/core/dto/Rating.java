package com.bb.core.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Rating {
    private Long clientId;
    private Long productId;
    private Integer mark;
}
