package com.example.deliveryproviderservice.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.io.Serializable;

@Entity
@Table(name = "provider")
public class Provider {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message="Preencha o campo nome")
	private String nome;
	
	@NotEmpty(message = "Preencha o campo endereco")
	private String endereco;
	
	@NotEmpty(message = "Preencha o campo cidade")
	private String cidade;
	
	@NotEmpty(message = "Preencha o campo bairro")
	private String bairro;
	
	@NotEmpty(message = "Preencha o campo estado")
	private String estado;
	
	@NotNull(message = "Preencha o campo cep")
	private int cep;
	
	@NotEmpty(message = "Preencha o campo email")
	@Email(message = "Preencha o campo com um e-mail válido")
	private String email;
	
	@NotEmpty(message = "Preencha o campo contato")
	private String contato;
	
	@NotEmpty(message = "Preencha o campo cnpj")
	@CNPJ(message = "Preencha o campo com um cnpj válido")
	private String cnpj;
	
	@NotNull(message = "Preencha o campo numero")
	@Pattern(regexp="^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
	private int numero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
