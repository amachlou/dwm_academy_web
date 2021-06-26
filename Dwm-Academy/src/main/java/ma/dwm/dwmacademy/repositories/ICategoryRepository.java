package ma.dwm.dwmacademy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.dwm.dwmacademy.entities.Category;

@RepositoryRestResource
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("select c from Category c ")
	public List<Category> getBestCategories();

}
