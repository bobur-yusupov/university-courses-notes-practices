package text.to.numbers;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class SingleLineFile 
{
    public static int addNumbers(String fileName)
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File()));

        String s = bufferedReader.readLine();
        String[] strs = s.split("\\s");
        int total = 0;

        for (String str : strs) {
            total += Integer.parseInt(str);
        }

        return total;
    }
}