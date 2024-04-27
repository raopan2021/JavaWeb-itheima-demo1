package com.raopan.demo1.service;

import com.raopan.demo1.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;


/**
 * 员工管理
 */
public interface EmpService {
    PageBean getList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteUserByIds(List<Integer> ids);
}
