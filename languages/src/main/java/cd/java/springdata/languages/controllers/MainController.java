/**
 * 
 */
package cd.java.springdata.languages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ccomstock
 *
 */
@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
}
