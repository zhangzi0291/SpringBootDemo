package com.demo.sys.entity;


import java.util.List;

public class SysResourceDto extends SysResource{

    List<SysResourceDto> children;

    public String getTitle() {
        return this.getResourceName();
    }

    public List<SysResourceDto> getChildren() {
        return children;
    }

    public void setChildren(List<SysResourceDto> children) {
        this.children = children;
    }

//    public Boolean getLoading() {
//        return this.getChild().size()>0?false:null;
//    }
}