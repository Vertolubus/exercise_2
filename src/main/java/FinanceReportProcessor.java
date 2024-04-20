import java.util.ArrayList;
//import java.util.Objects;
//import java.util.Arrays;

public class FinanceReportProcessor
{
    public static FinanceReport findSurname(FinanceReport R, String a)
    {
        ArrayList<Payment> list = new ArrayList<>();
        for(int i = 0; i < R.arrPaymentSize(); i++)
        {
            if(R.getPayment(i).getFullName().startsWith(a)) list.add(R.getPayment(i));
        }
        Payment[] report = new Payment[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            report[i] = list.get(i);
        }
        FinanceReport R1 = new FinanceReport(R.getFullName(), R.getDayPayment(), R.getMonthPayment(), R.getYearPayment(), report);
        return R1;
    }

    public static FinanceReport findPayment (FinanceReport R, int pay)
    {
        ArrayList<Payment> list = new ArrayList<>();
        for(int i = 0; i < R.arrPaymentSize(); i++)
        {
            if(R.getPayment(i).getSumOfPayment() < pay) list.add(R.getPayment(i));
        }
        Payment[] report = new Payment[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            report[i] = list.get(i);
        }
        FinanceReport R1 = new FinanceReport(R.getFullName(), R.getDayPayment(), R.getMonthPayment(), R.getYearPayment(), report);
        return R1;
    }
}
