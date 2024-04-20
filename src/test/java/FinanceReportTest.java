import static org.junit.Assert.*;
import org.junit.Test;

public class FinanceReportTest
{
    @Test
    public void financeReport()
    {
        Payment payer1 = new Payment("А А А", 6, 12, 2023, 100000);
        Payment payer2 = new Payment(payer1);
        Payment payer3 = new Payment("А Б А", 7, 10, 2023, 1000);
        //проверка конструктора копирования
        assertNotSame(payer1, payer2);
        assertEquals(payer1, payer2);

        FinanceReport report1 = new FinanceReport("A A A", 10, 12, 2023, payer1, payer2, payer3);
        FinanceReport report2 = new FinanceReport(report1);
        FinanceReport report3 = new FinanceReport("1 2 3", 11, 12, 2022, payer2, payer3);
        //проверка конструктора копирования
        assertNotSame(report1, report2);
        assertEquals(report1, report2);
//        report1.setPayment(payer1, 2);
//        assertNotEquals(report1, report2);

//        //проверка equals
//        assertEquals(true, report1.equals(report2));
//        assertEquals(false, report1.equals(report3));
//
//        //проверка hash code
//        assertTrue(report1.hashCode() == report2.hashCode());
//        assertFalse(report2.hashCode() == report3.hashCode());
    }

    @Test
    public void setGetPayment()
    {
        Payment payer1 = new Payment("А А А", 06, 12, 2023, 100000);
        Payment payer2 = new Payment("А Б А", 07, 10, 2023, 1000);
        FinanceReport report1 = new FinanceReport("A A A", 12, 3, 1231, payer1, payer2);

        assertEquals(payer1, report1.getPayment(0));
        assertEquals(payer2, report1.getPayment(1));
        report1.setPayment(payer1, 1);
        assertEquals(payer1, report1.getPayment(1));
    }

    @Test
    public void ToString()
    {
        Payment payer1 = new Payment("A A A", 6, 12, 2023, 100000);
        Payment payer2 = new Payment(payer1);
        Payment payer3 = new Payment("A Б A", 7, 10, 2023, 1000);
        FinanceReport report1 = new FinanceReport("A A A", 10, 12, 2023, payer1, payer2, payer3);
        assertEquals("[Автор: A A A, дата: 10.12.2023, Платежи: [\n" +
                "Плательщик: A A A, дата: 6.12.2023, сумма: 1000 руб. 0 коп.\n" +
                "Плательщик: A A A, дата: 6.12.2023, сумма: 1000 руб. 0 коп.\n" +
                "Плательщик: A Б A, дата: 7.10.2023, сумма: 10 руб. 0 коп.\n]]", report1.toString());
    }
}