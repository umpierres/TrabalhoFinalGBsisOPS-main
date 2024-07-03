package entities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

public class MonitorTest {

    private Monitor monitor;
    private ArrayList<String> cientistas;
    //criando mock
    @Before
    public void setUp() {
        monitor = new Monitor(1000, 3, 1);
        cientistas = new ArrayList<>();
        cientistas.add("Pedro");
        cientistas.add("Carlos");
        cientistas.add("Rodrigo");
    }
    //ver se o criar processo está criando processos com tempo valido
    @Test
    public void testCriarProcessos() {
        monitor.criarProcessos(cientistas);
        int[] valores = monitor.getValores();
        for (int i = 0; i < monitor.getQntMaxima(); i++) {
            assertTrue(valores[i] >= 1000 && valores[i] <= 6000);
        }
    }
    //testa se atualiza corretamente a quantidade de processos
    @Test
    public void testAtualizarQnt() {
        monitor.atualizarQnt();
        assertEquals(4, monitor.getQntMaxima());
    }
    //testa se o tempo dos novos processos são validos
    @Test
    public void testCriarNovosProcessos() {
        monitor.setNovaQnt(2);
        monitor.criarNovosProcessos(cientistas, 2);
        int[] valores = monitor.getValores();
        for (int i = 0; i < monitor.getNovaQnt(); i++) {
            assertTrue(valores[i] >= 1000 && valores[i] <= 6000);
        }
    }
}
