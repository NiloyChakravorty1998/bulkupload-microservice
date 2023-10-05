package com.io.rest.bulkupload.api.dao;

import com.io.rest.bulkupload.api.dto.ConversionAPIResponseDTO;
import com.io.rest.bulkupload.api.dto.ConversionAPIRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CustomerIdConversion {

    @Value("${api.url}")
    private String API_URI;
    private final RestTemplate template;

    @Autowired
    public CustomerIdConversion(RestTemplate template) {
        this.template = template;
    }

    private final Logger logger = LoggerFactory.getLogger(CustomerIdConversion.class);


    public ConversionAPIResponseDTO getIdKey(ConversionAPIRequestDTO dto)
    {
        logger.info("Calling customer Id tokenization for {}", dto.getCustomerId());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ConversionAPIRequestDTO> requestBody = new HttpEntity<>(dto,headers);
        try {
            ResponseEntity<ConversionAPIResponseDTO> response =
                    template.postForEntity(API_URI + "/tokenize", requestBody, ConversionAPIResponseDTO.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                ConversionAPIResponseDTO responseBody = response.getBody();
                return responseBody;
            }
        }catch (Exception e)
        {
            logger.error("Error while tokenization");
            e.printStackTrace();
        }
        return null;
    }
    public ConversionAPIResponseDTO getCustomerId(ConversionAPIRequestDTO dto)
    {
        logger.info("Calling customer Id de-tokenization for {}", dto.getIdKey());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ConversionAPIRequestDTO> requestBody = new HttpEntity<>(dto,headers);
        try {
            ResponseEntity<ConversionAPIResponseDTO> response =
                    template.postForEntity(API_URI + "/detokenize", requestBody, ConversionAPIResponseDTO.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                ConversionAPIResponseDTO responseBody = response.getBody();
                return responseBody;
            }
        }catch (Exception e)
        {
            logger.error("Error while detokenization");
            e.printStackTrace();
        }
        return null;
    }
}
