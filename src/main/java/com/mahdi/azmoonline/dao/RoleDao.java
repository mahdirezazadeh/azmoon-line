package com.mahdi.azmoonline.dao;

import com.mahdi.azmoonline.base.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
