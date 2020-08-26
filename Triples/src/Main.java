import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int elementsCount = scanner.nextInt();
        int triplesCount = countTriples(elementsCount, scanner);
        System.out.println(triplesCount);
    }

    private static int countTriples(int elementsCount, Scanner scanner) {
        int triplesCount = 0;
        if (elementsCount < 3) {
            for (int i = 0; i < elementsCount; i++) {
                scanner.nextInt();
            }
            return 0;
        }

        int[] tripleOrNotTriple = new int[3];


        for (int i = 0; i < tripleOrNotTriple.length; i++) {
            tripleOrNotTriple[i] = scanner.nextInt();
        }

        if (isTriple(tripleOrNotTriple)) {
            triplesCount++;
        }

        for (int i = 3; i < elementsCount; i++) {
            tripleOrNotTriple[0] = tripleOrNotTriple[1];
            tripleOrNotTriple[1] = tripleOrNotTriple[2];
            tripleOrNotTriple[2] = scanner.nextInt();
            if (isTriple(tripleOrNotTriple)) {
                triplesCount++;
            }
        }
        return triplesCount;
    }

    private static boolean isTriple(int[] tripleOrNotTriple) {
        return (tripleOrNotTriple[0] == tripleOrNotTriple[1] - 1) &&
                (tripleOrNotTriple[1] == tripleOrNotTriple[2] - 1);
    }
}