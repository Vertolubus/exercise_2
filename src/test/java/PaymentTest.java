import static org.junit.Assert.*;
import org.junit.Test;

public class PaymentTest
{

    @Test
    public void testEquals()
    {
        Payment equals1 = new Payment("А А А", 06, 12, 2023, 100000);
        Payment equals2 = new Payment("А А А", 06, 12, 2023, 100000);
        Payment equals3 = new Payment("А Б А", 07, 10, 2023, 1000);

        assertEquals(true, equals1.equals(equals2));
        assertEquals(false, equals1.equals(equals3));
    }

    @Test
    public void testHashCode()
    {
        Payment equals1 = new Payment("А А А", 06, 12, 2023, 100000);
        Payment equals2 = new Payment("А А А", 06, 12, 2023, 100000);
        Payment equals3 = new Payment("А Б А", 07, 10, 2023, 1000);

        assertTrue(equals1.hashCode() == equals2.hashCode());
        assertFalse(equals1.hashCode() == equals3.hashCode());
    }

    @Test
    public void testToString()
    {
        Payment payer1 = new Payment("А А А", 6, 12, 2023, 100000);
        Payment payer2 = new Payment("А Б А", 7, 10, 2023, 100039);
        String p1 = new String("Плательщик: А А А, дата: 6.12.2023, сумма: 1000 руб. 0 коп.\n");
        String p2 = new String("Плательщик: А Б А, дата: 7.10.2023, сумма: 1000 руб. 39 коп.\n");
        assertEquals(p1, payer1.toString());
        assertEquals(p2, payer2.toString());
    }
}