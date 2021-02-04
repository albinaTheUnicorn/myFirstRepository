package com.bb.core.mapper;

import com.bb.core.domain.AddressDomain;
import com.bb.core.dto.Address;

public class AddressMapper {

    public static Address map(AddressDomain addressDomain){

        Address address = new Address();
        address.setAddressId(addressDomain.getAddressId());
        address.setCity((addressDomain.getCity()));
        address.setPostCarrier(addressDomain.getPostCarrier());
        address.setPostCarrierDepartmentNumber(addressDomain.getPostCarrierDepartmentNumber());
        return address;
    }


    public static AddressDomain map(Address address){

        AddressDomain addressDomain = new AddressDomain();
        addressDomain.setAddressId(address.getAddressId());
        addressDomain.setCity(address.getCity());
        addressDomain.setPostCarrier(address.getPostCarrier());
        addressDomain.setPostCarrierDepartmentNumber(address.getPostCarrierDepartmentNumber());
        return addressDomain;

    }
}
