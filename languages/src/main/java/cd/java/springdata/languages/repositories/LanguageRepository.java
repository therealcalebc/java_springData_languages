/**
 * 
 */
package cd.java.springdata.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cd.java.springdata.languages.models.Language;

/**
 * @author ccomstock
 *
 */
@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {
	
	/**
	 *@return list of all Languages in db
	 */
	List<Language> findAll();
	
	/**
	 * @param search the substring to search by
	 * @return list of all Languages with matching name
	 */
	List<Language> findByNameContaining(String search);
	
	/**
	 * @param search the substring to search by
	 * @return list of all Languages with matching creator
	 */
	List<Language> findByCreatorContaining(String search);
	
	/**
	 * @param search the substring to search by
	 * @return the id of the Language that was found and deleted
	 */
	Long deleteByNameStartingWith(String search);
	
}
