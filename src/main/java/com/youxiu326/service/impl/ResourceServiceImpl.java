package com.youxiu326.service.impl;

import com.youxiu326.bean.Resource;
import com.youxiu326.bean.Role;
import com.youxiu326.repository.ResourceDao;
import com.youxiu326.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public Resource getResourceByUrl(String url) {
        return resourceDao.findByUrl(url);
    }

    @Override
    public List<Role> getRoles(String resourceId) {
        return resourceDao.findRolesOfResource(resourceId);
    }
}