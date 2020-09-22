package com.company;

import java.util.Scanner;

public class List<K> {

    private int size = 0;
    private Node<K> head = null;

    private class Node<K> {
        Abon data;
        Node<K> next;

        public Node(Abon data, Node<K> next) {
            this.data = data;
            this.next = next;
        }
    }


    public int size() {
        return size;
    }


    public void add(Abon elem) {
        if (size() == 0) {
            head = new Node<>(elem, null);
        } else {
            int i;
            Node<K> trav;
            for (i = 0, trav = head; i < size-1; i++) {
                if (cmp(trav.data.getFio(), elem.getFio()) && cmp(elem.getFio(), trav.next.data.getFio())) {
                    trav.next = new Node<>(elem, trav.next.next);
                    return;
                }
                trav = trav.next;
            }
            trav.next = new Node<>(elem, head);
        }
        size++;
    }



    public Abon get(int index) {
        int i;
        Node<K> temp;
        for (i = 0, temp = head; i != index; i++)
            temp = temp.next;

        return temp.data;
    }





    public boolean remove(int index) {
        if (index>size-1){return false;}




        if (index==0) {
            head = head.next;
            --size;
            if (size() == 0) {head = null;}
            return true;

        }
        if (index==size-1) {
            int i;
            Node<K> trav;
            for (i = 0, trav = head; i < index; i++)
                trav = trav.next;
            trav.next = null;
            size--;
            if (size() == 0) head = null;
            return true;
        }

        int i;
        Node<K> trav;
        for (i = 1, trav = head; i < index; i++)
            trav = trav.next;
        trav.next=trav.next.next;
        trav.next.next=null;
        --size;
        return true;
    }

    public void byFio(){
        System.out.println("Введите фамилию.");
        Scanner scanner=new Scanner(System.in);
        String sur=scanner.nextLine();
        Node<K> temp=head;
        boolean exist=false;
        //System.out.println(temp.data.getFio().substring(0,sur.length()));
        for (int i=0;i<size;i++){
            if (sur.equals(temp.data.getFio().substring(0,sur.length()))){
                System.out.println(temp.data.getFio()+" "+temp.data.getNumber());
                exist=true;
            }
            temp=temp.next;
        }
        if (!exist) System.out.println("Абонентов с такой фамилией нет.");
    }

    public void byNum(){
        System.out.println("Введите номер.");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        Node<K> temp=head;
        for (int i=0;i<size;i++){
            if (temp.data.getNumber()==num){
                System.out.println(temp.data.getFio()+" "+num);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Абонента с таким номером не существует.");
    }

    private boolean cmp(String s1, String s2){
        int len;
        if (s1.length()>s2.length()){
            len=s2.length();
        }else {
            len=s1.length();
        }
        for (int i=0;i<len;i++){
            while (s1.charAt(i)==s2.charAt(i)) i++;
            if (s1.charAt(i)>s2.charAt(i)) return false;
        }
        return true;
    }

}
