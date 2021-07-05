package ma.dwm.dwmacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.dwmacademy.entities.Content;

@Repository
public interface IContentRepository extends JpaRepository<Content, Long> {

}
