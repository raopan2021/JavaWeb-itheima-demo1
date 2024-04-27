package com.raopan.demo1.mapper;

import com.raopan.demo1.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> getList();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
