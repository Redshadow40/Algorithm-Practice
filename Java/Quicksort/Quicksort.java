
package quicksort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Quicksort {
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(args[0]);
        Scanner scanner = new Scanner(input);
        
        while (scanner.hasNextInt())
        {
            list.add(scanner.nextInt());
        }
        quickSort(0 , list.size() - 1);
    }
    
    private static void quickSort(int lower, int upper)
    {
        int left = lower;
        int right = upper;
        int pivot = list.get((int)((left + right)/2));

        while (left < right)
        {
            while (list.get(left) < pivot)
                left++;
            while (list.get(right) > pivot)
                right--;
            
            if (left < right)
                if (list.get(left).equals(list.get(right)))
                    left++;
                else
                    Collections.swap(list, left, right);          
        }
        
        list.stream().forEach((s) -> {
            System.out.print(s + " ");
        });
        System.out.println();
        
        if (lower < left - 1)
            quickSort(lower, left - 1);
        if (left + 1 < upper)
            quickSort(left + 1, upper);        
    }
    
}
