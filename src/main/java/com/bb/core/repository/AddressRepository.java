package com.bb.core.repository;

import com.bb.core.domain.AddressDomain;
import com.bb.core.dto.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<AddressDomain,Long> {
    List<AddressDomain> findAll();
    Optional<AddressDomain> findByAddressId(Long id);
}
