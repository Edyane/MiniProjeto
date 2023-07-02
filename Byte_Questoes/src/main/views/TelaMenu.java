package main.views;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;

import main.controllers.ControleDeQuestoes;
import main.models.Questao;

/**
 * A classe TelaMenu representa a tela de menu principal do sistema de controle de questões.
 * Ela herda da classe BaseTela.
 */
public class TelaMenu extends BaseTela {
    private JButton botaoCadastro;
    private JButton botaoListagem;

    /**
     * Construtor da classe TelaMenu.
     *
     * @param controleDeQuestoes O objeto ControleDeQuestoes responsável pelo controle das questões.
     */
    public TelaMenu(ControleDeQuestoes controleDeQuestoes) {
        // Inicializa a classe mãe (BaseTela)
        super(controleDeQuestoes, "Controle de Questões", "Menu Principal");

        this.botaoListagem = new JButton("Listagem");
        this.botaoCadastro = new JButton("Cadastro");

        Color corBotaoListagemEBusca = new Color(96, 96, 96);

        // Setando fonte e posicionamento do título;
        this.titulo.setBounds(170, 10, 180, 30);

        // Setando fonte e posicionamento do botão de listagem;
        this.botaoListagem.setFont(new Font("Inter", Font.CENTER_BASELINE, 12));
        this.botaoListagem.setBounds(190, 100, 100, 30);
        this.botaoListagem.setForeground(corBotaoListagemEBusca); // Setando cor para o título do botão listagem;
        this.botaoListagem.addActionListener(this);

        // Setando fonte e posicionamento do botão de cadastro;
        this.botaoCadastro.setFont(new Font("Inter", Font.CENTER_BASELINE, 12));
        this.botaoCadastro.setBounds(190, 150, 100, 30);
        this.botaoCadastro.setForeground(corBotaoListagemEBusca);
        this.botaoCadastro.addActionListener(this);

        // Adicionando botões na janela
        this.janela.add(this.botaoListagem);
        this.janela.add(this.botaoCadastro);
    }

    /**
     * Método de ação que será chamado quando ocorrer um evento.
     * Verifica qual botão foi clicado e executa a ação correspondente.
     *
     * @param e O objeto ActionEvent que representa o evento ocorrido.
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == this.botaoListagem) {
            this.fecharTela();
            this.exibeTelaQuestoesCadastradasAtualizada(true, new ArrayList<Questao>());
        }

        if (src == this.botaoCadastro) {
            this.fecharTela();
            new TelaCadastroEAtualizar(this.controleDeQuestoes, "Cadastrar", 0).exibirTela();
        }
    }

    /**
     * Exibe a tela de questões cadastradas atualizada.
     *
     * @param fazerBuscaAoIniciarATela Define se a busca deve ser realizada ao iniciar a tela.
     * @param questoesFiltradas        A lista de questões filtradas para exibir na tela.
     */
    public void exibeTelaQuestoesCadastradasAtualizada(Boolean fazerBuscaAoIniciarATela, ArrayList<Questao> questoesFiltradas) {
        TelaQuestoesCadastradas telaQuestoesCadastradas = new TelaQuestoesCadastradas(this.controleDeQuestoes, fazerBuscaAoIniciarATela, questoesFiltradas);
        telaQuestoesCadastradas.exibirTela();
    }
}
