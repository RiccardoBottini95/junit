import listadinamica.ListaInteger;
import static org.junit.Assert.*;
import org.junit.Test;

public class ListaIntegerTest {

    @Test
    public void getElement() {
        ListaInteger test = new ListaInteger();
        test.addElement(16);
        test.addElement(25);
        test.addElement(35);

        Integer tmp = 25;
        assertEquals(tmp, test.getElement(1));

        assertEquals(null, test.getElement(3));

        assertEquals(null, test.getElement(-1));
    }

    @Test
    public void getSize() {
        ListaInteger test = new ListaInteger();
        test.addElement(16);
        test.addElement(25);
        test.addElement(35);

        assertEquals(3, test.getSize());

        ListaInteger test2 = new ListaInteger();
        assertEquals(0, test2.getSize());
    }

    @Test
    public void trovaMinimo() {
        ListaInteger test = new ListaInteger();
        test.addElement(16);
        test.addElement(25);
        test.addElement(35);
        Integer tmp = 16;
        assertEquals(tmp, test.trovaMinimo());

        ListaInteger test2 = new ListaInteger();
        assertEquals(null, test2.trovaMinimo());
    }

    @Test
    public void trovaMassimo() {
        ListaInteger test = new ListaInteger();
        test.addElement(16);
        test.addElement(25);
        test.addElement(35);
        Integer tmp = 35;
        assertEquals(tmp, test.trovaMassimo());

        ListaInteger test2 = new ListaInteger();
        assertEquals(null, test2.trovaMassimo());
    }


    @Test
    public void contaOccorrenze() {
        ListaInteger test = new ListaInteger();
        test.addElement(16);
        test.addElement(25);
        test.addElement(46);
        test.addElement(35);
        test.addElement(16);
        assertEquals(2, test.contaOccorrenze(16));
        assertEquals(0, test.contaOccorrenze(58));
    }

    @Test
    public void trovaIndice() {
        ListaInteger test = new ListaInteger();
        test.addElement(16);
        test.addElement(25);
        test.addElement(46);
        test.addElement(35);
        assertEquals(-1, test.trovaIndice(58));
        assertEquals(1, test.trovaIndice(25));
    }
}