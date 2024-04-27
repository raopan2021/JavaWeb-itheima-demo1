package com.raopan.demo1.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.raopan.demo1.mapper.EmpMapper;
import com.raopan.demo1.pojo.Emp;
import com.raopan.demo1.pojo.PageBean;
import com.raopan.demo1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean getList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
//        Long total = empMapper.getEmpCount();
//
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.getEmpListPage(start, pageSize);
//        return new PageBean(total,empList);

        PageHelper.startPage(page, pageSize);

        List<Emp> empList = empMapper.getEmpListPage(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        return new PageBean(p.getTotal(), p.getResult());

    }

    @Override
    public void deleteUserByIds(List<Integer> ids) {
        empMapper.deleteUserByIds(ids);
    }
}
