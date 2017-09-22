
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/** This program will tell you how many words are in a text file accessed by a url. */

public class CtrlF {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /** Prints url contents.
     *
     * @param args Gets stuff done
     */

    public static void main(final String[] args) {

        String urlContents = urlToString("http://erdani.com/tdpl/hamlet.txt");

        String searchTerm = "he";
        int hits = 0;

        java.util.StringTokenizer st = new java.util.StringTokenizer(urlContents);
        while (st.hasMoreTokens()) {
            if (searchTerm.equalsIgnoreCase(st.nextToken())) {
                hits++;
            }
        }

        System.out.println();
        System.out.println(String.format("The supplied URL contains the word \"%s\" %d times.",
              searchTerm, hits));

    }

}
