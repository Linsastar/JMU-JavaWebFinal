package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.Employer;
import jmu.gcy.bean.Employment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmploymentMapper extends BaseMapper<Employment> {
    @Select("SELECT * FROM employment where employment.job_title like concat('%',#{type},'%')")
     List<Employment> findByTypeContaining(String type);
    @Select("SELECT * FROM employment where employer_id = #{employerId}")
    Employment getEmploymentById(Integer employmentId);
    @Select("SELECT * FROM employment ")
    Employment getAllEmployments();

    @Select("SELECT * FROM employer where employer_id = #{employerId}")
    Employer getEmployerById(int employerId);

}
