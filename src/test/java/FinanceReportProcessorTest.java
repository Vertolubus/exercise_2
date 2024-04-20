import org.junit.Test;

import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @Test
    public void findSurname()
    {
        Payment payer1 = new Payment("Ааб Са Флв", 6, 12, 2023, 100000);
        Payment payer2 = new Payment("Мав Лоа Двс", 19, 10, 2012, 10392033);
        Payment payer3 = new Payment("Окла Лом Даь", 7, 10, 2023, 1000);
        Payment payer4 = new Payment("Алава Лом Даь", 7, 10, 2023, 1000);
        FinanceReport report = new FinanceReport("A A A", 10, 12, 2023, payer1, payer2, payer3, payer4);

        FinanceReportProcessor finder = new FinanceReportProcessor();
        FinanceReport report1 = new FinanceReport("A A A", 10, 12, 2023, payer1, payer4);
        FinanceReport report2 = new FinanceReport("A A A", 10, 12, 2023, payer2);

        assertEquals(report1, finder.findSurname(report, "А"));
        assertEquals(report2, finder.findSurname(report, "М"));
    }

    @Test
    public  void findPayment()
    {
        Payment payer1 = new Payment("Ааб Са Флв", 6, 12, 2023, 100000);
        Payment payer2 = new Payment("Мав Лоа Двс", 19, 10, 2012, 10392033);
        Payment payer3 = new Payment("Окла Лом Даь", 7, 10, 2023, 100);
        Payment payer4 = new Payment("Алава Лом Даь", 7, 10, 2023, 1000);
        FinanceReport report = new FinanceReport("A A A", 10, 12, 2023, payer1, payer2, payer3, payer4);

        FinanceReportProcessor finder = new FinanceReportProcessor();
        FinanceReport report1 = new FinanceReport("A A A", 10, 12, 2023, payer3);
        FinanceReport report2 = new FinanceReport("A A A", 10, 12, 2023, payer1, payer3, payer4);
        FinanceReport report3 = new FinanceReport("A A A", 10, 12, 2023, payer1, payer2, payer3, payer4);

        assertEquals(report1, finder.findPayment(report, 1000));
        assertEquals(report2, finder.findPayment(report, 100001));
        assertEquals(report3, finder.findPayment(report, 10392034));
    }
}