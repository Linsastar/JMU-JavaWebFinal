package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.Employer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployerMapper extends BaseMapper<Employer> {
    // 这里可以添加其他自定义的查询方法，根据实际需求进行扩展
}
