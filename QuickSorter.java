import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.lang.System;

public class QuickSorter
{
    private static ArrayList<Integer> numbers = new ArrayList<>();

    public static ArrayList<Integer> generateRandomList(int size) throws IllegalArgumentException
    {
        if (size < 0)
        {
            throw new IllegalArgumentException("Invalid size");
        }

        if (numbers.size() != 0)
        {
            numbers.clear();
        }

        Random randomNumber = new Random();

        for (int i = 0; i < size; i++)
        {
            numbers.add(randomNumber.nextInt()); // adds a random number that is in the range of the int data type
        }

        return numbers; // returns the unsorted array of random numbers
    }

    public enum PivotStrategy
    {
        FIRST_ELEMENT,
        RANDOM_ELEMENT,
        MEDIAN_OF_THREE_RANDOM_ELEMENTS,
        MEDIAN_OF_THREE_ELEMENTS
    }

    public static <E extends Comparable<E>> Duration timedQuickSort(ArrayList<E> list, PivotStrategy pivotStrategy) throws NullPointerException
    {
        if (pivotStrategy == PivotStrategy.FIRST_ELEMENT)
        {
            LocalDateTime startTime = LocalDateTime.now();

            quickSortFE(list); // quick sort with first element method

            LocalDateTime endTime = LocalDateTime.now();

            Duration elapsedTime = Duration.between(startTime, endTime); // time it took to sort array w this pivot strat

            return elapsedTime;
        }
        else if (pivotStrategy == PivotStrategy.RANDOM_ELEMENT)
        {
            LocalDateTime startTime = LocalDateTime.now();

            quickSortRE(list); // quick sort with random element method

            LocalDateTime endTime = LocalDateTime.now();

            Duration elapsedTime = Duration.between(startTime, endTime); // time it took to sort array w this pivot strat

            return elapsedTime;
        }
        else if (pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS)
        {
            LocalDateTime startTime = LocalDateTime.now();

            quickSortM3RE(list); // quick sort with median of 3 random elements method

            LocalDateTime endTime = LocalDateTime.now();

            Duration elapsedTime = Duration.between(startTime, endTime); // time it took to sort array w this pivot strat

            return elapsedTime;
        }
        else if (pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_ELEMENTS)
        {
            LocalDateTime startTime = LocalDateTime.now();

            quickSortM3E(list); // quick sort with median 3 elements method

            LocalDateTime endTime = LocalDateTime.now();

            Duration elapsedTime = Duration.between(startTime, endTime); // time it took to sort array w this pivot strat

            return elapsedTime;
        }
        else
        {
            throw new NullPointerException();
        }
    }

    private static <E extends Comparable<E>> void quickSortFE(ArrayList<E> list)
    {
        if (list.size() > 1) // enough numbers to sort/base case
        {
            E pivot = list.get(0); // get first element

            // to split array based on pivot
            ArrayList<E> less = new ArrayList<>();
            ArrayList<E> greater = new ArrayList<>();
            ArrayList<E> equal = new ArrayList<>();

            for (int i = 0; i < list.size(); i++)
            {
                if (pivot.compareTo(list.get(i)) < 0) // if element greater than pivot element
                {
                    greater.add(list.get(i));
                }
                else if (pivot.compareTo(list.get(i)) == 0) // if element equals pivot element
                {
                    equal.add(list.get(i));
                }
                else // if element less than pivot element
                {
                    less.add(list.get(i));
                }
            }

            // recursively call methods
            quickSortFE(greater);
            quickSortFE(less);

            // add in sorted array
            list.clear();
            list.addAll(less);
            list.addAll(equal);
            list.addAll(greater);
        }
    }

    private static <E extends Comparable<E>> void quickSortRE(ArrayList<E> list)
    {
        if (list.size() > 1) // enough numbers to sort/base case
        {
            // get a random index
            Random rand = new Random();
            int randomIndex = 0 + rand.nextInt(((list.size() - 1) - 0) + 1);

            E pivot = list.get(randomIndex); // get random element

            // to split array based on pivot
            ArrayList<E> less = new ArrayList<>();
            ArrayList<E> greater = new ArrayList<>();
            ArrayList<E> equal = new ArrayList<>();

            for (int i = 0; i < list.size(); i++)
            {
                if (pivot.compareTo(list.get(i)) < 0) // if element greater than pivot element
                {
                    greater.add(list.get(i));
                }
                else if (pivot.compareTo(list.get(i)) == 0) // if element equals pivot element
                {
                    equal.add(list.get(i));
                }
                else // if element less than pivot element
                {
                    less.add(list.get(i));
                }
            }

            // recursively call methods
            quickSortFE(greater);
            quickSortFE(less);

            // add in sorted array
            list.clear();
            list.addAll(less);
            list.addAll(equal);
            list.addAll(greater);
        }
    }
    private static <E extends Comparable<E>> void quickSortM3RE(ArrayList<E> list)
    {
        if (list.size() > 1) // enough numbers to sort/base case
        {
            // get three random indexes of array
            Random rand = new Random();
            ArrayList<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < 3; i++)
            {
                indexes.add(0 + rand.nextInt(((list.size() - 1) - 0) + 1));
            }
            quickSortRE(indexes); // sort array
            //System.out.println(indexes);

            E pivot = list.get(indexes.get(1)); // get median of the 3 random elements

            // to split array based on pivot
            ArrayList<E> less = new ArrayList<>();
            ArrayList<E> greater = new ArrayList<>();
            ArrayList<E> equal = new ArrayList<>();

            for (int i = 0; i < list.size(); i++)
            {
                if (pivot.compareTo(list.get(i)) < 0) // if element greater than pivot element
                {
                    greater.add(list.get(i));
                }
                else if (pivot.compareTo(list.get(i)) == 0) // if element equals pivot element
                {
                    equal.add(list.get(i));
                }
                else // if element less than pivot element
                {
                    less.add(list.get(i));
                }
            }

            // recursively call methods
            quickSortFE(greater);
            quickSortFE(less);

            // add in sorted array
            list.clear();
            list.addAll(less);
            list.addAll(equal);
            list.addAll(greater);
        }
    }
    private static <E extends Comparable<E>> void quickSortM3E(ArrayList<E> list)
    {
        if (list.size() > 1) // enough numbers to sort/base case
        {
            // get start, middle, last elements
            Random rand = new Random();
            ArrayList<E> indexes = new ArrayList<>();
            indexes.add(list.get(0));
            indexes.add(list.get(list.size() / 2));
            indexes.add(list.get(list.size() - 1));

            quickSortRE(indexes); // sort 3 elements
            //System.out.println(indexes);

            E pivot = indexes.get(1); // get median of the 3 elements

            // to split array based on pivot
            ArrayList<E> less = new ArrayList<>();
            ArrayList<E> greater = new ArrayList<>();
            ArrayList<E> equal = new ArrayList<>();

            for (int i = 0; i < list.size(); i++)
            {
                if (pivot.compareTo(list.get(i)) < 0) // if element greater than pivot element
                {
                    greater.add(list.get(i));
                }
                else if (pivot.compareTo(list.get(i)) == 0) // if element equals pivot element
                {
                    equal.add(list.get(i));
                }
                else // if element less than pivot element
                {
                    less.add(list.get(i));
                }
            }

            // recursively call methods
            quickSortFE(greater);
            quickSortFE(less);

            // add in sorted array
            list.clear();
            list.addAll(less);
            list.addAll(equal);
            list.addAll(greater);
        }
    }

    public static <E extends Comparable<E>> Duration QuickSort(ArrayList<E> list) throws NullPointerException
    {
        LocalDateTime startTime = LocalDateTime.now(); // get current time to record

        if (list.size() > 1) // enough numbers to sort/base case
        {

            /*E temp = list.get(list.size()-1);
            list.set((list.size()-1), pivot);
            list.set(pivotIndex, temp);*/

            int index1 = 0;
            int index2 = list.size() - 1;
            QuickSortIP(list, index1, index2); // quick sort in place array
        }

        LocalDateTime endTime = LocalDateTime.now();

        Duration elapsedTime = Duration.between(startTime, endTime); // time it took to sort array w QS in place method

        return elapsedTime;
    }

    private static <E extends Comparable<E>> void QuickSortIP(ArrayList<E> list, int index1, int index2)
    {
        if (index1 + 20 <= index2) // stop when indexes cross
        {
            int i1 = index1, i2 = index2 - 1;

            // add start, middle, end elements to array
            Random rand = new Random();
            ArrayList<E> indexes = new ArrayList<>();
            indexes.add(list.get(0));
            indexes.add(list.get(list.size() / 2));
            indexes.add(list.get(list.size() - 1));

            quickSortRE(indexes); // sort 3 elements
            //System.out.println(indexes);

            E pivot = indexes.get(1); // find the median of the 3 elements
            int pivotIndex = list.indexOf(pivot);

            while (i1 < i2)
            {
                while (list.get(i1).compareTo(pivot) < 0) // skip over elements that are less than the pivot
                {
                    i1++;
                }
                while (list.get(i2).compareTo(pivot) > 0) // skip over elements that are greater than the pivot
                {
                    i2--;
                }
                if (i1 < i2)
                {
                    // find both elements that are smaller and bigger than pivot so can be swap
                    E temp = list.get(i1);
                    list.set((i1), (list.get(i2)));
                    list.set(i2, temp);
                }
            }
            // swap pivot w i1 index element
            E temp = list.get(i1);
            list.set((i1), (list.get(index2 - 1)));
            list.set(index2 - 1, temp);

            // sort subarrays
            QuickSortIP(list, index1, i1 - 1);
            QuickSortIP(list, i1 + 1, index2);
        }
        else
        {
            insertionSort(list, index1, index2); // for small array use insertion sort methodology
        }
    }

    private static <E extends Comparable<E>> void insertionSort(ArrayList<E> list, int left, int right)
    {
        // from slides
        int j;
        for (int i = 1; i < list.size(); i++)
        {
            E temp = list.get(i);
            for (j = i; (j > 0) && (temp.compareTo(list.get(j-1))) < 0; j--)
            {
                list.set(j, list.get(j-1));
            }
            list.set(j, temp);
        }
    }

    public static ArrayList<Integer> returnArray()
    {
        return numbers;
        /*for (int i = 0; i < numbers.size(); i++)
        {
            return(numbers.get(i) + " ");
        }
        System.out.println();*/
    }
}
