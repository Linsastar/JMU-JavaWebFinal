package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("SELECT * FROM student WHERE student_id = #{studentId}")
    public Student getStudentById(Integer studentId);
}
