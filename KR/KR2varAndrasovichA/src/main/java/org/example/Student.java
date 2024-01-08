package org.example;

public class Student implements InterfBD{
    Student(String nameF, String nameI, String nameO, String score, String id){
        this.nameF = nameF; this.nameI = nameI; this.nameO = nameO;
        this.score = score; this.id = id;
    }
    @Override
    public String nameF(){
        return  nameF;
    }
    @Override
    public String nameI(){
        return  nameI;
    }
    @Override
    public String nameO(){
        return  nameO;
    }
    @Override
    public String score(){
        return  score;
    }

    @Override
    public String id(){
        return id;
    }
    @Override
    public String toString(){
        return /*(!nameF.isEmpty() &&!nameI.isEmpty() && !nameO.isEmpty()) ?*/
       "[Student: FIO: " + nameF + " " + nameI + " " + nameO + ", score: " + score + ", id: " + id + "]" /*: "Empty"*/;
    }
    private String nameF;
    private String nameI;
    private String nameO;
    private String score;
    private String id;
    public void setF(String nameF){
        this.nameF = nameF;
    }
    public void setI(String nameI){
        this.nameI = nameI;
    }
    public void setO(String nameO){
        this.nameO = nameO;
    }
    public void setScore(String score){
        this.score = score;
    }
    public void setId(String id){
        this.id = id;
    }



}
