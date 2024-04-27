package com.raopan.demo1.controller;

import com.raopan.demo1.pojo.PageBean;
import com.raopan.demo1.pojo.Result;
import com.raopan.demo1.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    /**
     * 查询员工信息
     *
     * @param page 页码
     * @param pageSize 每页数量
     * @param name 姓名
     * @param gender 性别
     * @param begin 开始的索引
     * @param end 结束的索引
     * @return success(pageBean)
     */
    @GetMapping
    public Result getEmpList(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name,
                             Short gender,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("查询所有的员工，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.getList(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除员工
     *
     * @param ids 员工list
     * @return null
     */
    @DeleteMapping("/ids")
    public Result deleteUserByIds(List<Integer> ids) {
        log.info("批量删除员工，ids:{}", ids);
        empService.deleteUserByIds(ids);
        return Result.success();
    }
}
