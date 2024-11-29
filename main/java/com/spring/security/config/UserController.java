package com.spring.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("MyRoles")
public class UserController {

	@GetMapping("/")
	public String showIndexPage(Model model) {
		System.out.println("** showIndexPage **");
		List<String> myroles = getUserRoles();
		System.out.println(myroles);
		model.addAttribute("MyRoles", myroles);
		return "index";
	}

	@GetMapping("/viewBooks")
	public String showViewBooksPage(Model model) {
		System.out.println("** showViewBooksPage **");

		List<String> myroles = getUserRoles();
		System.out.println(myroles);
		model.addAttribute("MyRoles", myroles);

		return "viewBooks";
	}

	@GetMapping("/addBook")
	public String showAddBookPage(Model model) {
		System.out.println("** showAddBookPage **");

		List<String> myroles = getUserRoles();
		System.out.println(myroles);
		model.addAttribute("MyRoles", myroles);

		return "addBook";
	}

	@GetMapping("/editBook")
	public String showEditBookPage(Model model) {
		System.out.println("** showEditBookPage **");

		List<String> myroles = getUserRoles();
		System.out.println(myroles);
		model.addAttribute("MyRoles", myroles);
		return "editBook";
	}

	@GetMapping("/deleteBook")
	public String showDeleteBookPage(Model model) {
		System.out.println("** showDeleteBookPage **");

		List<String> myroles = getUserRoles();
		System.out.println(myroles);
		model.addAttribute("MyRoles", myroles);

		return "deleteBook";
	}

	@GetMapping("/placeOrder")
	public String showPlaceOrderPage(Model model) {
		System.out.println("** showPlaceOrderPage **");

		List<String> myroles = getUserRoles();
		System.out.println(myroles);
		model.addAttribute("MyRoles", myroles);

		return "placeOrder";
	}

	/*
	 * @GetMapping("/showRegister") public String showRegisterPage(Model model) {
	 * System.out.println("** showRegisterPage **"); User myuser=new User();
	 * model.addAttribute("myuser",myuser); return "register"; }
	 * 
	 * @PostMapping("/registerUser") public String
	 * registerUser(@ModelAttribute("myuser") User user, BindingResult
	 * bindingResult, Model model) { System.out.println("** registerUser **");
	 * 
	 * userService.registerUser(user); return "index"; }
	 */
	// Spring Security see this :
	
	@GetMapping("/login")
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		System.out.println("** loginPage **");
		List<String> myroles = getUserRoles();
		System.out.println(myroles);
		model.addAttribute("MyRoles", myroles);

		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		getUserRoles();
		return "login";
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("** logoutPage **");

		List<String> myroles = getUserRoles();
		System.out.println(myroles);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private List<String> getUserRoles() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<String> myroles = new ArrayList<>();
		if (auth != null) {
			Collection<GrantedAuthority> col = (Collection<GrantedAuthority>) auth.getAuthorities();
			for (GrantedAuthority gauth : col)
				myroles.add(gauth.getAuthority());
		}
		return myroles;
	}
}
