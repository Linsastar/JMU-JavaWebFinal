package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("SELECT * FROM student WHERE student_id = #{studentId}")
    public Student getStudentById(Integer studentId);

    @Select("SELECT * FROM student")
    List<Student> getAllStudents();

    @Update("UPDATE student SET name = #{name}, gender = #{gender}, ethnicity = #{ethnicity}, " +
            "native_place = #{nativePlace}, date_of_birth = #{dateOfBirth}, political_status = #{politicalStatus} " +
            "WHERE student_id = #{studentId}")
    int updateStudent(Student student);
}
