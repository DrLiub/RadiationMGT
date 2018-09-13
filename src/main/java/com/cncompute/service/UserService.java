package com.cncompute.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cncompute.dao.UserDao;
import com.cncompute.pojo.User;

/**
 * 用户的service层
 * @author 劉 
 * 2018年7月24日10:40:54
 */
@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userdao;
	/**
	 * 查询用户是否存在，通过id和密码确认登录
	 * @param userid
	 * @param password
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void getUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");

		User user=userdao.getUserAll(userid);
		PrintWriter pw= response.getWriter();
		if(user==null) {
			String json= "{\"index\":2}";//用户不存在
			pw.print(json);
		}else if(user!=null&&user.getPassword().equals(password)) {
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			String json="{\"index\":0}";//登录成功
			pw.print(json);
		}else {
			String json="{\"index\":1}";//账号或者密码错误
			pw.print(json);
		}
	}
	/**
	 * 注册新用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void regUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String userid=request.getParameter("userid");//用户登录ID
		String password=request.getParameter("password");//密码
		String password2=request.getParameter("password2");//密码
		String username=request.getParameter("username");//姓名 
		String question=request.getParameter("question");//找回密码问题
		String answer=request.getParameter("answer");//找回密码答案
//		Integer permissions;//权限
//		String usertime;//当前时间
//		String updatetime="";//最后一次更新时间
//		Integer userstate;//表状态0表示删除1表示存在
		List<User> userall= userdao.AllUser();
		PrintWriter pw=response.getWriter();
		int num=0;
		//判断用户是否存在
        for (User user : userall) {
	         if(user.getUserid().equals(userid)) {
	 			String json="{\"index\":1}";
				pw.print(json);
	        	 num=1;
	        	 return;
	         }
         }
        //判断用户ID不能为空
        if("".equals(userid)||userid==null) {
        	String json="{\"index\":2}";//id不能为空
        	pw.print(json);
        	num=1;
        	return;
        }
        //判断密码不能小于6位数
        if(password.length()<6) {
        	String json="{\"index\":3}";
        	pw.print(json);
        	num=1;
        	return;
        }else if(!password.equals(password2)) {
        	String json="{\"index\":4}";//两次密码不一致
        	pw.print(json);
        	num=1;
        	return;
        }else if("".equals(question)||question==null||"".equals(answer)||answer==null) {
        	String json="{\"index\":5}";//找回密码问题和答案不能为空
        	pw.print(json);
        	num=1;
        	return;
        }
        if(num==0) {
		String json="{\"index\":0}";
		pw.print(json);
        User user=new User();
        user.setUserid(userid);
        user.setPassword(password);
        user.setUsername(username);
        user.setQuestion(question);
        user.setAnswer(answer);
        user.setPermissions(2);//2为普通用户1为超级用户
        user.setUsertime(getTime());
        user.setUpdatetime(getTime());
        user.setUserstate(1);
        userdao.addUser(user);
        }
	}
	/**
	 * 修改密码，判断用户是否存在，查找修改密码问题
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void modifyPassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String userid =request.getParameter("userid");//用户输入ID
		List<User> userall= userdao.AllUser();
		PrintWriter pw=response.getWriter();
		String question;
		int num=0;
		//判断用户是否存在
        for (User user : userall) {
	         if(user.getUserid().equals(userid)) {
	        	 question=user.getQuestion();
	 			String json="{\"index\":"+question+"}";//用户存在
				pw.print(json);
	        	 num=1;
	        	 return;
	         }
         }
        if(num==0) {
 			String json="{\"index\":0}";
			pw.print(json);//用户不存在
        }
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void modify(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String userid=request.getParameter("userid");//用户登录ID
		String password=request.getParameter("password");//密码
		String password2=request.getParameter("password2");//密码
		String answer=request.getParameter("answer");//找回密码答案
		List<User> userall= userdao.AllUser();
		PrintWriter pw=response.getWriter();
		int num=0;
		for (User user : userall) {
	         if(user.getUserid().equals(userid)) {
	        	 if(user.getAnswer().equals(answer)) {
	      			String json="{\"index\":1}";
	    			pw.print(json);//找回密码答案正确
	    			user.setPassword(password2);
	    			userdao.modify(user);
	        		num=1;
	        		return;
	        	 }
	         }
		}
        //判断用户ID不能为空
        if("".equals(userid)||userid==null) {
        	String json="{\"index\":2}";//id不能为空
        	pw.print(json);
        	num=1;
        	return;
        }
        //判断密码不能小于6位数
        if(password.length()<6) {
        	String json="{\"index\":3}";
        	pw.print(json);
        	num=1;
        	return;
        }else if(!password.equals(password2)) {
        	String json="{\"index\":4}";//两次密码不一致
        	pw.print(json);
        	num=1;
        	return;
        }else if("".equals(answer)||answer==null) {
        	String json="{\"index\":5}";//找回密码问题和答案不能为空
        	pw.print(json);
        	num=1;
        	return;
        }
		if(num==0) {
  			String json="{\"index\":0}";//找回密码答案错误
			pw.print(json);
		}
	}
	/**
	 * 获取当前时间
	 * @return
	 */
	public Date getTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String colclosed = sdf.format(d);
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(colclosed);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
