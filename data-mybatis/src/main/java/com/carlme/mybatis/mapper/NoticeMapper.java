package com.carlme.mybatis.mapper;

import com.carlme.mybatis.bean.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface NoticeMapper {

    Notice getById(String id);

    @Select("select * from department where id=#{id}")
    Notice getByIdNon(String id);

    @Delete("delete from department where id=#{id}")
    int deleteById(String id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insert(Notice department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    int update(Notice department);
}
