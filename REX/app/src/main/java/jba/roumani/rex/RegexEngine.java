package jba.roumani.rex;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2/29/16.
 */
public class RegexEngine
{
    private String[] pool;
    private Random rng;
    private String regex;

    public RegexEngine(String[] pool)
    {

    }

    public void reset()
    {

    }

    public String getRegex()
    {
        return this.regex;
    }

    public String analyze(String data)
    {
        String result = "";

        return (result.length() == 0)? "Not Found!" : result;
    }

    public static void main(String[] args)
    {
        String[] pool = new String[4];
        pool[0] ="([A-VXYa-vxy][0-9][A-Za-z]) ?([0-9][A-Za-z][0-9])";
        pool[1] ="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
        pool[2] ="\\([^()]+\\)|[^()]+";
        pool[3] ="(http|ftp)://([^/\\r\\n]+)(/[^\\r\\n]*)?";

    }
}
