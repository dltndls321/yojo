package com.yogi.jogi.board.service;
 
import java.util.List;
  

import com.yogi.jogi.board.model.ReplyModel;
 
public interface ReplyService {
    // 댓글 개수
    public int replyCount() throws Exception;
 
    // 댓글 목록
    public List<ReplyModel> replyList(int boardNum) throws Exception;
 
    // 댓글 작성
    public int replyInsert(ReplyModel replyModel) throws Exception;
    
    // 댓글 수정
    public int replyUpdate(ReplyModel replyModel) throws Exception;
 
    // 댓글 삭제
    public int replyDelete(int replynum) throws Exception;
 
}
