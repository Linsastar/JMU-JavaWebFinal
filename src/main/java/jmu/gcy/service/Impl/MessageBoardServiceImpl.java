package jmu.gcy.service.Impl;

import jmu.gcy.bean.MessageBoard;
import jmu.gcy.mapper.MessageBoardMapper;
import jmu.gcy.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public List<MessageBoard> getMessagesByEmployerId(int employerId) {
        return messageBoardMapper.getMessagesByEmployerId(employerId);
    }

    @Override
    public List<MessageBoard> getAllMessages() {
        return messageBoardMapper.getAllMessages();
    }

    @Override
    public void deleteMessage(int commentId) {
        messageBoardMapper.deleteMessage(commentId);
    }
}
