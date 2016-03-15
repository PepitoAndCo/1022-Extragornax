package jr.eecs1022.piglatin;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator
{
    private String english;
    private String pig;

    public PigLatinTranslator()
    {
        this.setEnglish("");
    }

    public PigLatinTranslator(String text)
    {
        this.setEnglish(text);
    }

    public String getEnglish()
    {
        return this.english;
    }

    public void setEnglish(String text)
    {
        this.english = text.toLowerCase();
        this.translate();
    }

    public String getPig()
    {
        return this.pig;
    }

    // Translate the state to PigLatin
    public void translate()
    {
        StringTokenizer st = new StringTokenizer(this.english);
        String result = "";
        while (st.hasMoreTokens())
        {
            String word = st.nextToken();
            String pig = this.translateWord(word);
            if (result.length() == 0)
            {
                result = pig;
            }
            else
            {
                result = result + " " + pig;
            }
        }
        this.pig = result;
    }

    // Translate the given word to PigLatin
    // and return the translation
    private String translateWord(String word)
    {
        // replace with correct code
        String result = word;

        Pattern patt = Pattern.compile("(^[aeiou])");
        Matcher match = patt.matcher(word);
        if (match.find()) {
            result = word.concat("way");

        }else{
            StringBuilder temp = new StringBuilder(word.length());
            int x = 0; //indexer
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == 'a' || word.charAt(i) == 'e' ||  word.charAt(i) == 'i' ||
                        word.charAt(i) == 'o' || word.charAt(i) == 'u')
                    break;
                else {
                    temp.append(word.charAt(i));
                    x = i;
                }}
            System.out.println("index equals " +x);
            System.out.println("--------");
            if (x == word.length()-1){
                result = word + "ay";
            }else {
                result = word.substring(x+1, word.length()) + temp + "ay";
            }}


        return result;
    }
}
