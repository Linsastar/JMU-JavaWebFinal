package jmu.gcy.service;

import jmu.gcy.bean.MessageBoard;

import java.util.List;

public interface MessageBoardService {
    List<MessageBoard> getMessagesByEmployerId(int employerId);
}
