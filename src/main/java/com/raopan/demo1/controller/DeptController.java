package com.raopan.demo1.controller;

import com.raopan.demo1.pojo.Dept;
import com.raopan.demo1.pojo.Result;
import com.raopan.demo1.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result getList() {
        log.info("查询所有的部门");
        List<Dept> deptsList = deptService.getList();
        return Result.success(deptsList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        //调用service删除部门
        deptService.deleteDept(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门: {}" , dept);
        //调用service新增部门
        deptService.addDept(dept);
        return Result.success();
    }
}
