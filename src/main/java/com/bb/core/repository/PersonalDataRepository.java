package com.bb.core.repository;


import com.bb.core.domain.PersonalDataDomain;
import com.bb.core.dto.PersonalData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalDataRepository extends CrudRepository<PersonalDataDomain,Long> {
    List<PersonalDataDomain> findAll();
    Optional<PersonalDataDomain> findByPersonalDataId(Long id);
}
