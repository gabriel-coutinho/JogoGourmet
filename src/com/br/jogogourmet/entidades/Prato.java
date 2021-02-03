package com.br.jogogourmet.entidades;

/**
 * Classe Prato que contem informações como nome do prato e alguma caracteristica que o descreva. 
 * @author gabriel-coutinho
 *
 */
public class Prato {
	String nome;
	String descricao;
	
	public Prato() {
	}
	
	public Prato(String nome) {
		this.nome = nome;
	}

	public Prato(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	/**
	 * Retorna o nome do prato.
	 */
	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Baseado na comparação dos nomes dos pratos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
