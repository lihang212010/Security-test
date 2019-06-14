package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	SysUserRepository userRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		Msg msg=new Msg("测试标题","测试内容","只对管理员开放");
		model.addAttribute("msg",msg);
		return "home";
	}
	@RequestMapping("/ceshi")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SysUser user=userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("用户名不存在");
			
		}
		return user;
	}
}
