package mergesort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mergesort {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
     File input = new File(args[0]);
        Scanner scanner = new Scanner(input);
        
        while (scanner.hasNextInt())
        {
            list.add(scanner.nextInt());
        }
        mergeSort(0, list.size());
        
        list.stream().forEach((s) -> {
            System.out.print(s + " ");
        });
        System.out.println();
    }
    
    private static void mergeSort(int beg, int end)
    {
        if (end - beg < 2) return;
        
        int mid = (end + beg)/ 2;
        mergeSort(beg, mid);
        mergeSort(mid, end);
        merge(beg,mid,end);
    }
    
    private static void merge(int beg, int mid, int end)
    {
        int i = beg;
        int j = mid;
        int position = 0;
        
        for (int k = beg; k < end; k++)
        {
            if (i < mid && (j >= end || list.get(i) <= list.get(j)))
            {       
                list.add(end+position, list.get(i));
                i++;
                position++;
            }
            else
            {
                list.add(end+position, list.get(j));
                j++;
                position++;
            }
        }
        
        for (int k = beg; k < end; k++)
            list.remove(beg);
    }
    
}
