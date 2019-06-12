/**
 * BucketSort class is the third sorting algorithm benchmarking
 * Author : Marco Men
 * Computational Thinking & Algorithm Analysis Final Project
 * Last Changed : 07 - October - 2019
 */

// Adapted from : "https://www.w3resource.com/java-exercises/sorting/java-sorting-algorithm-exercise-19.php"


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

// Third class being called


public class BucketSort {
    static int[] sort ( int[] nums, int max_value ) {
        // Bucket Sort
        int[] Bucket = new int[max_value + 1];
        int[] sorted_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            Bucket[nums[i]]++;
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_nums[outPos++] = i;
        return sorted_nums;
    }



    static int max_value ( int[] nums ) {
        int max_value = 0;
        for (int i = 0; i < nums.length; i++)
            if ( nums[i] > max_value )
                max_value = nums[i];
        return max_value;
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

    // Third method to be called
    static void bucket ( ) {

        try {
            PrintStream myconsole = new PrintStream( new FileOutputStream( "Output.txt",true ) );
            System.setOut( myconsole );
        }

        catch (FileNotFoundException e) {

            System.out.println( e );

        }



        int size[] = new int[] {10, 50, 100, 250, 500, 1000, 2000, 3500, 7000, 10000, 15000, 20000, 25000 };


        System.out.print( "\nBucketSort\t\t" );



        /**
         *    iterations on size array indices
         *
         *    change the length to 10,100,250,500,1000,2000,3500,7000,10000,15000,20000,25000
         */


        for (int j = 0; j < size.length; j++) {
            int width = size[j];



            int[] randomOrder = getRandomArray( width );
            int max_value = max_value( (randomOrder) );


            /**
             *    Adapted from: " https://stackoverflow.com/questions/8378453/java-compute-average-execution-time "
             *
             *    Warm Up test with no timing
             */


            for (int i = 0; i < WARMUP; ++i) {
                sort( randomOrder, max_value);
            }

            // The real test

            long startTime = System.nanoTime();

            for (int i = 0; i < ITERATIONS; i++) {

                // sorting array using insertion sort in Java
                sort( randomOrder, max_value );

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
