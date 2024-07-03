package application;

import entities.Monitor;
import entities.Processos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream simulatedInput;

    @Before
    //mock
    public void setUp() {
        String input = "2000\n3\n";
        simulatedInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(simulatedInput);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testMain() {
        Main.main(new String[]{});

        // ver se os processos estão sendo criados com os valores certos
        Monitor monitor = new Monitor(2000, 3, 1);
        assertEquals(2000, monitor.getQuantum());
        assertEquals(3, monitor.getQntMaxima());

        // ver se os processos minimos foram criados
        int[] valores = monitor.getValores();
        assertTrue(valores.length >= 3);


        // ver se a adição funcionou
        assertTrue(monitor.getQntMaxima() >= 3);

    }
}
