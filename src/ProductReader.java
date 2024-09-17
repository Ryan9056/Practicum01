import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> recs = new ArrayList<>();

        boolean loop = true;
        String ID;
        String name;
        String description;
        String cost;


        while (loop == true) {

            ID = SafeInput.getNonZeroLenString(sc,"ID: ");
            name = SafeInput.getNonZeroLenString(sc,"Name");
            description = SafeInput.getNonZeroLenString(sc,"Description");
            cost = SafeInput.getNonZeroLenString(sc,"Cost");

            recs.add(ID+", "+name+", "+description+", "+cost);
            loop = SafeInput.getYNConfirm(sc, "Would you like to add another person? ");

        }
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data2.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(String rec : recs)
            {
                writer.write(rec, 0, rec.length());

                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}