package com.youxiu326.service;

import com.youxiu326.bean.Role;

import java.util.List;

public interface RoleService {

    /**
     * 根据用户code查询该用户拥有的所有角色
     * @param userName 用户code
     * @return
     */
    List<Role> getRolesOfUser(String userName);

} 