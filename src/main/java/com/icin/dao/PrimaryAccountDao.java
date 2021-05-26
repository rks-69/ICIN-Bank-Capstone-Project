package com.icin.dao;

import org.springframework.data.repository.CrudRepository;

import com.icin.domain.PrimaryAccount;


public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);
}

