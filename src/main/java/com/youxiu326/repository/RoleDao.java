package com.youxiu326.repository;

import com.youxiu326.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, String> {


    /*
    @Query("select distinct r.resources from Operator as o left join o.roles as r where o.id = ?1")
     public List<Resource> findResourcesByOperator(String operatorId);
    */

    @Query("select distinct r.roles from User as r where r.userName=?1")
    List<Role> findRolesByUser(String userName);

}