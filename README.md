
参考博客链接: https://blog.csdn.net/Canon_in_D_Major/article/details/79688441


一般流程为：

①当用户登录时，前端将用户输入的用户名、密码信息传输到后台，后台用一个类对象将其封装起来，通常使用的是UsernamePasswordAuthenticationToken这个类。

②程序负责验证这个类对象。验证方法是调用Service根据username从数据库中取用户信息到实体类的实例中，比较两者的密码，如果密码正确就成功登陆，同时把包含着用户的用户名、密码、所具有的权限等信息的类对象放到SecurityContextHolder（安全上下文容器，类似Session）中去。

③用户访问一个资源的时候，首先判断是否是受限资源。如果是的话还要判断当前是否未登录，没有的话就跳到登录页面。

④如果用户已经登录，访问一个受限资源的时候，程序要根据url去数据库中取出该资源所对应的所有可以访问的角色，然后拿着当前用户的所有角色一一对比，判断用户是否可以访问。



WebSecurityConfig类中的

.successHandler()和.failureHandler()定义了登陆页面的登陆成功和登录失败后所做的事情




测试地址:
localhost:8080/login


账号:user 密码:111111 user角色


账号:admin 密码:111111 admin角色
