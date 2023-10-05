package com.io.rest.bulkupload.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConversionAPIResponseDTO {
    private Long idKey;
    private Long customerId;
}
