package br.com.encontrapets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.encontrapets.model.Photo;

/**
 * Repository de imagens.
 * 
 * @author Bruno Justino.
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {
	
	/**
	 * Encontra as imagens de um determinado post.
	 * 
	 * @param idPost - Long - identificador do post.
	 * @return List - lista de imagens da postagem.
	 */
	@Query("SELECT p FROM Photo p WHERE p.idPost = :idPost ORDER BY p.ordem")
	List<Photo> findPhotosByPostId(@Param("idPost") Long idPost);
	
}
