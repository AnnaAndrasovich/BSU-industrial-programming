package org.example.dishwasher;

//public class Builder
//{
//    protected final String name;
//    protected final int rpm;
//    protected final int cost;
//
//    protected String color = " ";
//
//    public Builder(String name, int volume, int cost)
//    {
//        this.name = name;
//        this.rpm = volume;
//        this.cost = cost;
//    }
//
//    public Builder Color(String str)
//    {
//        color = str;
//        return this;
//    }
//
//    public Dishwasher build() {
//        return new Dishwasher(this);
//    }
//}
public abstract class Builder {
    protected String name;
    protected int volume;
    protected String color;
    protected int cost;


    public Builder(String name, int volume, String color, int cost)
    {
        this.name = name;
        this.volume = volume;
        this.color = color;
        this.cost = cost;
    }



    public Builder()
    {
        this.name = null;
        this.volume = 0;
        this.color = null;
        this.cost = 0;
    }


    public abstract int GetCost();
    public abstract int GetVolume();
    public abstract String GetName();
    public abstract String GetColor();

}