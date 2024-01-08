//package domain;
//import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.*;
import java.util.regex.*;
import java.util.Scanner;
//import StringBuilder;

public class main_source {
    public static void sprint(String str, String sname) {
        System.out.printf(sname);
        System.out.println(" = ");
        System.out.printf(str);
        System.out.println("\n");
    }
    public static String refra(String mas, String ch, String zamen) {
        int len = mas.length();
        String s;
        for (int i = 0; i < mas.length() - 1; i++) {
            s = mas.substring(i, i + 1);
            if (s.equals(ch)) {
                String premas = mas.substring(0, i);
                String aftermas = mas.substring(i + 1, len);
                mas = String.join(zamen, premas, aftermas);
            }
        }
        return mas;
    }
    public static String strsplit(String mas, String ch) {
        int len = mas.length();
        String s;
        for (int i = 0; i < len; i++) {
            s = mas.substring(i, i + 1);
            if (s.equals(ch)) {
                String premas = mas.substring(0, i);
                String aftermas = mas.substring(i + 1, len);
                //mas = String.join(zamen, premas , aftermas);
                mas = premas.concat(aftermas);
                len = mas.length();
            }
        }
        return mas;
    }
    public static String fromFile(int k) {
        String s1 = "D:\\2 курс\\3 семестр\\PP\\pp2lab\\src\\input.txt";
        String s2 = "D:\\2 курс\\3 семестр\\PP\\pp2lab\\src\\output.txt";
        String str = null;
        try {
            BufferedReader buf1 = new BufferedReader(new FileReader(s1));
            BufferedWriter buf2 = new BufferedWriter(new FileWriter(s2));
            String IS;
            for (int i = 0; i < k; i++){
                if ((IS = buf1.readLine()) != null) {
                    str = IS;
                }
            }
            buf1.close();
            buf2.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return str;
    }
    public static void toFile(ArrayList<String> biarr){
        String s1 = "D:\\2 курс\\3 семестр\\PP\\pp2lab\\src\\input.txt";
        String s2 = "D:\\2 курс\\3 семестр\\PP\\pp2lab\\src\\output.txt";
        try {
            BufferedReader buf1 = new BufferedReader(new FileReader(s1));
            BufferedWriter buf2 = new BufferedWriter(new FileWriter(s2));
            String IS;
            /*while ((IS = buf1.readLine()) != null) {
                buf2.write(IS);
            }*/
            buf2.write("Запись в файл");
            buf2.write("\n");
            for (String s : biarr) {
                buf2.write(s);
                buf2.write("\n");
            }
            buf1.close();
            buf2.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static int n_count(String stroka){
        int count = 0;
        while(-1 != stroka.lastIndexOf(" ")){
            stroka = stroka.substring(stroka.indexOf(" ") + 1);
            ++count;
        }
        return count;
    }
    public static void get_rex(String stroka) {
        int len = stroka.length();
        String s, re;
        for (int i = 0; i < len - 6; i++) {
            s = stroka.substring(i, i + 6);
            if (s.matches("[012345][0123456789][012][012345][0123456789]")) {
                sprint(stroka.substring(i, i + 7), "regex is: ");
            }
        }
    }
    public static boolean is_regex_date(String stroka) {
        return stroka.matches("[0-5][0-9][0-2][0-9][0-5][0-9]");
    }
    public static boolean is_regex_1(String stroka) {
        return stroka.matches("[_!;]+");
    }

    public static void main(String[] args) {
        /*System.out.println("hello world!");
        Formatter fmt = new Formatter();
        fmt.format("Formatting %s is  %d %f", "with Java", 10, 98.6);*/
        String getstr = "", chars = "", res;

        /*String str0 = "0100;001;0100;100000;1;00101;1010;01010;0100;;1;00",
                str1 = "10!10>01100501.71,232100.243,3212010!101.057!01!234.521423",
                str2 = "010! 10 01101.!71,232100>.243,! 321010! 101001!!234.521423",
                razds = ".,>!", res;*/
       /* StringBuilder builder = new StringBuilder();
        sprint(str1, "Str1");
        sprint(str2, "Str2");*/

        getstr = fromFile(1);
        chars = fromFile(2);
        sprint(getstr, "string 1 from file >>");
        sprint(chars, "string 2 from file >>");

        res = getstr;

        sprint(res, "Str1 after delete: ");
        for (int i = 0; i < chars.length(); i++) {
            res = strsplit(res, chars.substring(i, i + 1));
        }

        sprint(res, "Str1 after replace: ");
        res = getstr;
        for (int i = 0; i < chars.length(); i++) {
            res = refra(res, chars.substring(i, i + 1), " ");
        }


        ArrayList<String> biarr;
        ArrayList<String> timeArr;
        biarr = new ArrayList<>();
        timeArr = new ArrayList<>();
        int R = n_count(res);
        String[] twoArr = new String[++R];
        if (0 != R) {
            String thestr;
            for (int i = 0; i < R - 1; i++) {
                thestr = res;
                twoArr[i] = thestr.substring(0, res.indexOf(" "));
                res = res.substring(res.indexOf(" ") + 1);
            }
            twoArr[R - 1] = res;
        }
        for (int i = 0; i < R; i++) {
           if  (6 == twoArr[i].length() && is_regex_date(twoArr[i]))
               biarr.add(twoArr[i]);
           if (is_regex_1(twoArr[i])){
               timeArr.add(twoArr[i]);
           }
        }
        for (int i = 0; i < biarr.size(); i++)
            System.out.println(timeArr.get(i));
        Random r = new Random();
        biarr.replaceAll(s -> s + r.nextInt(10));
        for (String s : biarr) System.out.println(s);
        /*get_rex(res);
        BigInteger[] numbers = new BigInteger[100];
        String str;
        String[] st1 = new String[]{"browser "};
        String[] st2 = new String[]{};*/
        toFile(biarr);
    }
}
