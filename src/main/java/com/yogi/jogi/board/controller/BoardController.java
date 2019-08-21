package com.yogi.jogi.board.controller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import model.BoardDataBean;
import service.BoardDBBeanMybatis;
import service.BoardDao;



@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	 ModelAndView mv = new ModelAndView(); // ModelAndView 공용으로 쓸라고 선언
	   private String boardid;
	   private int pageNum;   
	   private String ip;
	   
	   @Autowired
	   public BoardDao boardDBBeanMyBatis;
	   
	   @RequestMapping("test") //2. url에 board/test를 치면
	   public ModelAndView test() {
	      
	      mv.setViewName("board/test"); //3. board폴더아래의 test.jsp를 찾음
	      
	      return mv;
	   }
	   
	   @ModelAttribute //이 어노테이션을 사용하면 메소드에서 선언한 객체가 뷰로 넘어감 글구 가장먼저 실행됨
	   public void setAttr(HttpServletRequest request) {
	      
	      //boardid와 pageNum, ip를 세팅하는 메소드
	      System.out.println("ModelAttribute야");
	      HttpSession session = request.getSession();
	      String reqboardid = request.getParameter("boardid"); // boardid가 넘어오는지
	      
	      if(reqboardid != null) session.setAttribute("boardid", reqboardid); // boardid가 있으면 session에 boardid 체크
	      if(session.getAttribute("boardid")==null) boardid = "1"; // null 이면 boardid = 1
	      else boardid = (String)session.getAttribute("boardid"); // 오브젝트로 받아오기떄문에 String으로 형변환
	      
	      try {
	      pageNum = Integer.parseInt(request.getParameter("pageNum")); // pageNum을 세팅하는데 넘어오지않으면 1을 집어넣음
	      }catch (Exception e) {
	         // TODO: handle exception
	         pageNum = 1;
	      }
	      
	      ip = request.getRemoteAddr();
	      
	      
	   }
	   
	   @RequestMapping("list") // board/list가 들어오면
	   public ModelAndView list() throws Exception{
	      
	      // 
	      
	      int pageSize = 6;
	      int currentPage = pageNum; //setAttr에 pageNum을 설정해놓았음
	      
	      int count = boardDBBeanMyBatis.getArticleCount(boardid); //BoardDBBeanMyBatis에 설정해놓은 boardid
	      int startRow = (currentPage - 1) * pageSize;
	      int endRow = currentPage * pageSize;
	      if (count < endRow)
	         endRow = count;
	      
	      List articleList = boardDBBeanMyBatis.getArticles(startRow, pageSize, boardid);
	      
	      if (boardDBBeanMyBatis.mybatisConnector.getDbname().equals("Oracle")) {
	    	  articleList = boardDBBeanMyBatis.getArticles(startRow+1, endRow, boardid);
	      }
	      else{
	    	  articleList = boardDBBeanMyBatis.getArticles(startRow, pageSize, boardid);
	   }
	      int number = count - ((currentPage - 1) * pageSize);

	      int bottomLine = 3;
	      // 5 page
	      int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
	      int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
	      int endPage = startPage + bottomLine - 1;
	      if (endPage > pageCount)
	         endPage = pageCount;
	      mv.addObject("pageCount",pageCount);
	      mv.addObject("count", count);
	      mv.addObject("boardid", boardid);
	      mv.addObject("pageNum", pageNum);
	      mv.addObject("articleList", articleList);
	      mv.addObject("number", number);
	      mv.addObject("startPage", startPage);
	      mv.addObject("bottomLine", bottomLine);
	      mv.addObject("endPage", endPage);
	      mv.setViewName("board/list");
	      
	      
	      return mv;
	      
	      
	   }
	   
	   
	   @RequestMapping("writeForm") //writeUploadForm url이 들어오면
	   public ModelAndView writeForm(BoardDataBean article) throws Exception{
	      
	      mv.clear();  // ModelAndView 초기화
	      
	      mv.addObject("num", article.getNum()); 
	      mv.addObject("pageNum", pageNum);
	      mv.addObject("ref", article.getRef());
	      mv.addObject("re_step", article.getRe_step());
	      mv.addObject("re_level", article.getRe_level());
	      mv.setViewName("board/writeUploadForm"); //가야할 페이지
	      
	      return mv;
	   }
	   
	   @RequestMapping("writePro") //writePro url이 들어오면
	   public String writePro(BoardDataBean article) throws Exception{
	      
	      article.setIp(ip); //setAttr에서 세팅해놓은 ip값 집어넣기
	      boardDBBeanMyBatis.insertArticle(article, boardid); //mybatis에 설정해놓은 sql쿼리 실행
	      return "redirect:list?pageNum=" + pageNum; //list페이지로 반환
	   }
	   @RequestMapping("writeUploadPro") 
	   public String writeUploadPro(MultipartHttpServletRequest multipart,BoardDataBean article) throws Exception{
	      MultipartFile multi = multipart.getFile("uploadfile");
	      String filename = multi.getOriginalFilename();
	      if(filename != null && !filename.equals("")) {
	    	  
	    	  String uploadPath = multipart.getServletContext().getRealPath("/") + "/fileSave";
	    	  System.out.println(uploadPath);
	    	  FileCopyUtils.copy(multi.getInputStream(), new FileOutputStream(uploadPath + "/" + multi.getOriginalFilename()));
	    	  article.setFilename(filename);
	    	  article.setFilesize((int)multi.getSize());
	      }else {
	    	  article.setFilename("");
	    	  article.setFilesize(0);
	      }
	      System.out.println(article);
	      article.setIp(ip); //setAttr에서 세팅해놓은 ip값 집어넣기
	      boardDBBeanMyBatis.insertArticle(article, boardid); 
	      return "redirect:list?pageNum=" + pageNum; 
	   }
	   @RequestMapping("content") //content url이 들어오면 내가 쓴 게시글 내용 확인하는 페이지로
	   public ModelAndView content(int num) throws Exception{
	      mv.clear(); // ModelAndView 초기화
	      BoardDataBean article = boardDBBeanMyBatis.getArticle(num, boardid); // num, boardid과 일치하는 게시글 가져오기
	      mv.addObject("article", article);
	      mv.addObject("pageNum", pageNum);
	      mv.setViewName("board/content"); //가야할 페이지
	      return mv;
	      
	   }
	   
	   @RequestMapping("update")
	   public ModelAndView update(int num) throws Exception{
	      mv.clear();
	      BoardDataBean article = boardDBBeanMyBatis.getUpdate(num, boardid);
	      mv.addObject("article", article);
	      mv.addObject("pageNum", pageNum);
	      mv.setViewName("board/updateForm");
	      return mv;
	   }
	   
	   @RequestMapping("updatePro")
	   public ModelAndView updatePro(BoardDataBean article) throws Exception{
	      mv.clear();
	      
	      int check = boardDBBeanMyBatis.updateArticle(article, boardid);
	      mv.addObject("check", check);
	      mv.addObject("pageNum", pageNum);
	      
	      mv.setViewName("board/updatePro");
	      return mv;
	   }
	   
	   @RequestMapping("delete")
	   public ModelAndView delete(int num)throws Exception{
	      mv.clear();
	      
	      mv.addObject("num", num);
	      mv.addObject("pageNum", pageNum);
	      
	      mv.setViewName("board/deleteForm");
	      return mv;
	   }
	 
	   @RequestMapping("deletePro")
	   public ModelAndView deletePro(int num,String passwd)throws Exception{
		   //private passwd 선언하면 안됨
	   	int check = boardDBBeanMyBatis.deleteArticle(num, passwd);  
	   	mv.clear();
	   	mv.addObject("check", check);
	   	mv.addObject("pageNum", pageNum);
	    mv.setViewName("board/deletePro");
			return mv;
			 
	   }
	}
}
