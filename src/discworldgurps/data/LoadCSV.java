package discworldgurps.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadCSV {

    private static final String COMMA_DELIMITER = ",";
    ArrayList<ItemLoader> tmp = new ArrayList();

    /**
     * Loads the CSV passed in by file and splits it
     *
     * @param file filepath passed in from Sheet.java
     */
    public void reader(String file) {
        int count = 10;
        Scanner scanner = null;
        try {
            InputStream in = getClass().getResourceAsStream(file);
            scanner = new Scanner(in);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(COMMA_DELIMITER);
                String[] j = new String[count];
                int i = 0;
                for (String token : split) {
                    j[i] = token;
                    i++;
                }
                tmp.add(new ItemLoader(j[0], j[1], j[2], j[3], j[4], j[5], j[6], j[7], j[8], j[9]));
            }
        } catch (Exception fe) {
            fe.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public ArrayList getTmp() {
        return tmp;
    }

}
