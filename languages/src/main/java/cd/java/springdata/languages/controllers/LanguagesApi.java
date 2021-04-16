/**
 * 
 */
package cd.java.springdata.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.java.springdata.languages.models.Language;
import cd.java.springdata.languages.services.LanguageService;

/**
 * @author ccomstock
 *
 */
@RestController
public class LanguagesApi {
	
	private final LanguageService languageService;
	
	public LanguagesApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/api/languages")
	public List<Language> readAll() {
		return languageService.readAll();
	}
	
	@PostMapping("/api/languages")
	public Language create(@RequestParam String name, @RequestParam String creator, @RequestParam(value="currentVersion") String version) {
		Language language = new Language(name, creator, version);
		return languageService.createOne(language);
	}
	
	@GetMapping("/api/languages/{id}")
	public Language readOne(@PathVariable Long id) {
		Language language = languageService.readOne(id);
		return language;
	}
	
	@PutMapping("/api/languages/{id}")
	public Language update(@PathVariable Long id, @RequestParam String name, @RequestParam String creator, @RequestParam(value="currentVersion") String version) {
		Language language = languageService.readOne(id);
		if(language != null) {
			language.setName(name);
			language.setCreator(creator);
			language.setCurrentVersion(version);
		}
		return languageService.updateOne(language);
	}
	
	@DeleteMapping("/api/languages/{id}")
	public void destroy(@PathVariable Long id) {
		languageService.destroyOne(id);
	}
	
}

