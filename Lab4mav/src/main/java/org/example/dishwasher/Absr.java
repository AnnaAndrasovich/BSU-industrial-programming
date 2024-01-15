package org.example.dishwasher;
import java.io.BufferedReader;
import java.io.PrintStream;

public abstract class Absr {

    public abstract String Read(BufferedReader reader, String name_of_file);

    public abstract void Write(PrintStream oFile, ListDW dwl, String strFile);

   public abstract int Check();
}
