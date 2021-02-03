package com.br.jogogourmet.arvore;

/**
 * 
 * @author gabriel-coutinho
 * Essa classe é uma versão simplificada de um nó de uma Árvore Binária que guarda objetos da classe Prato.
 * @param <Prato>
 */
public class NoAB<Prato> {
		protected Prato prato;
		protected NoAB<Prato> noPai;
		protected NoAB<Prato> noEsquerda;
		protected NoAB<Prato> noDireita;

		public NoAB(Prato prato, NoAB<Prato> noEsquerda, NoAB<Prato> noDireita) {
			this.prato = prato;
			this.noEsquerda = noEsquerda;
			this.noDireita = noDireita;
		}

		public NoAB() {
			// Nós sentinelas para indicar folhas.
			this.noDireita = new NoAB<Prato>(null, null, null);
			this.noEsquerda = new NoAB<Prato>(null, null, null);
		}

		public boolean ehVazio() {
			return this.prato == null;
		}

		public boolean ehFolha() {
			return this.prato != null && this.noEsquerda.ehVazio() && this.noDireita.ehVazio();
		}
		
		public Prato getPrato() {
			return prato;
		}

		public void setPrato(Prato prato) {
			this.prato = prato;
		}
		
		public NoAB<Prato> getNoPai() {
			return noPai;
		}

		public void setNoPai(NoAB<Prato> noPai) {
			this.noPai = noPai;
		}

		public NoAB<Prato> getNoEsquerda() {
			return noEsquerda;
		}

		public void setNoEsquerda(NoAB<Prato> noEsquerda) {
			this.noEsquerda = noEsquerda;
		}

		public NoAB<Prato> getNoDireita() {
			return noDireita;
		}

		public void setNoDireita(NoAB<Prato> noDireita) {
			this.noDireita = noDireita;
		}

		@Override
		public String toString() {
			String resp = "NIL";
			if (!ehVazio()) {
				resp = prato.toString();
			}
			return resp;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			boolean resp = false;
			if (obj instanceof NoAB) {
				if (!this.ehVazio() && !((NoAB<Prato>) obj).ehVazio()) {
					resp = this.prato.equals(((NoAB<Prato>) obj).prato);
				} else {
					resp = this.ehVazio() && ((NoAB<Prato>) obj).ehVazio();
				}
				
			}
			return resp;
		}
	}
