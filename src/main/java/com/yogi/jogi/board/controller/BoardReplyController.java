
package com.yogi.jogi.board.controller;
 
import java.util.List;
 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yogi.jogi.board.model.ReplyModel;
import com.yogi.jogi.board.service.ReplyService;
import com.yogi.jogi.member.model.MemberModel;
 

@Controller

@RequestMapping("/reply")
public class BoardReplyController {
 
    @Autowired
    ReplyService replyService;
    
    
    @RequestMapping("/list") //댓글 리스트
    @ResponseBody
    private List<ReplyModel> replyList(ReplyModel replyModel) throws Exception{
        
    	
        return replyService.replyList();
    }
    
    @RequestMapping("/insert") //댓글 작성 
    @ResponseBody
    private int replyInsert(@RequestParam int boardNum, @RequestParam String content,@RequestParam int memNum,HttpSession session) throws Exception{
        
    	ReplyModel replyModel = new ReplyModel();
        replyModel.setBoardNum(boardNum);
        replyModel.setContent(content);
        replyModel.setMemNum(memNum);
        //로그인 기능을 구현했거나 따로 댓글 작성자를 입력받는 폼이 있다면 입력 받아온 값으로 사용하면 됩니다. 
        
        return replyService.replyInsert(replyModel);
    }
    
    @RequestMapping("/update") //댓글 수정  
    @ResponseBody
    private int replyUpdate(@RequestParam int replyNum, @RequestParam String content) throws Exception{
        
    	ReplyModel replyModel = new ReplyModel();
        replyModel.setBoardNum(replyNum);
        replyModel.setContent(content);
        
        return replyService.replyUpdate(replyModel);
    }
    
    @RequestMapping("/delete/{boardNum}") //댓글 삭제  
    @ResponseBody
    private int replyDelete(@PathVariable int replyNum) throws Exception{
        
        return replyService.replyDelete(replyNum);
    }
    
}

