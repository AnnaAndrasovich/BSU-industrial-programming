package org.example.dishwasher;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
public class ListDW {
    private ArrayList<Dishwasher> dishwashers;

    public ListDW()
    {
        dishwashers = new ArrayList<Dishwasher>();
    }

    public int Size()
    {
        return dishwashers.size();
    }

    public Dishwasher get(int i)
    {
        return dishwashers.get(i);
    }

    public void insert(Dishwasher model)
    {
        dishwashers.add(model);
    }

    public void sortByCost()
    {
        Collections.sort(dishwashers, Dishwasher.COMPARE_BY_COST);
    }

    public void sortByVolume()
    {
        Collections.sort(dishwashers, Dishwasher.COMPARE_BY_VOLUME);
    }

    public void Print(String OutputFileName, Files file)
    {
        try {
            PrintStream fileOut = new PrintStream( OutputFileName);
            file.Write(fileOut, this, OutputFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Print(String OutputFileName, XMLf file)
    {
        try {
            PrintStream fileOut = new PrintStream( OutputFileName);
            file.Write(fileOut, this,  OutputFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
