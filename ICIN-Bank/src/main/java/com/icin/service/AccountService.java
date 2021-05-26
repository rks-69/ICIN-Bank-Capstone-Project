package com.icin.service;

import java.security.Principal;

import com.icin.domain.PrimaryAccount;
import com.icin.domain.SavingsAccount;



public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
    
    
}
