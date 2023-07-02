package main.models;

/**
* A classe Questao representa uma questão em um sistema de questões.
* Cada questão possui uma disciplina e um enunciado.
*/
public class Questao {
    private String disciplina;
    private String enunciado;

    /**
     * Construtor da classe Questao.
     *
     * @param disciplina A disciplina da questão.
     * @param enunciado  O enunciado da questão.
     */
    public Questao(String disciplina, String enunciado) {
        this.disciplina = disciplina;
        this.enunciado = enunciado;
    }

    /**
     * Obtém a disciplina da questão.
     *
     * @return A disciplina da questão.
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * Define a disciplina da questão.
     *
     * @param disciplina A disciplina da questão.
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Obtém o enunciado da questão.
     *
     * @return O enunciado da questão.
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Define o enunciado da questão.
     *
     * @param enunciado O enunciado da questão.
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Retorna uma representação em string da questão.
     * A representação contém a disciplina seguida por um traço (-) e o enunciado da questão.
     *
     * @return A representação em string da questão.
     */
    public String toString() {
        return this.disciplina + " - " + this.enunciado;
    }

}
