package br.com.encontrapets.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidade photo.
 * 
 * @author Bruno Justino.
 */
@Data
@Entity
@Table(name = "T_PHOTO", schema = "encontrapetsdb")
public class Photo {

	/**
	 * Representa o identificador da imagem.
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPhoto;
	
	/**
	 * Representa o identificador do post.
	 */
	@Column
	private Long idPost;
	
	/**
	 * Representa a imagem.
	 */
	@Lob
    @Column(name = "imagem", nullable = false)
    private byte[] imagem; 
	
	/**
	 * Representa a ordem de anexo das imagens.
	 */
	@Column
	private Integer ordem;
	
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
