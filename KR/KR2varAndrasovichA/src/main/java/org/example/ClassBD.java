package org.example;
import org.example.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClassBD {
    private List<Student> students = new ArrayList<Student>();
    public ClassBD(List<Student> students){
        super();
        if (Objects.isNull(students)){
            throw new IllegalArgumentException("Can't be created without any student item");
        }
        this.students = new ArrayList<Student>(students);
    }
    public ClassBD(){
        super();
    }
    public  List<Student> getStudents(){
        return students;
    }
//    public static void toFile(ArrayList<Student> setStudents){
//        //String in1 = "D:\\2 курс\\3 семестр\\PP\\KR\\KR2varAndrasovichA\\src\\main\\java\\org\\example\\test2.txt";
//        String outT = "D:\\2 курс\\3 семестр\\PP\\KR\\KR2varAndrasovichA\\src\\main\\java\\org\\example\\rezult2.txt";
//        String outF = "D:\\2 курс\\3 семестр\\PP\\KR\\KR2varAndrasovichA\\src\\main\\java\\org\\example\\rezuncorrect2.txt";
//        try {
//          //  BufferedReader inBuf1 = new BufferedReader(new FileReader(in1));
//            BufferedWriter oBuf1 = new BufferedWriter(new FileWriter(outT));
//            BufferedWriter oBuf2 = new BufferedWriter(new FileWriter(outF));
//
//            String IS;
////            while ((IS = inBuf1.readLine()) != null) {
////                System.out.println(IS);
////                System.out.println("\n");
////            }
//            /*while ((IS = buf1.readLine()) != null) {
//                buf2.write(IS);
//            }*/
//            for (int i = 0; i < setStudents.size(); i++){
//                oBuf1.write( setStudent[i].toString()));
//                Student d = setStudents.get(i);
//                double id = d.id();
//            }
//            oBuf1.write("Correct date:\n");
//            setStudents.forEach(student -> oBuf1.write(student.toString()));
//            oBuf2.write("UNcorrect date\n");
////            for (String s : arr) {
////                buf2.write(s);
////                buf2.write("\n");
////            }
//          //  inBuf1.close();
//            oBuf1.close();
//            oBuf2.close();
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
    public static boolean is_regex_1(String stroka) {
    return stroka.matches("[_!;]+");
}
    public void print(){
        students.forEach(student -> System.out.println(student.toString()));
    }
    public static String strsplit(String mas, String ch) {
        int len = mas.length();
        String s;
        for (int i = 0; i < len; i++) {
            s = mas.substring(i, i + 1);
            if (s.equals(ch)) {
                String premas = mas.substring(0, i);
                String aftermas = mas.substring(i + 1, len);
                mas = premas.concat(aftermas);
                len = mas.length();
            }
        }
        return mas;
    }
    private boolean reg(String mas){
        int len = mas.length();
        String s;
        for (int i = 0; i < len; i++) {
            s = mas.substring(i, i + 1);
            if (s.equals("!") || s.equals("_") || s.equals(";") || s.equals("*")) return true;
        }
        return false;
    }
    public void fromFile(){
        String in1 = "D:\\2 курс\\3 семестр\\PP\\KR\\KR2varAndrasovichA\\src\\main\\java\\org\\example\\test2.txt";
        String outT = "D:\\2 курс\\3 семестр\\PP\\KR\\KR2varAndrasovichA\\src\\main\\java\\org\\example\\rezult2.txt";
        String outF = "D:\\2 курс\\3 семестр\\PP\\KR\\KR2varAndrasovichA\\src\\main\\java\\org\\example\\rezuncorrect2.txt";
        try {
            BufferedReader inBuf1 = new BufferedReader(new FileReader(in1));
            BufferedWriter oBuf1 = new BufferedWriter(new FileWriter(outT));
            BufferedWriter oBuf2 = new BufferedWriter(new FileWriter(outF));

            oBuf1.write("Correct date:\n");
            oBuf2.write("UNcorrect date\n");

            String IS, x, y, z, s, p;
            boolean fl;
            while ((IS = inBuf1.readLine()) != null) {
                System.out.println(IS);
                System.out.println("\n");
                fl = reg(IS);
                if (fl) {
                    oBuf2.write(IS + "\n");
                    continue;
                }
                x = strsplit(IS, "!_;*");
                oBuf1.write(x + "\n");
                System.out.println(x);
                p = x.substring(x.lastIndexOf(" ") + 1);
                s = p.substring(p.lastIndexOf(" ") + 1);
                z = s.substring(s.lastIndexOf(" ")+ 1);
                y = z.substring(z.lastIndexOf(" ") + 1);
                x = y.substring(y.lastIndexOf(" ") + 1);

                Student student = new Student(x, y, z, s, p);
                students.add(students.size(), student);
            }
            inBuf1.close();
            oBuf1.close();
            oBuf2.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
