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
            Switch(list, 0, i);
            heapIt(list,0, i - 1);
        }
        
        for (int s: list)
            System.out.print(s + " ");
    }
    
    public static void createHeap(ArrayList<Integer> list)
    {
        int size = list.size() - 2;
        
        for (int i = size/2; i >= 0; i--)
            heapIt(list, i, list.size());
        
        for (int i = 0; i < size + 2; i++)
            System.out.print(list.get(i) + " ");
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
                Switch(list,r,i);
                heapIt(list, r, size);
            }
            else
            {
                Switch(list,l,i);
                heapIt(list,l, size);
            }
        }
        else if (r < size && list.get(r) > list.get(i))
        {
            Switch(list,r,i);
            heapIt(list,r, size);
        }
    }
    
    public static void Switch(ArrayList<Integer> list, int a, int b)
    {
        int tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }
}
