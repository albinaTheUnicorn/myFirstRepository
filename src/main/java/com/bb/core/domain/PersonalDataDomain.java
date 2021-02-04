package com.bb.core.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "personal_data")
public class PersonalDataDomain {
    @Id
    @GeneratedValue
    @Column(name = "personal_data_id")
    private Long personalDataId;
    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private AddressDomain addressDomain;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "client_last_name")
    private String clientLastName;
    @Column(name = "birth_date")
    private Date birthDate;
}

