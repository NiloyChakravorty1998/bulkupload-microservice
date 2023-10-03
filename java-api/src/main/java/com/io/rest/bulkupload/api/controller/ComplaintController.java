package com.io.rest.bulkupload.api.controller;

import com.io.rest.bulkupload.api.dto.VO.ViewAllComplaintResponseVO;
import com.io.rest.bulkupload.api.dto.VO.ViewComplaintResponseVO;
import com.io.rest.bulkupload.api.entity.ComplaintInfo;
import com.io.rest.bulkupload.api.service.ComplaintService;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ComplaintController {
    private final Logger logger = LoggerFactory.getLogger(ComplaintController.class);
    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/complaint")
    public ResponseEntity<ViewAllComplaintResponseVO> getAllComplaints()
    {
        logger.info("GET :  /complaint to get all complaints");
        ViewAllComplaintResponseVO response = complaintService.getAllComplaints();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/complaint/{createDate}/{name}")
    public ResponseEntity<ViewComplaintResponseVO> updateComplaint
            (@NotNull @PathVariable("createDate") String createDate,
             @NotNull @PathVariable("name") String name,@RequestBody ComplaintInfo complaint)
    {
        logger.info("PUT :  /complaint to update complaint");
        ViewComplaintResponseVO response = complaintService.updateComplaint(createDate,name,complaint);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/complaint")
    public ResponseEntity<ViewComplaintResponseVO> newComplaint(@RequestBody ComplaintInfo newComplaint)
    {
        logger.info("POST : /complaint to create new complaint");
        ViewComplaintResponseVO response = complaintService.newComplaint(newComplaint);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
