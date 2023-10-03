package com.io.rest.bulkupload.api.service;

import com.io.rest.bulkupload.api.dto.VO.ViewAllComplaintResponseVO;
import com.io.rest.bulkupload.api.dto.VO.ViewComplaintResponseVO;
import com.io.rest.bulkupload.api.entity.ComplaintInfo;
import com.io.rest.bulkupload.api.repository.CustomerInfoRepository;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ComplaintService {
    private final CustomerInfoRepository repo;
    private final Logger logger = LoggerFactory.getLogger(ComplaintService.class);

    @Autowired
    public ComplaintService(CustomerInfoRepository repo) {
        this.repo = repo;
    }

    public ViewComplaintResponseVO newComplaint(ComplaintInfo complaint)
    {
        ComplaintInfo complaintInfo = null;
        LocalDate currentDate = LocalDate.now();
        logger.info("Creating new complaint for customer : {} on " +currentDate, complaint.getCustomerId());
        try {
            complaintInfo = ComplaintInfo.builder().customerId(complaint.getCustomerId())
                    .gender(complaint.getGender()).income(complaint.getIncome()).name(complaint.getName())
                    .incomeType(complaint.getIncomeType()).complaintMessage(complaint.getComplaintMessage())
                    .birthDate(complaint.getBirthDate()).occupationType(complaint.getOccupationType())
                    .highestQualification(complaint.getHighestQualification()).createDate(currentDate)
                    .maritalStatus(complaint.getMaritalStatus()).housingType(complaint.getHousingType()).build();
            repo.save(complaintInfo);
        }catch (Exception e)
        {
            logger.error("Error at newComplaint method ");
            e.printStackTrace();
        }
        return ViewComplaintResponseVO.builder()
                .message("New Complaint Created").status("201").complaint(complaintInfo).build();
    }

    public ViewAllComplaintResponseVO getAllComplaints() {
        LocalDate currentDate = LocalDate.now();
        List<ComplaintInfo> complaints= null;
        logger.info("Get all complaints on " +currentDate);
        try {
            complaints = repo.findAll();
        }catch (Exception e)
        {
            logger.error("Error at getAllComplaints method ");
            e.printStackTrace();
        }
        return ViewAllComplaintResponseVO.builder().message("All Complaints").status("200")
                .complaints(complaints).build();
    }

    public ViewComplaintResponseVO updateComplaint(@NotNull String createDate,
                                                   @NotNull String name, ComplaintInfo complaint)
    {
        ComplaintInfo complaintInfo = null;
        logger.info("Update complaint for {} from " +createDate,name);
        try {
            complaintInfo = repo.getByCreateDateAndName(createDate.toString(), name);
        } catch (EntityNotFoundException e)
        {
            logger.error("Error at updateComplaint method ");
            e.printStackTrace();
        }
        if(complaintInfo != null)
        {
            try
            {
                complaintInfo.setComplaintMessage(complaint.getComplaintMessage());
                repo.save(complaintInfo);
            }
            catch (Exception e)
            {
                logger.error("Error at updateComplaint method ");
                e.printStackTrace();
            }
        }
        return ViewComplaintResponseVO.builder().complaint(complaintInfo).status("200")
                .message("Successfully Updated").build();
    }
}
