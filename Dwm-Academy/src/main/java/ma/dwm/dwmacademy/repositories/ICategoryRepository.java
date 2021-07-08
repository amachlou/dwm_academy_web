package ma.dwm.dwmacademy.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import ma.dwm.dwmacademy.entities.Category;

@RepositoryRestResource
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("FROM Category c ORDER BY c.id DESC") // Select popular categories
	public List<Category> getBestCategories();
	@Query("FROM Category c ORDER BY c.id DESC")
	public List<Category> getCategoriesPage(Pageable pageable);
//	public List<Category> getBestCategories(Pageable pageable);
//	public List<Category> findTop3ByName(String name);
//	public List<Category> findFirstByOrderById();

}
