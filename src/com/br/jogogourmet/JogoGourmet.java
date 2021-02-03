package com.br.jogogourmet;

import javax.swing.JOptionPane;

import com.br.jogogourmet.arvore.NoAB;
import com.br.jogogourmet.entidades.Prato;

/**
 * Classe principal do jogo de adivinhação de pratos.
 * @author gabriel-coutinho
 *
 */
public class JogoGourmet {
	public static void main(String[] args) {
		NoAB<Prato> noEsquerda = new NoAB<Prato>();
		noEsquerda.setPrato(new Prato("Bolo de Chocolate"));
		NoAB<Prato> raiz = new NoAB<Prato>(new Prato("Lasanha", "Massa"), noEsquerda, new NoAB<Prato>());
		while (true) {
			Object[] optionOk = { "OK" };
		    JOptionPane.showOptionDialog(null, "Pense em um prato que gosta", "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, optionOk, optionOk[0]);
			exec(raiz, raiz.getPrato().toString());
		}
	}
	
	/**
	 * Método recursivo que constroi o jogo em uma arvore binaria e dele saem as chamadas para inserção e verificacao de dados.
	 * @param no - no do prato atual
	 * @param pratoUltimoSim - nome do último prato que teve uma descrição confirmada. Se não houver recursão é o do no raiz.
	 */
	private static void exec(NoAB<Prato> no, String pratoUltimoSim) {
		if (no.getPrato().getDescricao() == null) {
			if (!no.getNoEsquerda().ehVazio()) {
				exec(no.getNoEsquerda(), no.getPrato().toString());
			} else {
				perguntaSeEhPrato(no, no.getPrato().toString(), "esquerda");
			}
		} else {
			String perguntaDescricao = "O prato que você pensou é " + no.getPrato().getDescricao();
		    Object[] options = { "Sim", "Não" };
		    int descricaoCorreta = JOptionPane.showOptionDialog(null, perguntaDescricao, "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			

			if (descricaoCorreta == 0) {
				if (!no.getNoDireita().ehVazio()) {
					exec(no.getNoDireita(), no.getPrato().toString());
				} else {
					perguntaSeEhPrato(no, no.getPrato().toString(), "direita");
				}
			} else {
				if (!no.getNoEsquerda().ehVazio()) {
					exec(no.getNoEsquerda(), pratoUltimoSim);
				} else {
					perguntaSeEhPrato(no, pratoUltimoSim, "esquerda");
				}
			}
		}
	}

	/**
	 * Testa se o prato atual é o pensado pelo jogador, se não chama o inserir da árvore.
	 * @param no - no do prato atual
	 * @param prato - nome do prato atual
	 * @param direcao - se vai ser inserido a direita ou esquerda do no atual
	 */
	private static void perguntaSeEhPrato(NoAB<Prato> no, String prato, String direcao) {
		String perguntaPrato = "O prato que você pensou é " + prato + "?";
		Object[] options = { "Sim", "Não" };
	    int pratoCorreto = JOptionPane.showOptionDialog(null, perguntaPrato, "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if (pratoCorreto == 0) {
			Object[] optionOk = { "OK"};
		    JOptionPane.showOptionDialog(null, "Acertei de novo!", "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, optionOk, optionOk[0]);
		} else {
			insertPrato(no, prato, direcao);
		}
	}

	/**
	 *  Método para inserir um novo no prato na árvore binária.
	 * @param no
	 * @param pratoUltimoSim
	 * @param direcao
	 */
	private static void insertPrato(NoAB<Prato> no, String pratoUltimoSim, String direcao) {
		String nomePrato = JOptionPane.showInputDialog("Qual prato você pensou?");
		String perguntaNovaDescricao = nomePrato + " é _____ mas, " + pratoUltimoSim + " não.";
		String descricaoPrato = JOptionPane.showInputDialog(perguntaNovaDescricao);

		NoAB<Prato> noNovoPrato = new NoAB<>();
		noNovoPrato.setPrato(new Prato(nomePrato, descricaoPrato));

		if (direcao.equals("direita")) {
			no.setNoDireita(noNovoPrato);
			no.getNoDireita().setNoPai(no);
		} else {
			no.setNoEsquerda(noNovoPrato);
			no.getNoEsquerda().setNoPai(no);
		}
	}
}
