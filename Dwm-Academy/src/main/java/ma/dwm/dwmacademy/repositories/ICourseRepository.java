package ma.dwm.dwmacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.dwmacademy.entities.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

}
