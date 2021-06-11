package ma.dwm.dwmacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.dwm.dwmacademy.entities.Category;

@RepositoryRestResource
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
