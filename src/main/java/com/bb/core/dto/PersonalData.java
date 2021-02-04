package com.bb.core.dto;

import com.bb.core.domain.AddressDomain;
import lombok.Data;

import java.util.Date;

@Data
public class PersonalData {

    private Long personalDataId;
    private Address address;
    private String clientName;
    private String clientLastName;
    private Date birthDate;


}
