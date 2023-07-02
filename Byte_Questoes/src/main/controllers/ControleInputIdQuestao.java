package main.controllers;

import javax.swing.JOptionPane;

/**
 * A classe ControleInputIdQuestao é responsável por lidar com a entrada do usuário para obter o ID de uma questão.
 * Ela permite a obtenção e tratamento do ID da questão, além de fornecer uma confirmação de ação ao usuário.
 */
public class ControleInputIdQuestao {
    private ControleDeQuestoes controleDeQuestoes;
    private String tipoModificacao;

    /**
     * Cria uma nova instância de ControleInputIdQuestao.
     *
     * @param controleDeQuestoes O controle de questões associado.
     * @param tipoModificacao O tipo de modificação que será realizada na questão.
     */
    public ControleInputIdQuestao(ControleDeQuestoes controleDeQuestoes, String tipoModificacao) {
        this.controleDeQuestoes = controleDeQuestoes;
        this.tipoModificacao = tipoModificacao;
    }

    /**
     * Obtém o ID da questão fornecido pelo usuário.
     *
     * @return O ID da questão inserido pelo usuário.
     */
    public int getIdQuestao() {
        int idQuestaoEscolhida = -1;

        String inputQuestao = JOptionPane.showInputDialog(null,
                String.format("Qual o número da questão que deseja %s?", this.tipoModificacao.toLowerCase()),
                String.format("%s Questão?", this.tipoModificacao),
                JOptionPane.PLAIN_MESSAGE);

        if (inputQuestao != null) {
            idQuestaoEscolhida = this.trataInputQuestao(inputQuestao);
        }

        return idQuestaoEscolhida;
    }

    private int trataInputQuestao(String questaoEscolhida) {
        int numeroQuestaoTratada = 0;

        try {
            numeroQuestaoTratada = Integer.parseInt(questaoEscolhida);

            int quantidadeDeQuestoes = this.controleDeQuestoes.getTodasAsQuestoes().size();
            int[] opcoesDisponiveis = new int[quantidadeDeQuestoes];

            for (int i = 0; i < quantidadeDeQuestoes; i++) {
                opcoesDisponiveis[i] = i;
            }

            Boolean temEssaQuestao = false;
            for (int opcao : opcoesDisponiveis) {
                if (opcao == numeroQuestaoTratada - 1) {
                    temEssaQuestao = true;
                }
            }

            if (temEssaQuestao) {
                return numeroQuestaoTratada - 1;

            } else {
                JOptionPane.showMessageDialog(null, "Insira o número de uma das questões disponíveis!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Insira um valor válido!");
        }

        return -1;
    }

    /**
     * Obtém a confirmação do usuário para uma determinada ação na questão.
     *
     * @param idQuestao O ID da questão para a qual a confirmação está sendo solicitada.
     * @return O valor da confirmação: JOptionPane.YES_OPTION se o usuário confirmar, JOptionPane.NO_OPTION se o usuário negar.
     */
    public int pegarConfirmacaoUsuario(int idQuestao) {
        int confirmacao = JOptionPane.showConfirmDialog(null,
                String.format("Tem certeza que deseja %s a questão %d?", this.tipoModificacao.toLowerCase(), idQuestao),
                "Confirmação!",
                JOptionPane.YES_NO_OPTION);

        return confirmacao;
    }
}
