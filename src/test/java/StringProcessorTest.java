import static org.junit.Assert.*;
import org.junit.Test;

public class StringProcessorTest
{
    @Test
    public void lineOut()
    {
        StringProcessor line = new StringProcessor();
        String actual = new String("ABOBA");

        assertEquals("", line.lineOut(actual, 0));
        assertEquals("ABOBA", line.lineOut(actual, 1));
        assertEquals("ABOBAABOBAABOBA", line.lineOut(actual, 3));
        try {
            line.lineOut(actual, -1);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Error is accepted");
        }
    }

    @Test
    public void countString()
    {
        StringProcessor count = new StringProcessor();
        assertEquals(3, count.countString("abcacabcfhvabc", "abc"));
        assertEquals(1, count.countString("abc", "abc"));
        assertEquals(3, count.countString("asasasa", "asa"));
        try
        {
            count.countString("abc", "");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Error is accepted");
        }
    }

    @Test
    public void replacement()
    {
        StringProcessor replace = new StringProcessor();
        assertEquals("одиндватри", replace.replacement("123"));
        assertEquals("absодинfmsтриmfnsдваdfmfодин", replace.replacement("abs1fms3mfns2dfmf1"));
        assertEquals("", replace.replacement(""));
    }

    @Test
    public void deletingSymbols()
    {
        StringProcessor delete = new StringProcessor();
        assertEquals("saknnk", delete.deletingSymbols("snadkfn1nfk5"));
        assertEquals("", delete.deletingSymbols(""));
    }
}