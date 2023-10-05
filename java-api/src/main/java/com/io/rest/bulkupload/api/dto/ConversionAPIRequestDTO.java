package com.io.rest.bulkupload.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConversionAPIRequestDTO {
    private Long customerId;
    private String name;
    private Long idKey;
}
