package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.Employment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmploymentMapper extends BaseMapper<Employment> {
    @Select("SELECT * FROM employment")
    Employment getEmploymentById(Integer employmentId);
}