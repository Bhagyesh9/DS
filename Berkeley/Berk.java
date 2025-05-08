import java.util.*;

public class Berk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of processes (including coordinator)
        System.out.print("Enter number of processes (including coordinator): ");
        int n = sc.nextInt();

        // Times of all processes (in milliseconds or seconds as per use case)
        int[] times = new int[n];
        System.out.println("Enter clock time of each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + i + " time: ");
            times[i] = sc.nextInt();
        }

        // Assume process 0 is the coordinator
        int coordinatorTime = times[0];
        int[] timeDiffs = new int[n];
        int totalDiff = 0;

        // Calculate time differences (skip coordinator from diff sum)
        for (int i = 0; i < n; i++) {
            timeDiffs[i] = times[i] - coordinatorTime;
            if (i != 0) {
                totalDiff += timeDiffs[i];
            }
        }

        // Calculate average (excluding coordinator)
        int avgDiff = totalDiff / (n - 1);
        System.out.println("\nAverage Time Difference (excluding coordinator): " + avgDiff);

        // Adjust all times
        System.out.println("\nNew Synchronized Times:");
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                times[i] += avgDiff;
            } else {
                times[i] += (avgDiff - timeDiffs[i]);
            }
            System.out.println("Process " + i + ": " + times[i]);
        }
    }
}
