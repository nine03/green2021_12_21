package org.comstudy21.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletResponse;

import org.comstudy21.myapp.saram.SaramDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   private static final ArrayList<SaramDto> saramList = new ArrayList<SaramDto>();
   static {
      saramList.add(new SaramDto("KIM","김유신","kim@naver.com"));
      saramList.add(new SaramDto("LEE","이순신","lee@naver.com"));
      saramList.add(new SaramDto("PARK","박찬호","park@naver.com"));
      saramList.add(new SaramDto("AN","안창호","an@naver.com"));
   }
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      
      return "home";
   }
   
   @RequestMapping(value="/list.saram", method=RequestMethod.GET)
   public String saramList(Model model) {
      System.out.println(":::: saramList ::::");
      model.addAttribute("saramList", saramList);
      return "saram_list";
   }
   
   @RequestMapping(value="/input.saram", method=RequestMethod.GET)
   public String saramInput(Model model, SaramDto dto) {
      System.out.println(":::: saramInput ::::");
      return "saram_input";
   }
   
   @RequestMapping(value="/input.saram", method=RequestMethod.POST)
   public String saramInputProc(Model model, SaramDto dto) {
      System.out.println(":::: saramInput ::::");
      saramList.add(dto);
      
      return "redirect:list.saram"; // redirect는새로고침 
   }
   
   @RequestMapping(value="/search.saram", method=RequestMethod.GET)
   public String saramSearch(Model model) {
      System.out.println(":::: saramSearch ::::");
      
      return "saram_search";
   }
   
}