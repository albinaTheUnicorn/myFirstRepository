package com.bb.core.service;

import com.bb.core.domain.ClientDomain;
import com.bb.core.domain.OrderDomain;
import com.bb.core.dto.Client;
import com.bb.core.mapper.ClientMapper;
import com.bb.core.repository.CategoryRepository;
import com.bb.core.repository.ClientRepository;
import com.bb.core.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository,
        OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
    }

    public Client addOrder(Long clientId, Long orderId){
        return clientRepository.findById(clientId)
            .map(clientDomain ->  {
                OrderDomain orderDomain = orderRepository.findById(orderId)
                    .orElseThrow(
                    () -> new RuntimeException("Element not found! For clientId: " + clientId));
                clientDomain.setOrder(orderDomain);
                return clientRepository.save(clientDomain);
            } )
            .map(ClientMapper::map)
            .orElseThrow(() -> new RuntimeException("Element not found! For clientId: " + clientId));
    }

    public Client get(Long clientId){
        return clientRepository.findById(clientId)
            .map(ClientMapper::map)
            .orElseThrow(() -> new RuntimeException("Element not found! For clientId: " + clientId));
    }
    public List<Client> getAll(){
        return clientRepository.findAll()
            .stream()
            .map(ClientMapper::map)
            .collect(Collectors.toList());
    }

    public Client save(Client client){
        return ClientMapper.map(clientRepository.save(ClientMapper.map(client)));
     }

    public void delete(Long id){
        ClientDomain client = clientRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Element not found! For clientId: " + id));
            clientRepository.delete(client);
    }
}
