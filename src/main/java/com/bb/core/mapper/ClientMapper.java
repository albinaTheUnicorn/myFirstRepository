package com.bb.core.mapper;

import com.bb.core.domain.ClientDomain;
import com.bb.core.dto.Client;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

public class ClientMapper {

    public static Client map(ClientDomain clientDomain){
        Client client = new Client();
        client.setClientId(clientDomain.getClientId());

        if (!CollectionUtils.isEmpty(clientDomain.getOrders())) {
            client.setOrders(clientDomain.getOrders()
                .stream()
                .map(OrderMapper::map)
                .collect(Collectors.toSet()));
        }

        client.setPersonalData(PersonalDataMapper.map(clientDomain.getPersonalDataDomain()));

      return client;
    }

    public static ClientDomain map(Client client){

        ClientDomain clientDomain = new ClientDomain();
        clientDomain.setClientId(client.getClientId());
        if(client.getPersonalData() != null) {
            clientDomain.setPersonalDataDomain(PersonalDataMapper.map(client.getPersonalData()));
        }
        return clientDomain;

    }

}
