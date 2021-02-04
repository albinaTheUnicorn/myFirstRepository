package com.bb.core.repository;

import com.bb.core.domain.CategoryDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryDomain,Long>{
    List<CategoryDomain> findByCategoryNameLike(String name);
    List<CategoryDomain> findAll();
}
