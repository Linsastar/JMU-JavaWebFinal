package jmu.gcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jmu.gcy.bean.MessageBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageBoardMapper extends BaseMapper<MessageBoard> {
    @Select("SELECT * FROM message_board WHERE employer_id = #{employerId}")
    List<MessageBoard> getMessagesByEmployerId(int employerId);

    @Select("SELECT * FROM message_board")
    List<MessageBoard> getAllMessages();

    @Select("SELECT * FROM message_board WHERE message_id = #{commentId}")
    void deleteMessage(int commentId);
}
