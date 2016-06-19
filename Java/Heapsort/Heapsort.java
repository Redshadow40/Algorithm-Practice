package heapsort;

import java.io.*;
import java.util.*;

public class Heapsort {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(args[0]);
        Scanner scanner = new Scanner(input);
        ArrayList<Integer> list = new ArrayList<>();
        
        while (scanner.hasNextInt())
        {
            list.add(scanner.nextInt());
        }
        startSort(list);
    }
    
    public static void startSort(ArrayList<Integer> list)
    {
        createHeap(list);
        
        for (int i = list.size() - 1; i > 0; i--)
        {
            Collections.swap(list, 0, i);
            heapIt(list,0, i);
            list.stream().forEach((s) -> {
                System.out.print(s + " ");
            });
            System.out.println();
        }
        
        list.stream().forEach((s) -> {
            System.out.print(s + " ");
        });
    }
    
    public static void createHeap(ArrayList<Integer> list)
    {
        int size = list.size() - 2;
        
        for (int i = size/2; i >= 0; i--)
            heapIt(list, i, list.size());
        
        list.stream().forEach((s) -> {
            System.out.print(s + " ");
        });
        System.out.println();
    }
    
    public static void heapIt(ArrayList<Integer> list, int i, int size)
    {
        int l = i*2+1;
        int r = l + 1;
        if (l < size && list.get(l) > list.get(i))
        {
            if (r < size && list.get(r) > list.get(l))
            {
                Collections.swap(list,r,i);
                heapIt(list, r, size);
            }
            else
            {
                Collections.swap(list,l,i);
                heapIt(list,l, size);
            }
        }
        else if (r < size && list.get(r) > list.get(i))
        {
            Collections.swap(list,r,i);
            heapIt(list,r, size);
        }
    }
}
