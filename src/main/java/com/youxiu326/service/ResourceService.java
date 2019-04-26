package com.youxiu326.service;

import com.youxiu326.bean.Resource;
import com.youxiu326.bean.Role;

import java.util.List;

public interface ResourceService {

    Resource getResourceByUrl(String url);

    List<Role> getRoles(String resourceId);

} 