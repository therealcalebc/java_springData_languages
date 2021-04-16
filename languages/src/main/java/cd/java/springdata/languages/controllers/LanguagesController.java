/**
 * 
 */
package cd.java.springdata.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import cd.java.springdata.languages.models.Language;
import cd.java.springdata.languages.services.LanguageService;

/**
 * @author ccomstock
 *
 */
@Controller
public class LanguagesController {
	
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService langServ) {
		languageService = langServ;
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute Language language, Model model) {
		List<Language> langList = languageService.readAll();
		model.addAttribute("languages", langList);
		return "languages/index.jsp";
	}
	
	@PostMapping("/languages")
	public String addNew(@Valid @ModelAttribute Language language, BindingResult result) {
		System.out.println("LanguagesController.addNew(): result.hasErrors() == " + result.hasErrors());
		if(result.hasErrors())return "languages/index.jsp";
		languageService.createOne(language);
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable Long id, Model model) {
		Language language = languageService.readOne(id);
		if(language == null) return "redirect:/languages";
		model.addAttribute("language", language);
		return "languages/show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Language language = languageService.readOne(id);
		if(language == null) return "redirect:/languages";
		model.addAttribute("language", language);
		return "languages/edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute Language language, BindingResult result) {
		if(result.hasErrors()) return "languages/edit.jsp";
		languageService.updateOne(language);
		return "redirect:/languages";
	}
	
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable Long id) {
		languageService.destroyOne(id);
		return "redirect:/languages";
	}
	
}
