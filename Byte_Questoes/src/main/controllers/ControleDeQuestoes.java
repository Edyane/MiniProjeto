package main.controllers;

import java.util.ArrayList;
import main.models.Questao;

/**
 * A classe ControleDeQuestoes é responsável por gerenciar um conjunto de questões.
 */
public class ControleDeQuestoes {

    private ArrayList<Questao> questoes;

    /**
     * Constrói um objeto ControleDeQuestoes sem nenhuma questão inicialmente.
     */
    public ControleDeQuestoes() {
        this.questoes = new ArrayList<>();
    }

    /**
     * Retorna todas as questões registradas no controle.
     *
     * @return uma lista com todas as questões registradas
     */
    public ArrayList<Questao> getTodasAsQuestoes() {
        return this.questoes;
    }

    /**
     * Adiciona uma nova questão ao controle.
     *
     * @param questao a questão a ser adicionada
     */
    public void adicionarQuestao(Questao questao) {
        this.questoes.add(questao);
    }
    
    /**
     * Adiciona uma nova questão à lista de questões.
     *
     * @param disciplina A disciplina da questão.
     * @param enunciado  O enunciado da questão.
     */
    public void adicionarQuestao(String disciplina, String enunciado) {

        Questao questao = new Questao(disciplina, enunciado);
        this.questoes.add(questao);
    }

    /**
     * Remove a questão de acordo com o índice fornecido.
     *
     * @param index o índice da questão a ser removida
     * @return 1 se a questão foi removida com sucesso, 0 caso contrário
     */
    public int removerQuestao(int index) {
        if (index >= 0 && index < questoes.size()) {
            this.questoes.remove(index);
            return 1;
        }
        return 0;
    }

    /**
     * Atualiza a questão de acordo com o índice fornecido.
     *
     * @param index o índice da questão a ser atualizada
     * @param questaoAtualizada a nova questão atualizada
     * @return 1 se a questão foi atualizada com sucesso, 0 caso contrário
     */
    public int atualizarQuestao(int index, Questao questaoAtualizada) {
        if (index >= 0 && index < questoes.size()) {
            questoes.set(index, questaoAtualizada);
            return 1;
        }

        return 0;
    }

    /**
     * Busca e retorna todas as questões que pertencem a uma determinada disciplina.
     *
     * @param disciplina a disciplina das questões a serem buscadas
     * @return uma lista com as questões encontradas para a disciplina especificada
     */
    public ArrayList<Questao> buscarQuestoesPorDisciplina(String disciplina) {
        ArrayList<Questao> questoesEncontradas = new ArrayList<>();

        for (Questao questao : this.questoes) {
            if (questao.getDisciplina().equalsIgnoreCase(disciplina)) {
                questoesEncontradas.add(questao);
            }
        }

        return questoesEncontradas;
    }
}
