package br.com.encontrapets.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidade post.
 * 
 * @author Bruno Justino.
 */
@Data
@Entity
@Table(name = "T_POST", schema = "encontrapetsdb")
public class Post {

	/**
	 * Representa a pk do post.
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPost;
	
	/**
	 * Representa o identificador pessoa.
	 */
	@Column 
	private Long idPessoa;
	
	/**
	 * Representa o tipo do post.
	 */
	@Column
	private Long idTipoPost;
	
	/**
	 * Representa o nome do animal ou titulo.
	 */
	@Column
	private String nomeAnimal;
	
	/**
	 * Representa o tipo de animal.
	 */
	@Column
	private Integer tipoAnimal;
	
	/**
	 * Representa o genero do animal.
	 */
	@Column
	private String generoAnimal;
	
	/**
	 * Representa a descricao do post.
	 */
	@Column
	private String descricaoPost;
	
	/**
	 * Representa o telefonedo post.
	 */
	@Column
	private String telefonePost;
	
	/**
	 * Representa a visibilidade do post.
	 */
	@Column
	private String flagPostVisivel;
	
	/**
	 * Representa a data de cadastro do usuario.
	 */
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    /**
	 * Representa o usuario de cadastro.
	 */
    @Column(name = "USER_CADASTRO")
    private String userCadastro;

    /**
	 * Representa a data de atualizacao do registro.
	 */
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private Date dataAtualizacao;

    /**
	 * Representa o usuario de atualizacao.
	 */
    @Column(name = "USER_ATUALIZACAO", nullable = false)
    private String userAtualizacao;
	
}
