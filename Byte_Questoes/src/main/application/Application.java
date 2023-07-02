package main.application;

import main.models.Questao;
import main.views.TelaMenu;
import main.controllers.ControleDeQuestoes;

/**
* A classe Application é a classe principal do programa que executa a aplicação de questões.
* Ela inicializa o controle de questões, adiciona questões base e exibe a tela de menu.
*/
public class Application {
    /**
    * O método main é o ponto de entrada da aplicação.
    * Ele cria uma instância do ControleDeQuestoes, adiciona questões base e exibe a tela de menu.
    *
    * @param args os argumentos de linha de comando (não utilizados neste caso)
    */
    public static void main(String[] args) {
        ControleDeQuestoes controleDeQuestoes = new ControleDeQuestoes();
        Application.adicionaQuestoesBaseNoControleDeQuestoes(controleDeQuestoes);

        TelaMenu app = new TelaMenu(controleDeQuestoes);
        app.exibirTela();
    }

    /**
     * O método adicionaQuestoesBaseNoControleDeQuestoes adiciona as questões base no ControleDeQuestoes fornecido.
     * São adicionadas quatro questões predefinidas.
     *
     * @param controleDeQuestoes o ControleDeQuestoes onde as questões serão adicionadas
     */
    public static void adicionaQuestoesBaseNoControleDeQuestoes(ControleDeQuestoes controleDeQuestoes) {
        controleDeQuestoes.adicionarQuestao(new Questao("Banco de Dados", "O que significa SQL?"));
        controleDeQuestoes.adicionarQuestao(new Questao("Algoritmos", "O que é um algoritmo?"));
        controleDeQuestoes.adicionarQuestao(new Questao("Redes de Computadores", "O que significa TC/IP?"));
        controleDeQuestoes.adicionarQuestao(new Questao("Estatística", "Como calcular a mediana?"));
    }
}
