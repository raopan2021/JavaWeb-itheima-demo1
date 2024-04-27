package com.raopan.demo1.service;

import com.raopan.demo1.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    List<Dept> getList();

    void deleteDept(Integer id);

    void addDept(Dept dept);
}
