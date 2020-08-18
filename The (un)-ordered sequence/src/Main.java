import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int previous;
        boolean ascending = true;
        boolean sorted = true;

        int current = scanner.nextInt();
        int next = scanner.nextInt();

        if (next == 0) {
            System.out.println(true);
            return;
        }

        if (current > next) {
            ascending = false;
        }
        previous = next;

        while (true) {
            current = scanner.nextInt();
            if (current == 0) {
                break;
            }

            if (ascending) {
                if (previous <= current) {
                    previous = current;
                    continue;
                }
            } else {
                if (previous >= current) {
                    previous = current;
                    continue;
                }
            }
            sorted = false;
            break;
        }
        System.out.println(sorted);
    }
}