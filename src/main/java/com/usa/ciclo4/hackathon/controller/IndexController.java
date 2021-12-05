package com.usa.ciclo4.hackathon.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.usa.ciclo4.hackathon.model.User;
import com.usa.ciclo4.hackathon.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService service;

<<<<<<< HEAD
    @GetMapping("/")
    public String index() {
        return "vistas/index";
    }

    @GetMapping("/login")
    public String login() {
        return "vistas/login";
    }

    @GetMapping("/register")
    public String register() {
        return "vistas/register";
    }

    @GetMapping("/home")
    public String homePage() {
        return "vistas/home";
    }

    @GetMapping("/community")
    public String communityPage() {
        return "vistas/community";
    }
=======
	@GetMapping("/")
	public String index() {
		return "vistas/index";
	}

	@GetMapping("/login")
	public String login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "vistas/login";
		}
		return "redirect:/home";
	}

	@GetMapping("/register")
	public String register(Model model) {
		Map<String, String> genders = new LinkedHashMap<String, String>();
		genders.put("M", "Hombre");
		genders.put("F", "Mujer");
		model.addAttribute("genders", genders);
		model.addAttribute("user", new User());
		return "vistas/register";
	}

	@GetMapping("/home")
	public String homePage() {
		return "vistas/home";
	}

	@PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
	public String validaRegistro(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			Map<String, String> genders = new LinkedHashMap<String, String>();
			genders.put("M", "Hombre");
			genders.put("F", "Mujer");
			model.addAttribute("genders", genders);
			return "vistas/register";
		} else {
			try {
				service.createUser(user);
			} catch (Exception e) {
				Map<String, String> genders = new LinkedHashMap<String, String>();
				genders.put("M", "Hombre");
				genders.put("F", "Mujer");
				model.addAttribute("genders", genders);
				model.addAttribute("user", user);
				model.addAttribute("validationError", e.getMessage());
				return "vistas/register";
			}
		}
		model.addAttribute("registerSuccess", true);
		return "vistas/login";
	}
>>>>>>> 480bafd64ce5edebee2f8973e275a4a9bb2c00e5
}
