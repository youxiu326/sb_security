package com.youxiu326.bean;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="sys_role")
public class Role implements Serializable {

    private String id;

    private String roleName;

    private String roleNameZh;

    /**
     * 角色拥有资源
     */
    private List<Resource> resources;

    @Id
    @GeneratedValue(generator = "sys_uid")
    @GenericGenerator(name = "sys_uid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameZh() {
        return roleNameZh;
    }

    public void setRoleNameZh(String roleNameZh) {
        this.roleNameZh = roleNameZh;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sys_role_resource", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id") })
    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}