package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.Employment;
import jmu.gcy.bean.JobApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobApplicationMapper extends BaseMapper<JobApplication> {
    @Select("SELECT * FROM job_application WHERE employer_id = #{employerId}")
    List<JobApplication> getApplicationsByEmployerId(int employerId);

    @Select("SELECT * FROM employment WHERE employment_id = #{employmentId}")
    Employment getEmploymentById(Integer employmentId);

    @Select("SELECT * FROM job_application WHERE application_id = #{applicationId}")
    JobApplication getApplicationsByApplicationId(int applicationId);
}
