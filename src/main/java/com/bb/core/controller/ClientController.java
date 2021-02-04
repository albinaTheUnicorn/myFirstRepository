package com.bb.core.controller;

import com.bb.core.dto.Client;
import com.bb.core.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/client")
    public ResponseEntity<List<Client>> get(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Client> get(@PathVariable Long id){
        return ResponseEntity.ok(clientService.get(id));
    }

    @PostMapping(value = "/client")
    public ResponseEntity<Client> add(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @DeleteMapping(value = "/client/{clientId}/order{orderId}")
    public ResponseEntity<Client> addOrder(@PathVariable Long clientId, @PathVariable Long orderId){
        return ResponseEntity.ok(clientService.addOrder(clientId, orderId));
    }
}
