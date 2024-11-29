package br.com.encontrapets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.encontrapets.dto.PostRequestDto;
import br.com.encontrapets.service.PostagemAdocaoService;

/**
 * Controller responsavel pelos endpoints da area restrita do user logado.
 * 
 * @author Bruno Justino.
 */
@RestController
@RequestMapping("/api/protected")
public class ProtectedController {
	
	/**
	 * Service de postagens de adocao.
	 */
	@Autowired
	private PostagemAdocaoService postagemAdocaoService;

	/**
	 * Endpoind da criacao de postagem de adocao.
	 * 
	 * @return ResponseEntity - 201 CREATED em caso de sucesso.
	 */
	@PostMapping("/createPostAdocao")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> postAdocao(@RequestBody PostRequestDto pPostRequestDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return this.postagemAdocaoService.createPostAdocao(pPostRequestDto, userDetails.getUsername());
	}

}
