package com.youxiu326.security;

import com.youxiu326.bean.User;
import com.youxiu326.bean.UserDetailsImpl;
import com.youxiu326.repository.UserDao;
import com.youxiu326.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * 简单来讲就是程序接收到了用户输入的用户名，交给了UserService，它根据用户名去数据库中取到用户的信息，
 * 封装到实体类User的实例中，然后使用该User实例，再利用RoleService（封装了RoleRopository）查出该User对用的roles，
 * 构造一个UserDetailsImpl的对象，把这个对象返回给程序
 */
@Service
//框架需要使用到一个实现了UserDetailsService接口的类
public class MyUserDetailsService implements UserDetailsService{


    @Autowired
    private UserDao userRepository;

    @Autowired
    private RoleService roleService;

    @Transactional
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    @Transactional
    public List<User> getByUsername(String userName)
    {
        return userRepository.findByUserName(userName);
    }


    @Override
    //重写UserDetailsService接口里面的抽象方法
    //根据用户名 返回一个UserDetails的实现类的实例
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("查找用户：" + s);
        List<User> list = getByUsername(s);
        if (list==null || list.size()==0){
            throw new UsernameNotFoundException("没有该用户");
        }
        User user = getByUsername(s).get(0);
        if(user == null)
        {
            throw new UsernameNotFoundException("没有该用户");
        }

        //查到User后将其封装为UserDetails的实现类的实例供程序调用
        //用该User和它对应的Role实体们构造UserDetails的实现类
        return new UserDetailsImpl(user, roleService.getRolesOfUser(user.getUserName()));
    }

}