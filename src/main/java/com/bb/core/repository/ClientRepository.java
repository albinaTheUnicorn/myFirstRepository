package com.bb.core.repository;


import com.bb.core.domain.ClientDomain;
import com.bb.core.domain.OrderDomain;
import com.bb.core.dto.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<ClientDomain,Long> {
    List<ClientDomain> findAll();
    Optional<ClientDomain> findByClientId(Long id);
}
