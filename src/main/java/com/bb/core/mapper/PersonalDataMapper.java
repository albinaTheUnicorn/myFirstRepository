package com.bb.core.mapper;

import com.bb.core.domain.PersonalDataDomain;
import com.bb.core.dto.PersonalData;

public class PersonalDataMapper {
    public static PersonalData map(PersonalDataDomain personalDataDomain){
        PersonalData personalData = new PersonalData();
        personalData.setPersonalDataId(personalDataDomain.getPersonalDataId());
        if(personalDataDomain.getAddressDomain() != null) {
            personalData.setAddress(AddressMapper.map(personalDataDomain.getAddressDomain()));
        }
        personalData.setClientName(personalDataDomain.getClientName());
        personalData.setClientLastName(personalDataDomain.getClientLastName());
        personalData.setBirthDate(personalDataDomain.getBirthDate());
        return personalData;

    }

    public static  PersonalDataDomain map(PersonalData personalData ){
        PersonalDataDomain personalDataDomain = new PersonalDataDomain();
        personalDataDomain.setPersonalDataId(personalData.getPersonalDataId());
        if(personalData.getAddress() != null) {
            personalDataDomain.setAddressDomain(AddressMapper.map(personalData.getAddress()));
        }
        personalDataDomain.setClientName(personalData.getClientName());
        personalDataDomain.setClientLastName(personalData.getClientLastName());
        personalDataDomain.setBirthDate(personalData.getBirthDate());
        return personalDataDomain;
    }
}
