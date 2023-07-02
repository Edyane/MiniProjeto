package tests.main.models;
import org.junit.Test;
import static org.junit.Assert.*;

import main.models.Questao;

public class QuestaoTest {

    @Test
    public void testVerificaSeADisciplinaEhSalvaCorretamenteNaCriacaoDoObjeto() {
        Questao questao = new Questao("Matemática", "Qual é a fórmula de Bhaskara?");
        assertEquals("Matemática", questao.getDisciplina());
    }

    @Test
    public void testValidaModificacaoDisciplinaDepoisDaCriacaoDoObjeto() {
        Questao questao = new Questao("Português", "Qual é o significado da palavra 'efêmero'?");
        questao.setDisciplina("Inglês");
        assertEquals("Inglês", questao.getDisciplina());
    }

    @Test
    public void testVerificaSeOEnunciadoEhSalvoCorretamenteNaCriacaoDoObjeto() {
        Questao questao = new Questao("Biologia", "Explique o ciclo de vida de uma borboleta.");
        assertEquals("Explique o ciclo de vida de uma borboleta.", questao.getEnunciado());
    }

    @Test
    public void testValidaModificacaoEnunciadoDepoisDaCriacaoDoObjeto() {
        Questao questao = new Questao("História", "Descreva o processo de independência do Brasil.");
        questao.setEnunciado("Quais foram as consequências da Revolução Industrial?");
        assertEquals("Quais foram as consequências da Revolução Industrial?", questao.getEnunciado());
    }

    @Test
    public void testVerificaRetornoCorretoDoFormatoStringDoObjeto() {
        Questao questao = new Questao("Geografia", "Cite cinco capitais da Europa.");
        assertEquals("Geografia - Cite cinco capitais da Europa.", questao.toString());
    }
}
