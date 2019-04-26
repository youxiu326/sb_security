package com.youxiu326.service;

import com.youxiu326.bean.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRolesOfUser(String userName);

} 