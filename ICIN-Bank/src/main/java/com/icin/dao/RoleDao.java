package com.icin.dao;

import org.springframework.data.repository.CrudRepository;

import com.icin.domain.security.Role;


public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
