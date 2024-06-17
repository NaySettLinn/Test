package spring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.dto.UserDTO;
import spring.model.UserBean;
import spring.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserRepository user_repo;
	
	@GetMapping(value ="/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register","user",new UserBean());
	}
	
	@PostMapping (value = "/doregister")
	public String insertUser(@ModelAttribute("user") UserBean user, Model m) {
		
		UserDTO dto = mapper.map(user, UserDTO.class);
		/*
		 * dto.setName(user.getName()); dto.setEmail(user.getEmail());
		 * dto.setPassword(user.getPassword());
		 */
		
		int i = user_repo.insertUser(dto);
		if(i>0) {
			return "redirect:showusers";
		}else {
			m.addAttribute("insert error","insert Fail");
			return "redirect:register";
		}
		
	}
	
	@GetMapping(value = "/showusers")
	public String showAllUsers(Model m) {
		List<UserDTO> userlist = user_repo.showAllUser();
		m.addAttribute("userlist", userlist);
		return "userlist";
	}
	

}
