package com.io.rest.bulkupload.api.dto.VO;


import com.io.rest.bulkupload.api.entity.ComplaintInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewAllComplaintResponseVO {
    private String message;
    private String status;
    private List<ComplaintInfo> complaints;
}
