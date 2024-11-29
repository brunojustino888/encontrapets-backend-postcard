package br.com.encontrapets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encontrapets.model.Post;

/**
 * Repository de imagens.
 * 
 * @author Bruno Justino.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
	
}
