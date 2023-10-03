package com.io.rest.bulkupload.api.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complaint {
    @NotNull
    private Long customerId;
    private String name;
    private String gender;
    private String income;
    private String incomeType;
    private String highestQualification;
    private String maritalStatus;
    private String housingType;
    private String occupationType;
    private LocalDate birthDate;
    private String complaintMessage;
    private LocalDate createDate;
}
