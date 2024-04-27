package com.raopan.demo1.mapper;

import com.raopan.demo1.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    //    @Select("select count(*) from emp")
//    public Long getEmpCount();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> getEmpListPage(Integer start, Integer pageSize);
//
    List<Emp> getEmpListPage(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void deleteUserByIds(List<Integer> ids);
}
