package insertionsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Insertionsort {
    public static void main(String[] args) throws FileNotFoundException {
       File input = new File(args[0]);
        Scanner scanner = new Scanner(input);
        ArrayList<Integer> list = new ArrayList<>();
        
        while (scanner.hasNextInt())
        {
            list.add(scanner.nextInt());
        }
        insertionSort(list);
        
        list.stream().forEach((s) -> {
            System.out.print(s + " ");
        });
        System.out.println();
    }
    
    private static void insertionSort(ArrayList<Integer> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            int j = i;
            while (j > 0 && list.get(j) < list.get(j-1))
            {
                Collections.swap(list, j, j - 1);
                j--;
            }
        }
    }
}
