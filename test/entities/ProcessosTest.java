package entities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ProcessosTest {

    private Monitor monitor;
    private Processos processos;
    //criando mock
    @Before
    public void setUp() {
        monitor = new Monitor(1000, 3, 1);
        processos = new Processos(monitor);
    }
    //ve se o get retorna os cientistas corretamente
    @Test
    public void testGetCientistas() {
        ArrayList<String> cientistas = processos.getCientistas();
        assertNotNull(cientistas);
        assertEquals(8, cientistas.size());
        assertEquals("Pedro", cientistas.get(0));
    }
    //ve se o set atualiza corretamete
    @Test
    public void testSetCientistas() {
        ArrayList<String> novosCientistas = new ArrayList<>();
        novosCientistas.add("Marie Curie");
        novosCientistas.add("Isaac Newton");
        processos.setCientistas(novosCientistas);
        assertEquals(2, processos.getCientistas().size());
        assertEquals("Marie Curie", processos.getCientistas().get(0));
    }
}
