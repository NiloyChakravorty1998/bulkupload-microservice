package com.io.rest.bulkupload.api.dto.VO;

import com.io.rest.bulkupload.api.entity.ComplaintInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewComplaintResponseVO {
    private String message;
    private String status;
    private ComplaintInfo complaint;
}
