package com.company;

import java.util.Scanner;

public class Main {

    public static List<Abon> list = new List<>();

    public static void main(String[] args) {
        System.out.println("Введите ФИО и номера телефонов. Введите 0, чтобы завершить ввод");
        Scanner scan = new Scanner(System.in);
        String in;
        do {
            in = scan.nextLine();
            if (in.equals("0")) break;
            String[] a = in.split("\\s+");
            String fio = a[0] + " " + a[1] + " " + a[2];
            list.add(new Abon(fio, Integer.parseInt(a[3])));
        } while (true);
        do {
            System.out.println("Введите\n1 - поиск по фамилии\n2 - по номеру\n0 - завершить программу");
            String inn = scan.nextLine();
            if (inn.equals("1")) list.byFio();
            if (inn.equals("2")) list.byNum();
            if (inn.equals("0")) System.exit(0);
        } while (true);
    }
}
