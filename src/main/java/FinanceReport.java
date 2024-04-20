import java.util.Arrays;
import java.util.Objects;

public class FinanceReport
{
    private Payment[] arrPayment;
    private String fullName;
    private int dayPayment;
    private int monthPayment;
    private int yearPayment;



    public FinanceReport(String fullName, int dayPayment, int monthPayment, int yearPayment, Payment ... arrPayment)
    {
        this.arrPayment = new Payment[arrPayment.length];
        for(int i = 0; i < arrPayment.length; i++)
        {
            this.arrPayment[i] = arrPayment[i];
        }
        this.fullName = fullName;
        this.dayPayment = dayPayment;
        this.monthPayment = monthPayment;
        this.yearPayment = yearPayment;
    }

    FinanceReport(FinanceReport R)
    {
        arrPayment = new Payment[R.arrPaymentSize()];
        for(int i = 0; i < R.arrPaymentSize(); i++)
        {
            arrPayment[i] = new Payment(R.getPayment(i));
        }
        fullName = R.getFullName();
        dayPayment = R.getDayPayment();
        monthPayment = R.getMonthPayment();
        yearPayment = R.getYearPayment();
    }

    public String getFullName() {
        return fullName;
    }

    public int getDayPayment() {
        return dayPayment;
    }

    public int getMonthPayment() {
        return monthPayment;
    }

    public int getYearPayment() {
        return yearPayment;
    }

    public int arrPaymentSize ()
    {
        return arrPayment.length;
    }

    void setPayment (Payment pay, int i)
    {
        if(i < arrPayment.length && i >= 0)
        {
            arrPayment[i].setFullName(pay.getFullName());
            arrPayment[i].setSumOfPayment(pay.getSumOfPayment());
            arrPayment[i].setDay(pay.getDay());
            arrPayment[i].setMonth(pay.getMonth());
            arrPayment[i].setYear(pay.getYear());
        }
    }

    public Payment getPayment(int i)
    {
        return new Payment(arrPayment[i].getFullName(), arrPayment[i].getDay(), arrPayment[i].getMonth(), arrPayment[i].getYear(), arrPayment[i].getSumOfPayment());
    }

    public String toString()
    {
        String pay = "";
        for(int i = 0; i < arrPayment.length; i++)
        {
            pay += arrPayment[i].toString();
        }
        String text = String.format("[Автор: %s, дата: %d.%d.%d, Платежи: [\n%s]]", fullName, dayPayment, monthPayment, yearPayment, pay);
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport that)) return false;
        return getDayPayment() == that.getDayPayment() && getMonthPayment() == that.getMonthPayment() && getYearPayment() == that.getYearPayment() && Arrays.equals(arrPayment, that.arrPayment) && Objects.equals(getFullName(), that.getFullName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getFullName(), getDayPayment(), getMonthPayment(), getYearPayment());
        result = 31 * result + Arrays.hashCode(arrPayment);
        return result;
    }
}
