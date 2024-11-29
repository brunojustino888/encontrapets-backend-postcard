package br.com.encontrapets.dto;

import java.util.List;

import lombok.Data;

/**
 * Dto contendo as informacoes do post.
 * 
 * @author Bruno Justino.
 */
@Data
public class PostRequestDto {

	/**
	 * Representa o nome do animal ou titulo.
	 */
	private String nomeAnimal;
	
	/**
	 * Representa o tipo de animal.
	 */
	private String tipoAnimal; 
	
	/**
	 * Representa a descricao do post.
	 */
	private String descricaoPost;
	
	/**
	 * Representa o telefone do post.
	 */
	private String telefonePost; 
	
	/**
	 * Representa se o telefone do post se trata do mesmo do cadastro.
	 */
	private String flagMesmoTelefone; 
	
	/**
	 * Representa as imagens em base64 carregadas em tela.
	 */
	private List<String> imagensBase64;
	
}
