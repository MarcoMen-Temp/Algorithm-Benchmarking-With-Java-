/**
 * Selection class is the second sorting algorithm benchmarking
 * Author : Marco Men
 * Computational Thinking & Algorithm Analysis Final Project
 * Last Changed : 07 - October - 2019
 */


// Java program for implementation of Selection Sort

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

public class Selection {


    public static int[] getRandomArray ( int length ) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        return numbers;
    }


    void sort ( int arr[] ) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if ( arr[j] < arr[min_idx] )
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array
    void printArray ( int arr[] ) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print( arr[i] + " " );
        System.out.println();
    }


    private static final int WARMUP = 10;

    private static int ITERATIONS = 10;

    // Driver code to test above
    static void select ( ) {

        try {
            // FileOutputStream = append: true as oppose to File(NO APPEND)
            PrintStream myconsole = new PrintStream( new FileOutputStream( "Output.txt", true ) );
            System.setOut( myconsole );
        } catch (FileNotFoundException e) {

            System.out.println( e.toString() );

        }


        int size[] = new int[] {10, 50, 100, 250, 500, 1000, 2000, 3500, 7000, 10000, 15000, 20000, 25000 };
        System.out.print( "\nSelectionSort\t" );


        // iterations on size array indices
        for (int j = 0; j < size.length; j++) {
            int width = size[j];


            // change the length to 10,50,100,250,500,1000,2000,3500,7000,10000,15000,20000,25000



            /**
             *    Adapted from: " https://stackoverflow.com/questions/8378453/java-compute-average-execution-time "
             *
             *    Warm Up test with no timing
             */

            for (int i = 0; i < WARMUP; ++i) {

                Selection ob = new Selection();
                ob.sort( getRandomArray( width ) );
            }

            // The real test


            long startTime = System.nanoTime();

            for (int i = 0; i < ITERATIONS; i++) {


                // sorting array using insertion sort in Java
                Selection ob = new Selection();
                ob.sort( getRandomArray( width ) );

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



            String averages = new StringBuilder().append( str ).toString();


            System.out.print( (averages + "\t") );
        }

    }
}


