import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("N-Queens Problem Solver");
        System.out.println("Enter N:");
        int n = scanner.nextInt();

        while (n > 0) {
            Board board = new Board(n);
            List<Solution> solutions = board.findSolutions();
            System.out.println(solutions.size() + " solutions found.");
            // Let's not print everything

            System.out.println("The first 5 solutions");
            solutions.stream().limit(5)
                    .forEach(Solution::print);
            Collections.shuffle(solutions);
            System.out.println("Some other solutions selected randomly");
            solutions.stream().limit(5)
                    .forEach(Solution::print);

            System.out.println("Enter N:");
            n = scanner.nextInt();

        }
    }

}
