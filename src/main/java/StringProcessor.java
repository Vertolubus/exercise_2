public class StringProcessor
{
    public String lineOut(String str, int N)
    {
        if(N < 0) throw new IllegalArgumentException("N < 0");
        String temp = new String();
        if(N == 0)
        {
            return temp;
        }
        else
        {
            for(int i = 0; i < N; i++)
            {
                temp = temp.concat(str);
            }
            return temp;
        }
    }

    public int countString(String str1, String str2)
    {
        if(str2 == null || str2.isEmpty()) throw new IllegalArgumentException("Line is empty or null");
        int count = 0;
        int i = 0;
        while (str1.indexOf(str2, i) != -1)
        {
            count++;
            i=str1.indexOf(str2, i)+1;
        }
        return count;
    }

    public String replacement(String str)
    {
        str = str.replace("1", "один");
        str = str.replace("2", "два");
        str = str.replace("3", "три");
        return str;
    }

    public String deletingSymbols(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        for(int i = 1; i  < sb.length(); i+=1)
        {
            sb.deleteCharAt(i);
        }
        str = String.valueOf(sb);
        return str;
    }

}
