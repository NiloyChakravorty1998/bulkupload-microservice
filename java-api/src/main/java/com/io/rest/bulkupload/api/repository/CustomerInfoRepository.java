package com.io.rest.bulkupload.api.repository;

import com.io.rest.bulkupload.api.entity.ComplaintInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface CustomerInfoRepository extends JpaRepository<ComplaintInfo,Long> {
    ComplaintInfo getByCreateDateAndName(LocalDate createDate, String name);
}
