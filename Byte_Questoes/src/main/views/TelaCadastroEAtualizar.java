package main.views;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.controllers.ControleDeQuestoes;
import main.models.Questao;

/**
 * A classe TelaCadastroEAtualizar é responsável por exibir a tela de cadastro e atualização de questões,
 * permitindo ao usuário adicionar ou atualizar questões no sistema.
 */
public class TelaCadastroEAtualizar extends BaseTela {
    private JLabel labelDisciplina;
    private JTextField valorDisciplina;

    private JLabel labelEnunciado;
    private JTextField valorEnunciado;

    private JButton botaoCancelar;
    private JButton botaoCadastrar;
    private JButton botaoAtualizar;

    private String tipoTela;
    private int idQuestaoParaAtualizar;

    /**
     * Constrói um objeto TelaCadastroEAtualizar.
     * 
     * @param controleDeQuestoes     o controle de questões do sistema
     * @param tipoTela               o tipo de tela (Cadastro ou Atualização)
     * @param idQuestaoParaAtualizar o ID da questão a ser atualizada (apenas para
     *                               tela de atualização)
     */
    public TelaCadastroEAtualizar(ControleDeQuestoes controleDeQuestoes, String tipoTela,
            int idQuestaoParaAtualizar) {
        // Chama o construtor da classe BaseTela para definir o título da janela
        super(controleDeQuestoes, String.format("Tela de %s Questão", tipoTela),
                String.format("%s Questão", tipoTela));

        this.tipoTela = tipoTela;
        this.titulo.setBounds(140, 10, 250, 30);

        this.labelDisciplina = new JLabel("Disciplina: ");
        this.valorDisciplina = new JTextField(200);

        this.labelEnunciado = new JLabel("Enunciado: ");
        this.valorEnunciado = new JTextField(200);

        this.botaoCancelar = new JButton("Cancelar");
        this.botaoCadastrar = new JButton("Cadastrar");

        this.labelDisciplina.setBounds(60, 80, 150, 25);
        this.valorDisciplina.setBounds(180, 80, 180, 25);

        this.labelEnunciado.setBounds(60, 130, 150, 25);
        this.valorEnunciado.setBounds(180, 130, 180, 25);

        this.botaoCadastrar.setBounds(130, 215, 100, 30);
        this.botaoCadastrar.addActionListener(this);

        this.botaoCancelar.setBounds(240, 215, 100, 30);
        this.botaoCancelar.addActionListener(this);

        this.janela.add(this.botaoCadastrar);

        if (this.tipoTela.equalsIgnoreCase("Atualizar")) {
            this.modificaTelaParaTelaDeAtualizarQuestao(idQuestaoParaAtualizar);
        }
        this.janela.add(this.labelDisciplina);
        this.janela.add(this.valorDisciplina);
        this.janela.add(this.labelEnunciado);
        this.janela.add(this.valorEnunciado);
        this.janela.add(this.botaoCancelar);
    }

    /**
     * Modifica a tela para exibir os campos preenchidos com os dados da questão a
     * ser atualizada.
     * 
     * @param idQuestaoParaAtualizar o ID da questão a ser atualizada
     */
    private void modificaTelaParaTelaDeAtualizarQuestao(int idQuestaoParaAtualizar) {
        this.botaoAtualizar = new JButton("Atualizar");
        this.botaoAtualizar.setBounds(130, 215, 100, 30);
        this.botaoAtualizar.addActionListener(this);
        this.idQuestaoParaAtualizar = idQuestaoParaAtualizar;

        Questao questaoParaAtualizar = this.controleDeQuestoes.getTodasAsQuestoes().get(this.idQuestaoParaAtualizar);
        this.valorDisciplina = new JTextField(questaoParaAtualizar.getDisciplina(), 200);
        this.valorDisciplina.setBounds(180, 80, 180, 25);

        this.valorEnunciado = new JTextField(questaoParaAtualizar.getEnunciado(), 200);
        this.valorEnunciado.setBounds(180, 130, 180, 25);

        this.janela.remove(this.botaoCadastrar);
        this.janela.add(this.botaoAtualizar);
    }

    /**
     * Manipula os eventos de clique nos botões.
     * 
     * @param e o evento de ação
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == this.botaoCadastrar) {
            String disciplina = valorDisciplina.getText().trim();
            String enunciado = valorEnunciado.getText().trim();

            int confirmacaoDados = this.mensagemConfirmacaoCadastro(disciplina, enunciado);
            if (confirmacaoDados == 0) {
                Questao questaoParaAdicionar = new Questao(disciplina, enunciado);
                this.controleDeQuestoes.adicionarQuestao(questaoParaAdicionar);

                this.mensagemSucessoCadastro();
                this.chamaTelaMenu();
            }
        }

        if ((src == this.botaoCancelar) && (this.tipoTela.equalsIgnoreCase("atualizar"))) {
            this.fecharTela();
            new TelaMenu(this.controleDeQuestoes).exibeTelaQuestoesCadastradasAtualizada(true,
                new ArrayList<Questao>());
        }

        if ((src == this.botaoCancelar) && (this.tipoTela.equalsIgnoreCase("cadastrar"))) {
            this.chamaTelaMenu();
        }

        if (src == this.botaoAtualizar) {
            String disciplina = valorDisciplina.getText().trim();
            String enunciado = valorEnunciado.getText().trim();

            int confirmacaoDados = this.mensagemConfirmacaoCadastro(disciplina, enunciado);
            if (confirmacaoDados == 0) {
                Questao questaoParaAdicionar = new Questao(disciplina, enunciado);
                this.controleDeQuestoes.atualizarQuestao(this.idQuestaoParaAtualizar, questaoParaAdicionar);

                this.mensagemSucessoCadastro();
                this.fecharTela();
                new TelaMenu(this.controleDeQuestoes).exibeTelaQuestoesCadastradasAtualizada(true,
                        new ArrayList<Questao>());
            }
        }
    }

    /**
     * Fecha a tela atual e abre a tela de menu.
     */
    private void chamaTelaMenu() {
        this.fecharTela();
        new TelaMenu(this.controleDeQuestoes).exibirTela();
    }

    /**
     * Exibe uma mensagem de sucesso de cadastro.
     */
    private void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exibe uma caixa de diálogo de confirmação para o cadastro ou atualização da
     * questão.
     * 
     * @param disciplina a disciplina da questão
     * @param enunciado  o enunciado da questão
     * @return o código de confirmação (0 para Sim, 1 para Não)
     */
    private int mensagemConfirmacaoCadastro(String disciplina, String enunciado) {

        int confirmacao = JOptionPane.showConfirmDialog(null,
                String.format(
                        "Tem certeza que deseja %s uma questão com os dados: \n"
                                + "Disciplina: %s\n"
                                + "Enunciado: %s",
                        this.tipoTela.toLowerCase(), disciplina, enunciado),
                "Confirmação!",
                JOptionPane.YES_NO_OPTION);

        return confirmacao;
    }
}
