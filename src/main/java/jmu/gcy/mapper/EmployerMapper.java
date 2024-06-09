package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.Employer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployerMapper extends BaseMapper<Employer> {
    @Select("select * from employer")
    List<Employer> getAllEmployers();

    @Select("select * from employer where employer_id = #{employerId}")
    Employer getEmployerById(int employerId);

}
