import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            int arraySize = Integer.parseInt(args[0]); // array size

            // for writing to record file
            File record_file = new File(args[1]);
            PrintWriter out;
            out = new PrintWriter(record_file);

            // for writing to unsorted file
            File unsorted_file = new File(args[2]);
            PrintWriter out2;
            out2 = new PrintWriter(unsorted_file);

            // for writing to sorted file
            File sorted_file = new File(args[3]);
            PrintWriter out3;
            out3 = new PrintWriter(sorted_file);

            ArrayList<Integer> numbers;

            out.println("Array Size = " + arraySize); // writing array size

            // writing unnsorted and sorted array for first element
            numbers = (QuickSorter.generateRandomList(arraySize));
            out2.println(numbers);
            out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.FIRST_ELEMENT));
            out3.println(QuickSorter.returnArray());

            // writing unnsorted and sorted array for random element
            numbers = (QuickSorter.generateRandomList(arraySize));
            out2.println(numbers);
            out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.RANDOM_ELEMENT));
            out3.println(QuickSorter.returnArray());

            // writing unnsorted and sorted array for median of 3 random elements
            numbers = (QuickSorter.generateRandomList(arraySize));
            out2.println(numbers);
            out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS));
            out3.println(QuickSorter.returnArray());

            // writing unnsorted and sorted array for median of 3 elements(start, middle, end)
            numbers = (QuickSorter.generateRandomList(arraySize));
            out2.println(numbers);
            out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS));
            out3.println(QuickSorter.returnArray());

            // writing unnsorted and sorted array for in place
            numbers = (QuickSorter.generateRandomList(arraySize));
            out2.println(numbers);
            out.println(QuickSorter.QuickSort(numbers));
            out3.println(QuickSorter.returnArray());

            out.close();
            out2.close();
            out3.close();

        }
        catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        /*ArrayList<Integer> numbers;

        numbers = (QuickSorter.generateRandomList(5));
        System.out.println(numbers);
        System.out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.FIRST_ELEMENT));
        QuickSorter.printArray();

        numbers = (QuickSorter.generateRandomList(5));
        System.out.println(numbers);
        System.out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.RANDOM_ELEMENT));
        QuickSorter.printArray();

        numbers = (QuickSorter.generateRandomList(5));
        System.out.println(numbers);
        System.out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS));
        QuickSorter.printArray();

        numbers = (QuickSorter.generateRandomList(5));
        System.out.println(numbers);
        System.out.println(QuickSorter.timedQuickSort(numbers, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS));
        QuickSorter.printArray();

        System.out.println();
        System.out.println();

        numbers = (QuickSorter.generateRandomList(5));
        System.out.println(numbers);
        System.out.println(QuickSorter.QuickSort(numbers));
        QuickSorter.printArray();*/

    }
}
