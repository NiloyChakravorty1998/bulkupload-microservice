package com.io.rest.bulkupload.api.controller;

import com.io.rest.bulkupload.api.dto.Complaint;
import com.io.rest.bulkupload.api.dto.VO.ViewComplaintResponseVO;
import com.io.rest.bulkupload.api.service.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ComplaintController {
    private final Logger logger = LoggerFactory.getLogger(ComplaintController.class);
    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/complaint")
    public ResponseEntity<ViewComplaintResponseVO> newComplaint(@RequestBody Complaint newComplaint)
    {
        logger.trace("Fired /complaint to create newComplaint");

        ViewComplaintResponseVO response = complaintService.newComplaint(newComplaint);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
