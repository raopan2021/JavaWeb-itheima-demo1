package com.raopan.demo1.service.impl;

import com.raopan.demo1.mapper.DeptMapper;
import com.raopan.demo1.pojo.Dept;
import com.raopan.demo1.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getList() {
        return deptMapper.getList();
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
}
