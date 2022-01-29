package in.myproject.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.myproject.anand.service.ForgotPassService;

@RestController
public class ForgotRestController {
	
	@Autowired
	private ForgotPassService service;
	
	@GetMapping("/forgot/{email}")
	public String forgotpassApi(@PathVariable String email)
	{
		String forgotpass = service.forgotpass(email);
		return forgotpass;
	}
	

}
