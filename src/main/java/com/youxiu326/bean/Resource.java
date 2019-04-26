package com.youxiu326.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="sys_Resource")
public class Resource implements Serializable {

    private String id;

    private String url;

    private String resName;

    /**
     * 上级权限
     */
    private Resource parent;

    /**
     * 下级权限
     */
    private List<Resource> children;

    @Id
    @GeneratedValue(generator = "sys_uid")
    @GenericGenerator(name = "sys_uid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    /*
     * 级联删除
     * @return
     */
    @OneToMany(cascade={CascadeType.REMOVE},mappedBy = "parent")
    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }
}