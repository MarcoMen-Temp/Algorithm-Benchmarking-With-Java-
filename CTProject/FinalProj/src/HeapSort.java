/**
 * HeapSort class is the fifth sorting algorithm benchmarking
 * Author : Marco Men
 * Computational Thinking & Algorithm Analysis Final Project
 * Last Changed : 07 - October - 2019
 */

// Adapted from: "https://www.w3resource.com/java-exercises/sorting/java-sorting-algorithm-exercise-5.php"


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

// Fifth class being called

public class HeapSort {

    void HeapSort ( int nums[] ) {
        buildheap( nums );
        for (int i = nums.length - 1; i >= 0; i--) {
            exchange( nums, i, 0 );
            heap( nums, i, 0 );
        }
    }

    private void exchange ( int[] nums, int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void heap ( int[] nums, int size, int i ) {
        int left = ((2 * i) + 1);
        int right = ((2 * i) + 2);
        int max = i;

        if ( (left < size) && (nums[left] > nums[i]) ) {
            max = left;
        }

        if ( (right < size) && (nums[right] > nums[max]) ) {
            max = right;
        }

        if ( max != i ) {
            exchange( nums, i, max );
            heap( nums, size, max );
        }
    }

    private void buildheap ( int[] nums ) {
        for (int i = (nums.length / 2) - 1; i >= 0; i--) {
            heap( nums, (nums.length - 1), i );
        }
    }

    public static int[] getRandomArray ( int length ) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        return numbers;
    }

    private static final int WARMUP = 10;

    private static int ITERATIONS = 10;

    // Fifth method being called

    static void heap (  ) {


        HeapSort ob = new HeapSort();

        try {
            PrintStream myconsole = new PrintStream( new FileOutputStream( "Output.txt" ,true) );
            System.setOut( myconsole );
        }

        catch (FileNotFoundException e) {

            System.out.println( e );

        }





        int size[] = new int[] {10, 50, 100, 250, 500, 1000, 2000, 3500, 7000, 10000, 15000, 20000, 25000 };


        System.out.print( "\nHeapSort\t\t" );


        /**
         *    iterations on size array indices
         *
         *    change the length to 10,100,250,500,1000,2000,3500,7000,10000,15000,20000,25000
         */



        for (int j = 0; j < size.length; j++) {
            int width = size[j];


            /**
             *    Adapted from: " https://stackoverflow.com/questions/8378453/java-compute-average-execution-time "
             *
             *    Warm Up test with no timing
             */

            for (int i = 0; i < WARMUP; ++i) {
                ob.HeapSort( getRandomArray( width ) );
            }

            // The real test

            long startTime = System.nanoTime();

            for (int i = 0; i < ITERATIONS; i++) {

                // sorting array using insertion sort in Java
                ob.HeapSort( getRandomArray( width ));

            }

            long endTime = System.nanoTime();


            long elapsedTimeNanos = endTime - startTime;


            double timeElapsedMillis = elapsedTimeNanos / 1000000.0;


            double average = timeElapsedMillis / ITERATIONS;


            // average doubles converted into string - Now separate each element with a tab



            // Format String to 3 decimal places - "https://stackoverflow.com/questions/2538787/how-to-display
            // -an-output-of-float-data-with-2-decimal-places-in-java"

            DecimalFormat df = new DecimalFormat( "0.00#" );

            String str = df.format( average );

            String averages = new StringBuilder(  ).append( str ).toString();




            System.out.print( (averages + "\t") );

        }
    }
}
