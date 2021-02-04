package com.bb.core.dto;

import com.bb.core.domain.OrderDomain;
import com.bb.core.domain.PersonalDataDomain;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Client {

    private Long clientId;
    Set<Order> orders = new HashSet<>();
    private PersonalData personalData;
}
