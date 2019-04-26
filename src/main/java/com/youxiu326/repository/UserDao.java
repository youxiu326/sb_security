package com.youxiu326.repository;

import com.youxiu326.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao extends JpaRepository<User, String> {

    List<User> findByUserName(String userName);

}