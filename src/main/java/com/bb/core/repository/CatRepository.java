package com.bb.core.repository;

import com.bb.core.domain.CatDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends CrudRepository<CatDomain,Long>{
    List<CatDomain> findByNameLike(String name);
    List<CatDomain> findAll();
}
