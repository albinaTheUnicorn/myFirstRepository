package com.bb.core.repository;

import com.bb.core.domain.ProductDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductDomain,Long>{
    List<ProductDomain> findByProductNameLike(String name);
    List<ProductDomain> findAll();
    Optional<ProductDomain> findByProductId(Long id);
}
