package org.example.dishwasher;
import java.util.Comparator;

//public class Dishwasher {
//    protected final int cost;
//    private final int rpm;
//    protected final String name;
//    protected final String color;
//    protected  int volume;
//
//    public Dishwasher(Builder builder)
//    {
//        cost = builder.cost;
//        rpm = builder.rpm;
//        name = builder.name;
//        color = builder.color;
//    }
//
//    public void SetCost( int cost)
//    {
//        this.cost = cost;
//    }
//    public void SetVolume( int volume)
//    {
//        this.volume = volume;
//    }
//    public void SetColor(String color)
//    {
//        this.color = color;
//    }
//    public void SetName(String name)
//    {
//        this.name = name;
//    }
//    public int GetCost()
//    {
//        return this.cost;
//    }
//    public int GetVolume()
//    {
//        return this.volume;
//    }
//    public String GetName()
//    {
//        return this.name;
//    }
//    public String GetColor()
//    {
//        return this.color;
//    }
//    public static final Comparator<Dishwasher> COMPARE_BY_COST = new Comparator<Dishwasher>() {
//        @Override
//        public int compare(Dishwasher lhs, Dishwasher rhs) {
//            return lhs.GetCost() - rhs.GetCost();
//        }
//    };
//    public static final Comparator<Dishwasher> COMPARE_BY_VOLUME = new Comparator<Dishwasher>() {
//        @Override
//        public int compare(Dishwasher lhs, Dishwasher rhs) {
//            return lhs.GetVolume() - rhs.GetVolume();
//        }
//    };
//    @Override
//    public String toString() {
//        return "cost - "+this.cost+"  rpm - "+this.rpm+"  name - "+this.name+"  color - "+this.color;
//    }
//}
public class Dishwasher extends Builder {

    public Dishwasher(String name, int volume, String color, int cost)
    {
        this.name = name;
        this.volume = volume;
        this.color = color;
        this.cost = cost;
    }

    public Dishwasher()
    {
        this.name = null;
        this.volume = 0;
        this.color = null;
        this.cost = 0;
    }
    public void SetCost( int cost)
    {
        this.cost = cost;
    }
    public void SetVolume( int volume)
    {
        this.volume = volume;
    }
    public void SetColor(String color)
    {
        this.color = color;
    }
    public void SetName(String name)
    {
        this.name = name;
    }
    public int GetCost()
    {
        return this.cost;
    }
    public int GetVolume()
    {
        return this.volume;
    }
    public String GetName()
    {
        return this.name;
    }
    public String GetColor()
    {
        return this.color;
    }

    public static final Comparator<Dishwasher> COMPARE_BY_COST = new Comparator<Dishwasher>() {
        @Override
        public int compare(Dishwasher lhs, Dishwasher rhs) {
            return lhs.GetCost() - rhs.GetCost();
        }
    };

    public static final Comparator<Dishwasher> COMPARE_BY_VOLUME = new Comparator<Dishwasher>() {
        @Override
        public int compare(Dishwasher lhs, Dishwasher rhs) {
            return lhs.GetVolume() - rhs.GetVolume();
        }
    };

    @Override
    public String toString() {
        return "cost - "+this.cost+"  volume - "+this.volume+"  name - "+this.name+"  color - "+this.color;
    }
}
