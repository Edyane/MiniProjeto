package tests.main.controllers;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import main.controllers.ControleDeQuestoes;
import main.models.Questao;

public class ControleDeQuestoesTest {

    @Test
    public void testVerificaSeAQuantidadeDeQuestoesEhIgualAZero() {
        ControleDeQuestoes controle = new ControleDeQuestoes();
        ArrayList<Questao> questoes = controle.getTodasAsQuestoes();

        Assert.assertNotNull(questoes);
        Assert.assertEquals(0, questoes.size());
    }

    @Test
    public void testVerificaSeAQuantidadeDeQuestoesEstaCorreta() {
        ControleDeQuestoes controle = new ControleDeQuestoes();
        controle.adicionarQuestao(new Questao("Banco de Dados", "O que significa SQL?"));
        controle.adicionarQuestao(new Questao("Algoritmos", "O que é um algoritmo?"));
        controle.adicionarQuestao(new Questao("Redes de Computadores", "O que significa TC/IP?"));
        
        ArrayList<Questao> questoes = controle.getTodasAsQuestoes();
        Assert.assertEquals(3, questoes.size());
    }

    @Test
    public void testValidaSeAcrescentaQuestaoCorretamenteNoControleDeQuestoes() {
        ControleDeQuestoes controle = new ControleDeQuestoes();
        Questao questao = new Questao("Matemática", "Qual é a fórmula de Bhaskara?");

        controle.adicionarQuestao(questao);

        ArrayList<Questao> questoes = controle.getTodasAsQuestoes();
        Assert.assertEquals(1, questoes.size());
        Assert.assertEquals(questao, questoes.get(0));
    }

    @Test
    public void testVerificaSeREmoveCorretamenteAQuestaoDoCOntroleDeQuestoes() {
        ControleDeQuestoes controle = new ControleDeQuestoes();
        Questao questao = new Questao("História", "Quem descobriu o Brasil?");
        controle.adicionarQuestao(questao);

        int result = controle.removerQuestao(0);

        ArrayList<Questao> questoes = controle.getTodasAsQuestoes();
        Assert.assertEquals(0, questoes.size());
        Assert.assertEquals(1, result);
    }

    @Test
    public void testVerificaSeAtualizaCorretamenteAQuestaoEscolhidaNoControleDeQuestoes() {
        ControleDeQuestoes controle = new ControleDeQuestoes();
        Questao questaoAntiga = new Questao("Geografia", "Qual é a capital da França?");
        controle.adicionarQuestao(questaoAntiga);

        Questao questaoAtualizada = new Questao("Geografia", "Qual é a capital da Alemanha?");
        int result = controle.atualizarQuestao(0, questaoAtualizada);

        ArrayList<Questao> questoes = controle.getTodasAsQuestoes();
        Assert.assertEquals(1, questoes.size());
        Assert.assertEquals(questaoAtualizada, questoes.get(0));
        Assert.assertEquals(1, result);
    }

    @Test
    public void testVerificaSeRetornaCorretamenteTodasAsQuestoesFiltradasPelaDisciplina() {
        ControleDeQuestoes controle = new ControleDeQuestoes();
        controle.adicionarQuestao(new Questao("Banco de Dados", "O que significa SQL?"));
        controle.adicionarQuestao(new Questao("Algoritmos", "O que é um algoritmo?"));
        controle.adicionarQuestao(new Questao("Algoritmos", "O que é uma função?"));
        controle.adicionarQuestao(new Questao("Algoritmos", "O que são estruturas de controle?"));
        controle.adicionarQuestao(new Questao("Redes de Computadores", "O que significa TC/IP?"));

        ArrayList<Questao> questoesAlgoritmos = controle.buscarQuestoesPorDisciplina("Algoritmos");
        ArrayList<Questao> questoesMatematica = controle.buscarQuestoesPorDisciplina("Matemática");
      

        Assert.assertEquals(3, questoesAlgoritmos.size());
        Assert.assertEquals(0, questoesMatematica.size());
        
    }
}
