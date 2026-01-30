package com.ruwini01.Project1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruwini01.Project1.Models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    

}
