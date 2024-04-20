import java.util.Objects;

public class Payment
{
    private String fullName;
    private int day;
    private int month;
    private int year;
    private int sumOfPayment;

    Payment(String fullName, int day, int month, int year, int sumOfPayment)
    {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sumOfPayment = sumOfPayment;
    }

    Payment (Payment P)
    {
        fullName = P.getFullName();
        day = P.getDay();
        month = P.getMonth();
        year = P.getYear();
        sumOfPayment = P.getSumOfPayment();
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSumOfPayment() {
        return sumOfPayment;
    }

    public void setSumOfPayment(int sumOfPayment) {
        this.sumOfPayment = sumOfPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return getDay() == payment.getDay() && getMonth() == payment.getMonth() && getYear() == payment.getYear() && getSumOfPayment() == payment.getSumOfPayment() && Objects.equals(getFullName(), payment.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, sumOfPayment);
    }

    @Override
    public String toString() {
        return String.format("Плательщик: %s, дата: %d.%d.%d, сумма: %d руб. %d коп.\n", getFullName(), getDay(), getMonth(), getYear(), getSumOfPayment() / 100,  getSumOfPayment() % 100);
    }
}
