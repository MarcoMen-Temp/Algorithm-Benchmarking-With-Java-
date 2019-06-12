/**
 * ShellSort class is the fourth sorting algorithm benchmarking
 * Author : Marco Men
 * Computational Thinking & Algorithm Analysis Final Project
 * Last Changed : 07 - October - 2019

 Adapted from:"https://www.w3resource.com/java-exercises/sorting/java-sorting-algorithm-exercise-16.php"
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

// Sixth class to be called

public class ShellSort {
    public static void shell(int[] a) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                int temp = a[i];
                while (j >= increment && a[j - increment] > temp) {
                    a[j] = a[j - increment];
                    j = j - increment;
                }
                a[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }


    public static int[] getRandomArray(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        return numbers;
    }


    private static final int WARMUP = 10;

    private static int ITERATIONS = 10;



    // Sixth method to be called

    static void shell( ) {

        ShellSort ob = new ShellSort();

         try {
            PrintStream myconsole = new PrintStream( new FileOutputStream( "Output.txt",true ) );
            System.setOut( myconsole );
        }

        catch (FileNotFoundException e) {

            System.out.println( e );

        }

        int size[] = new int[] {10, 50, 100, 250, 500, 1000, 2000, 3500, 7000, 10000, 15000, 20000, 25000 };


        System.out.print( "\nShellSort\t\t" );


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
                ob.shell( getRandomArray( width ) );
            }

            // The real test

            long startTime = System.nanoTime();

            for (int i = 0; i < ITERATIONS; i++) {

                // sorting array using insertion sort in Java
                ob.shell( getRandomArray( width ));

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

