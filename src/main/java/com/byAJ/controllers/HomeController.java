package com.byAJ.controllers;

import com.byAJ.persistence.validators.UserValidator;
import com.byAJ.persistence.models.Education;
import com.byAJ.persistence.models.Job;
import com.byAJ.persistence.models.Person;
import com.byAJ.persistence.models.Skills;
import com.byAJ.persistence.models.User;
import com.byAJ.persistence.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

import javax.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserService userService;



	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}




	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showRegistrationPage(Model model){
		model.addAttribute("user", new User());
		return "registration";
	}



	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

		model.addAttribute("user", user);
		userValidator.validate(user, result);



		if (result.hasErrors()) {
			return "registration";
		} else {
			userService.saveUser(user);
			model.addAttribute("message", "User Account Successfully Created");
		}

		return "index";
	}


	//Person Controller
	@RequestMapping(value="/person", method = RequestMethod.GET)
	public String personForm(Model model)
	{
		//model.addAttribute("name",user.getFirstName()+ " "+user.getLastName());


		model.addAttribute("person", new Person());


		return "personForm";
	}

	@RequestMapping(value="/person", method = RequestMethod.POST)
	public String processPerson(@Valid @ModelAttribute("person") Person person, BindingResult result,@ModelAttribute("user") User user
			,Model model){

		System.out.println(result.toString());

		if (result.hasErrors()) {
			return "personForm";
		} 

		else {

			person.setUsername(userService.getUserDetails().getUsername());
			userService.savePerson(person);

		}




		model.addAttribute("personHas",person);
		return "redirect:/addresume";
	}



	//----End Person Controller

	@RequestMapping(value="/addresume", method = RequestMethod.GET)
	public String resumeForm(Model model,@ModelAttribute("user") User user)
	{
		//model.addAttribute("name",user.getFirstName()+ " "+user.getLastName());

		User u= userService.getUserDetails();

		String name= u.getFirstName()+" "+ u.getLastName();


		model.addAttribute("name",name);
		model.addAttribute("edu", new Education());


		return "eduForm";
	}

	@RequestMapping(value="/education", method = RequestMethod.POST)
	public String processEducation(@Valid @ModelAttribute("edu") Education edu, BindingResult result,@ModelAttribute("user") User user
			,Model model, @RequestParam("yesOrNo") String yesNo){

		System.out.println(result.toString());

		if (result.hasErrors()) {
			return "eduForm";
		} else {
			System.out.println(userService.getUserDetails().getUsername());
			edu.setUsername(userService.getUserDetails().getUsername());
			userService.saveEducation(edu);
			model.addAttribute("message", "User Account Successfully Created");
		}



		if( yesNo.equals("no")){

			return "redirect:/job";
		}


		//save education 
		return "redirect:/addresume";
	}


	//job
	@RequestMapping(value="/job", method = RequestMethod.GET)
	public String getJob(Model model,@ModelAttribute("user") User user)
	{


		User u= userService.getUserDetails();

		String name= u.getFirstName()+" "+ u.getLastName();


		model.addAttribute("name",name);
		model.addAttribute("job", new Job());
		//remove the line under this
		model.addAttribute("edu",new Education());


		return "jobForm";
	}

	@RequestMapping(value="/job", method = RequestMethod.POST)
	public String processJob( @Valid @ModelAttribute("job") Job job, BindingResult result,Model model, @RequestParam("yesOrNo") String yesNo){



		if (result.hasErrors()) {
			return "jobForm";
		} else {


			job.setUsername(userService.getUserDetails().getUsername());
			userService.saveJob(job);

		}


		
		if( yesNo.equals("yes")){

			return "redirect:/job";
		}

		//save 
		return "redirect:/skill";
	}

	//skill

	@RequestMapping(value="/skill", method = RequestMethod.GET)
	public String getSkill(Model model)
	{

		model.addAttribute("skill", new Skills());

		return "skillForm";
	}

	@RequestMapping(value="/skill", method = RequestMethod.POST)
	public String processSkil(@Valid @ModelAttribute("skill") Skills skill, BindingResult result, Model model, @RequestParam("yesOrNo") String yesNo){

       System.out.println("helo");
		System.out.println(result.toString());
		if (result.hasErrors()) {
			return "skillForm";
		} else {




			skill.setUsername(userService.getUserDetails().getUsername());
			userService.saveSkill(skill);



		}



		if( yesNo.equals("yes")){

			return "redirect:/skill";
		}







		return "myResume";
	}

	//Print Resume
	@RequestMapping(value="/myresume", method = RequestMethod.GET)
	public String getResume(Model model,@ModelAttribute("user") User user)
	{

		User u= userService.getUserDetails();

		String name= u.getFirstName()+" "+ u.getLastName();

		model.addAttribute("name",name);
		return "myResume";
	}



	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String SearchForm(Model model){

		return "searchForm";
	}


	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String processSearch( Model model,
			@RequestParam("institution") String school,
			@RequestParam("skills") String skill,@RequestParam("lastName") String lastName
			){

		return "searchResult";
	}


	public UserValidator getUserValidator() {
		return userValidator;
	}

	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}


}
