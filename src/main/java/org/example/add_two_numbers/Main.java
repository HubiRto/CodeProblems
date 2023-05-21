package org.example.add_two_numbers;

public class Main {
    public static void main(String[] args) {
        int[] tab0 = {9,9,9,9,9,9,9};
        int[] tab1 = {9,9,9,9};

        long start = System.currentTimeMillis();
        int[] result = addTwoNumbers(tab0, tab1);
        long end = System.currentTimeMillis() - start;

        show(end, result);
    }
    public static int[] addTwoNumbers(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        int[] tab = new int[n + 1];
        for(int i = 0; i < n; i++){
            int aa = a.length > i ? a[i] : 0;
            int bb = b.length > i ? b[i] : 0;
            int num = aa + bb + tab[i];
            if(num > 9){
                tab[i + 1] = 1;
                tab[i] = num - 10;
            }else {
                tab[i] = num;
            }
        }
        if(tab[n] == 0){
            int[] tabTemp = tab;
            tab = new int[n];
            System.arraycopy(tabTemp, 0, tab, 0, n);
        }
        return tab;
    }

    public static void show(long end, int[] result) {
        if(result == null) return;
        System.out.println("Czas wykonania algorytmu: " + end + " ms");
        System.out.println("Wynik: [" + showTab(result) + "]\n");
    }

    public static String showTab(int[] tab){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < tab.length; i++){
            if(i == 0) s.append(tab[i]);
            else s.append(",").append(tab[i]);
        }
        return s.toString();
    }
}
