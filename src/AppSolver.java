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

            for (Solution solution : solutions) {
                solution.print();
            }

            System.out.println("Enter N:");
            n = scanner.nextInt();

        }
    }

}
