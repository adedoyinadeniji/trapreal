package com.example.App;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

 
@Controller
public class AppController {
	
    @Autowired
    private TrapDAOInterface dao;
    	
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
     public String viewHomePage(Model model) {
        List<TrapDTO> listTrap = dao.readTraps();
        model.addAttribute("listTrap", listTrap);
        return "index";
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showForm(Model model) {
   	   model.addAttribute("trap", new TrapDTO()); 
       return "new_form";
   }
    @RequestMapping(value="/",method= RequestMethod.GET)
	  public String greetingForm(Model model) {
	    return "main";
	  }
    @RequestMapping(value="/", method=RequestMethod.POST)
	 public String showresultpage(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sha = "admin";
		String pas = "admin";
		String url = "";
		
		model.addAttribute("username",username);
		model.addAttribute("password",password);
	    if(username.equals(sha) && password.equals(pas)) {
	    	url = "new_form"; 
	    }
	    else {
	    	url = "main";
	    }
	    return url;
	    }
    @RequestMapping(value = "/new/{ipaddress}", method = RequestMethod.GET)
    public String viewHomePages(Model model, @RequestParam("ipaddress") String ipaddress){
    	List<TrapDTO> listTrap = dao.searchbyIp(ipaddress);
    	System.out.println(listTrap);
        model.addAttribute("listTrap", listTrap);
        return "index";
    }
 }
