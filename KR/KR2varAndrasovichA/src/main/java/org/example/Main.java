package org.example;
import javax.swing.*;
import java.util.concurrent.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main extends JFrame{
//    void set(ClassBD classBD){
//        Array array[] = {3, };
//        JTable table3 = new JTable(classBD, header);
//        // Размещение таблиц в панели с блочным расположением
//        Box contents = new Box(BoxLayout.Y_AXIS);
//     //   contents.add(new JScrollPane(table1));
//     / /  contents.add(new JScrollPane(table2));
//
//        // Настройка таблицы table3 - цвет фона, цвет выделения
//        table3.setForeground(Color.red);
//        table3.setSelectionForeground(Color.yellow);
//        table3.setSelectionBackground(Color.blue);
//        // Скрытие сетки таблицы
//        table3.setShowGrid(false);
//        // contents.add(new JScrollPane(table3));
//        contents.add(table3);
//        // Вывод окна на экран
//        setContentPane(contents);
//        setSize(500, 400);
//        setVisible(true);
//    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        ClassBD classBD = new ClassBD();
        ClassBD classA = new ClassBD();
            lFrame frame = new lFrame("Hello Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setVisible(true);
        classBD.fromFile();
        classBD.print();
        Student student = new Student("F", "I" ," O", "3.3", 32847);
        classBD.getStudents();
    }
}