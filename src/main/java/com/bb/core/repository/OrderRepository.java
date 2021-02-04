package com.bb.core.repository;

import com.bb.core.domain.OrderDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<OrderDomain,Long> {
    List<OrderDomain> findAll();
    Optional<OrderDomain> findByOrderId(Long id);
}
