package com.youxiu326.service.impl;

import com.youxiu326.bean.Role;
import com.youxiu326.repository.RoleDao;
import com.youxiu326.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRolesOfUser(String userName) {
        return roleDao.findRolesByUser(userName);
    }

}