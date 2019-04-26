package com.youxiu326.repository;

import com.youxiu326.bean.Resource;
import com.youxiu326.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Created by lihui on 2019/1/29.
 */
public interface ResourceDao extends JpaRepository<Resource, String> {

    @Query("select distinct r.resources from User as o left join o.roles as r where o.id = ?1")
    public List<Resource> findResourcesByOperator(String operatorId);

    @Query("from Resource ")
    public List<Resource> findAll();

    Resource findByUrl(String url);

    //自定义sql语句并且开启本地sql
    //根据用户名查找该用户所有权限
    //@Query(value = "select r.* from role r, user_role ur where ur.username = ?1 and ur.rid = r.id", nativeQuery = true)
    //public List<Role> findRolesOfUser(String username);

    //根据resource的主键查找resource允许的所有权限
    //@Query(value = "select r.* from sys_role r, sys_role_resource rr where rr.resource_id = ?1 and rr.role_id = r.id", nativeQuery = true)
    @Query("select r from Role r left join r.resources as rs where rs.id=?1 ")
    public List<Role> findRolesOfResource(String resourceId);

}