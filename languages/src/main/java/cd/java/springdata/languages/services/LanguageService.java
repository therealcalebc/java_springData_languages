/**
 * 
 */
package cd.java.springdata.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.languages.models.Language;
import cd.java.springdata.languages.repositories.LanguageRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository langRepo) {
		languageRepository = langRepo;
	}
	
	/**
	 * @return list of all the Languages in the db
	 */
	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}
	
	/**
	 * @param id the id of the Language to retrieve from the db
	 * @return the Language that was retrieved
	 */
	public Language getOneLanguage(Long id) {
		Optional<Language> optLang = languageRepository.findById(id);
		if(optLang.isPresent())
			return optLang.get();
		else
			return null;
	}
	
	/**
	 * @param l the new Language to create in the db
	 * @return the newly created language
	 */
	public Language addNewLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	/**
	 * @param l the Language to update in the db
	 * @return the updated language
	 */
	public Language updateLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	/**
	 * @param id the id of the Language to delete from the db
	 */
	public void removeLanguage(Long id) {
		if(languageRepository.existsById(id)) {
			languageRepository.deleteById(id);
		}
	}
	
}
