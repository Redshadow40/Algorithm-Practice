package heapsort;

import java.io.*;
import java.util.*;

public class Heapsort {
    //I would implement this entire thing as a package
    //  This way, if you're writing other code in the future, you can just
    //  import the package and use it
    //Also, since this is a class, why not declare the array
    //  as a member rather than pass it to every method?
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(args[0]);
        Scanner scanner = new Scanner(input);
        //What if I wanted to sort floating point numbers, or characters,
        //  or any object that I had the 'less than' operator defined?
        ArrayList<Integer> list = new ArrayList<>();
        
        while (scanner.hasNextInt())
        {
            list.add(scanner.nextInt());
        }
        //Maybe here you should close the file?
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
        //The loop above wraps the body in brackets while the loop below doesn't. Be consistent.
        for (int s: list)
            System.out.print(s + " ");
    }
    
    public static void createHeap(ArrayList<Integer> list)
    {
        int size = list.size() - 2; //This variable is named "size" but it doesnt represent the size of 'list'
        
        for (int i = size/2; i >= 0; i--)
            heapIt(list, i, list.size());
        
        for (int i = 0; i < size + 2; i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
    
    public static void heapIt(ArrayList<Integer> list, int i, int size)
    {
        //I'm not an expert in Java, but is it better if methods like these are private?
        //  Q's argument: "Everything should start as private. If you're going to make it public, you should have a reason."
        int l = i*2+1; //Use more descriptive variable names. Ex: 'leftChildPosition'
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
        //The above code has the same code in 3 places
        //  Consider making the following change:
        //=======================BEFORE=======================
        /*if (a) {
            x(1,true);
            y(1,false);
            z(1,true);
        } else if (b) {
            if (c) {
                x(1,true);
                y(1,true);
                z(1,false);
            } else {
                x(1,false);
                y(1,true);
                z(1,true);
            }
        }*/
        //========================AFTER=======================
        /*boolean xArg = true;
        boolean yArg = true;
        boolean zArg = true;
        if (a) {
            yArg = false;
        } else if (b) {
            if (c) {
                zArg = false;
            } else {
                xArg = false;
            }
        }
        x(1,xArg);
        y(1,yArg);
        z(1,zArg);*/
    }
    
    public static void Switch(ArrayList<Integer> list, int a, int b)
    {
        //Does Java not provide a swap method for their containers?
        //Also, this method's first letter is capitalized, the others arent
        int tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }
}
