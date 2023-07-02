package main.controllers;

import javax.swing.JOptionPane;

/**
 * A classe ControleInputBuscaQuestao é responsável por fornecer métodos para obter
 * entrada do usuário relacionada à busca de questões.
 */
public class ControleInputBuscaQuestao {

    /**
     * Obtém a entrada da disciplina fornecida pelo usuário.
     *
     * @return A disciplina inserida pelo usuário como uma String.
     *         Retorna "nulo" se o usuário cancelar a entrada.
     */
    public static String getInputDisciplina() {

        String inputQuestao = JOptionPane.showInputDialog(null,
                "Digite o nome da matéria que deseja buscar",
                "Buscar",
                JOptionPane.PLAIN_MESSAGE);

        if (inputQuestao == null) {
            return "nulo";
        } else {
            return inputQuestao.trim();
        }
    }
}
