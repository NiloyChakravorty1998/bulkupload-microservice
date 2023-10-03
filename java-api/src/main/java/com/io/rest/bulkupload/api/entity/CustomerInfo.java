package com.io.rest.bulkupload.api.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CUSTOMER_DATA")
public class CustomerInfo {
   @Id
   @NotNull
   private Long customerId;
   @NotNull
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
}
