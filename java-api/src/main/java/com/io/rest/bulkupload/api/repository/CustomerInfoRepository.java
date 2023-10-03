package com.io.rest.bulkupload.api.repository;

import com.io.rest.bulkupload.api.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Long> {
}
