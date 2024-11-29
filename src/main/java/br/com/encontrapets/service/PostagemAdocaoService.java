package br.com.encontrapets.service;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.encontrapets.dto.PostRequestDto;
import br.com.encontrapets.model.Photo;
import br.com.encontrapets.model.Post;
import br.com.encontrapets.repository.PessoaRepository;
import br.com.encontrapets.repository.PhotoRepository;
import br.com.encontrapets.repository.PostRepository;

/**
 * Service responsavel pela criacao de postagem de adocao.
 * 
 * @author Bruno Justino.
 */
@Service
public class PostagemAdocaoService {
	
	/**
	 * Repository de pessoa.
	 */
	@Autowired
	private PessoaRepository pPessoaRepository;
	
	/**
	 * Repository de imagens.
	 */
	@Autowired
	private PhotoRepository pPhotoRepository;
	
	/**
	 * Repository de postagens.
	 */
	@Autowired
	private PostRepository pPostRepository;

	/**
	 * Responsavel pela criacao de postagem de adocao.
	 * @param username - String - usuario logado.
	 * 
	 * @return ResponseEntity - 201 CREATED em caso de sucesso.
	 */
	@Transactional
    public ResponseEntity<?> createPostAdocao(PostRequestDto dtoPostRequestDto, String username) {

    	boolean naoFezAnexo = dtoPostRequestDto.getImagensBase64()==null||dtoPostRequestDto.getImagensBase64().isEmpty();
    	
    	Post postagemAdocao = new Post();
    	BeanUtils.copyProperties(dtoPostRequestDto, postagemAdocao);
    	postagemAdocao.setFlagPostVisivel("P");
    	postagemAdocao.setIdTipoPost(1L);
    	postagemAdocao.setIdPessoa(this.pPessoaRepository.findByEmail(username).get().getIdUsuario());
    	postagemAdocao.setUserAtualizacao(username);
    	postagemAdocao.setUserCadastro(username);
    	postagemAdocao.setDataAtualizacao(new Date());
    	postagemAdocao.setTipoAnimal(0);
    	postagemAdocao = this.pPostRepository.save(postagemAdocao);
    	
    	if(!naoFezAnexo) {
    		 // Converter imagens Base64 para byte[]
            List<byte[]> imagens = dtoPostRequestDto.getImagensBase64().stream()
	            .map(base64 -> {
	                String base64Data = base64.split(",")[1];
	                return Base64.getDecoder().decode(base64Data);
	            }).toList();
            for(int i=0; i<imagens.size(); i++) {
            	Photo photo = new Photo();
                photo.setIdPost(postagemAdocao.getIdPost());
                photo.setImagem(imagens.get(i));
                photo.setOrdem(i);
                photo.setUserAtualizacao(username);
                photo.setUserCadastro(username);
                photo.setDataAtualizacao(new Date());
                this.pPhotoRepository.save(photo);
            }
    	}
		return ResponseEntity.status(HttpStatus.CREATED).build();
         
    }
}
