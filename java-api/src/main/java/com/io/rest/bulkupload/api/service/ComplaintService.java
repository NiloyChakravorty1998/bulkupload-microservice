package com.io.rest.bulkupload.api.service;

import com.io.rest.bulkupload.api.dto.Complaint;
import com.io.rest.bulkupload.api.dto.VO.ViewComplaintResponseVO;
import com.io.rest.bulkupload.api.entity.ComplaintInfo;
import com.io.rest.bulkupload.api.repository.CustomerInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ComplaintService {
    private final CustomerInfoRepository repo;
    private final Logger logger = LoggerFactory.getLogger(ComplaintService.class);

    @Autowired
    public ComplaintService(CustomerInfoRepository repo) {
        this.repo = repo;
    }

    public ViewComplaintResponseVO newComplaint(Complaint complaint)
    {
        LocalDate currentDate = LocalDate.now();
        logger.info("Creating new complaint for customer : {} on " +currentDate, complaint.getCustomerId());
        try {
            ComplaintInfo customerInfo = ComplaintInfo.builder().customerId(complaint.getCustomerId())
                    .gender(complaint.getGender()).income(complaint.getIncome()).name(complaint.getName())
                    .incomeType(complaint.getIncomeType()).complaintMessage(complaint.getComplaintMessage())
                    .birthDate(complaint.getBirthDate()).occupationType(complaint.getOccupationType())
                    .highestQualification(complaint.getHighestQualification()).createDate(currentDate)
                    .maritalStatus(complaint.getMaritalStatus()).housingType(complaint.getHousingType()).build();
            repo.save(customerInfo);
        }catch (Exception e)
        {
            logger.error("Error at newComplaint method ");
            e.printStackTrace();
        }
        complaint.setCreateDate(currentDate);
        return ViewComplaintResponseVO.builder()
                .message("New Complaint Created").status("201").complaint(complaint).build();
    }

}
