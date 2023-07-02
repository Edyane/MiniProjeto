package main.views;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import main.controllers.ControleInputIdQuestao;
import main.controllers.ControleDeQuestoes;
import main.controllers.ControleInputBuscaQuestao;
import main.models.Questao;

/**
 * A classe TelaQuestoesCadastradas representa a tela de listagem das questões cadastradas.
 * É uma subclasse da classe BaseTela.
 */
public class TelaQuestoesCadastradas extends BaseTela {

    private ArrayList<Questao> questoesFiltradas;
    private JButton botaoDeletarQuestao;
    private JButton botaoAtualizarQuestao;
    private JButton botaoBuscarQuestaoPorDisciplina;
    private JButton limparBusca;

    /**
     * Construtor da classe TelaQuestoesCadastradas.
     *
     * @param controleDeQuestoes O objeto ControleDeQuestoes utilizado para acessar e manipular as questões.
     * @param fazerBuscaAoIniciar Um valor booleano indicando se a busca deve ser realizada ao iniciar a tela.
     * @param dadosFiltrados Uma lista de Questao contendo os dados filtrados a serem exibidos na tela.
     */
    public TelaQuestoesCadastradas(ControleDeQuestoes controleDeQuestoes, Boolean fazerBuscaAoIniciar, ArrayList<Questao> dadosFiltrados) {
        super(controleDeQuestoes, "Listagem", "Questões Cadastradas");

        this.questoesFiltradas = dadosFiltrados;

        this.botaoDeletarQuestao = new JButton("Deletar");
        this.botaoAtualizarQuestao = new JButton("Atualizar");
        this.botaoBuscarQuestaoPorDisciplina = new JButton("buscar");
        this.titulo.setBounds(140, 10, 250, 30);

        this.botaoDeletarQuestao.setBounds(240, 215, 100, 30);
        this.botaoDeletarQuestao.addActionListener(this);

        this.botaoAtualizarQuestao.setBounds(130, 215, 100, 30);
        this.botaoAtualizarQuestao.addActionListener(this);

        this.botaoBuscarQuestaoPorDisciplina.setFont(new Font("Inter", Font.CENTER_BASELINE, 8));
        this.botaoBuscarQuestaoPorDisciplina.setBounds(20, 10, 70, 20);
        this.botaoBuscarQuestaoPorDisciplina.addActionListener(this);

        this.janela.add(this.botaoDeletarQuestao);
        this.janela.add(this.botaoAtualizarQuestao);
        this.janela.add(this.botaoBuscarQuestaoPorDisciplina);

        // Está chamando essa função da classe mãe (BaseTela)
        this.adicionaBotaoMenu();

        if (fazerBuscaAoIniciar) {
            this.buscarDadosQuestoes();
        } else {
            this.modificaTelaParaTelaQuestoesFiltradas();
        }
    }

    /**
     * Modifica a tela para exibir os dados filtrados.
     */
    private void modificaTelaParaTelaQuestoesFiltradas() {

        this.limparBusca = new JButton("limpar filtro");
        this.limparBusca.setBounds(190, 215, 100, 30);
        this.limparBusca.addActionListener(this);

        this.janela.remove(this.botaoBuscarQuestaoPorDisciplina);
        this.janela.remove(this.botaoAtualizarQuestao);
        this.janela.remove(this.botaoDeletarQuestao);

        this.janela.add(this.limparBusca);
        this.renderizaListagemDeQuestoes(this.questoesFiltradas);
    }

    /**
     * Realiza a busca de todas as questões e exibe na tela.
     */
    private void buscarDadosQuestoes() {
        ArrayList<Questao> listaQuestoes = this.controleDeQuestoes.getTodasAsQuestoes();
        this.renderizaListagemDeQuestoes(listaQuestoes);
    }

    /**
     * Renderiza a listagem de questões na tela.
     *
     * @param questoesParaListagem A lista de Questao a ser exibida na tela.
     */
    private void renderizaListagemDeQuestoes(ArrayList<Questao> questoesParaListagem) {
        JScrollPane viewListaQuestoesCadastradas = new JScrollPane();
        String[] questoesEmFormatoString = new String[questoesParaListagem.size()];

        int i = 0;
        for (Questao questao : questoesParaListagem) {
            questoesEmFormatoString[i] = String.format("%d) %s", i + 1, questao.toString());
            i++;
        }

        JList<String> listaQuestoesCadastradas = new JList<String>(questoesEmFormatoString);

        viewListaQuestoesCadastradas.setViewportView(listaQuestoesCadastradas);
        viewListaQuestoesCadastradas.setBounds(20, 50, 450, 150);
        listaQuestoesCadastradas.setLayoutOrientation(JList.VERTICAL);
        this.janela.add(viewListaQuestoesCadastradas);
    }

    // Captura eventos relacionados aos botoes da interface;
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == this.botaoMenu) {
            this.fecharTela();
            new TelaMenu(this.controleDeQuestoes).exibirTela();
        }

        if (src == this.limparBusca) {
            this.fecharTela();
            new TelaMenu(this.controleDeQuestoes).exibeTelaQuestoesCadastradasAtualizada(true, new ArrayList<Questao>());
        }

        if (src == this.botaoAtualizarQuestao) {
            ControleInputIdQuestao controleInputAtualizar = new ControleInputIdQuestao(this.controleDeQuestoes,
                    "Atualizar");
            int idQuestao = controleInputAtualizar.getIdQuestao();

            if (idQuestao >= 0) {
                this.fecharTela();
                new TelaCadastroEAtualizar(this.controleDeQuestoes, "Atualizar", idQuestao).exibirTela();
            }
        }

        if (src == this.botaoBuscarQuestaoPorDisciplina) {
            String disciplinaParaBusca = ControleInputBuscaQuestao.getInputDisciplina();

            if (disciplinaParaBusca.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(
                    null, "Coloque uma disciplina válida."
                );

            } else {
                if (!disciplinaParaBusca.equalsIgnoreCase("nulo")) {
                    ArrayList<Questao> questoesFiltradasPorDisciplina = this.controleDeQuestoes
                        .buscarQuestoesPorDisciplina(disciplinaParaBusca);

                    if (questoesFiltradasPorDisciplina.size() == 0) {
                        JOptionPane.showMessageDialog(
                            null, String.format(
                            "Não foram encontradas questoes com a disciplina '%s'.", disciplinaParaBusca)
                        );

                    } else {
                        this.fecharTela();
                        new TelaMenu(this.controleDeQuestoes).exibeTelaQuestoesCadastradasAtualizada(false, questoesFiltradasPorDisciplina);
                    }
                }
            }
        }

        if (src == this.botaoDeletarQuestao) {
            ControleInputIdQuestao controleInputAtualizar = new ControleInputIdQuestao(this.controleDeQuestoes, "Deletar");
            int idQuestao = controleInputAtualizar.getIdQuestao();

            if (idQuestao >= 0) {
                int confirmacao = controleInputAtualizar.pegarConfirmacaoUsuario(idQuestao + 1);
                System.out.println(confirmacao);
                if (confirmacao == 0) {
                    int response = this.controleDeQuestoes.removerQuestao(idQuestao);

                    if (response == 1) {
                        JOptionPane.showMessageDialog(null, "Questão deletada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar a questão!");
                    }

                    this.fecharTela();
                    new TelaMenu(this.controleDeQuestoes).exibeTelaQuestoesCadastradasAtualizada(true, new ArrayList<Questao>());
                }
            }
        }
    }
}
