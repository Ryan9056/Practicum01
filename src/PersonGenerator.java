import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> recs = new ArrayList<>();

        boolean loop = true;
        String ID;
        String firstName;
        String lastName;
        String title;
        int yearOfBirth;

        while (loop == true) {

            ID = SafeInput.getNonZeroLenString(sc,"ID: ");
            firstName = SafeInput.getNonZeroLenString(sc,"First Name");
            lastName = SafeInput.getNonZeroLenString(sc,"Last Name");
            title = SafeInput.getNonZeroLenString(sc,"Title");
            yearOfBirth = SafeInput.getInt(sc,"Year Of Birth");
            recs.add(ID+", "+firstName+", "+lastName+", "+title+", "+yearOfBirth);
            loop = SafeInput.getYNConfirm(sc, "Would you like to add another person? ");

        }
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data1.txt");

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