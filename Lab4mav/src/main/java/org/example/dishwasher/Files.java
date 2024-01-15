package org.example.dishwasher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public class Files extends Absr{

    public String data;
    public Files()
    {
        data = null;
    }

    public int Check()
    {
        if(Objects.equals(data,"txt"))
        {
            return 1;
        }
        else
            return 0;
    }

    public String Read (BufferedReader reader, String fName)
    {
        try {

            data = reader.readLine();
            System.out.println(data);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }

    public void Write(PrintStream fileOut, ListDW model, String name)
    {
        String 	outputString = model.toString();
        fileOut.println(outputString);
    }
}