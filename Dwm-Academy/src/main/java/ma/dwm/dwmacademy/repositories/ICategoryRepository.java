package ma.dwm.dwmacademy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.dwm.dwmacademy.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("FROM Category c") // Select popular categories
	public List<Category> getBestCategories();

}
