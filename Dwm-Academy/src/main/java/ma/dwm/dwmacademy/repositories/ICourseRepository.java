package ma.dwm.dwmacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.dwm.dwmacademy.entities.Course;

@RepositoryRestResource
public interface ICourseRepository extends JpaRepository<Course, Long> {

}
