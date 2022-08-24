package com.ssafy.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public String home(Locale locale, Model model, UserDto dto) {
		logger.info("Welcome home! The client locale is Get {}.", locale);
		logger.warn("warn");
		logger.debug("debug");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
        model.addAttribute("message", dto.getName() );

		
		return "home";
	}
	
//    @RequestMapping(value = "/hello", method = RequestMethod.POST)
	@PostMapping("/hello")
    public String home2(Locale locale, Model model, UserDto dto) {
        logger.info("Welcome home! The client locale is Post {}.", locale);
        logger.info("dto: {}", dto.toString());
        logger.warn("warn");
        logger.debug("debug");
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        
        String formattedDate = dateFormat.format(date);
        
        model.addAttribute("serverTime", formattedDate );
        model.addAttribute("message", dto.getName() );        
        
        return "home";
    }
	
	@GetMapping("/hello3/{no}")
	public ModelAndView home3(@PathVariable int no) {
	    logger.info("{}", no);
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("message", "hello");
	    mav.setViewName("home3");
	    
	    return mav;
	}
	
}
