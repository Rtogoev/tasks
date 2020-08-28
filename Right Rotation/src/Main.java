import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// возможны 2 реализации.
// 1) больше потребляет памяти, но работает быстро:

// вычисляется число элементов для переноса влево и вправо, для меньшего выделяется массив.
// далее элементы, которых больше, один шагом каждый сразу переходят на свое финальное место в одном цикле.
// после этого элементы, которых меньше, сразу копируются
// из массива-передержки в свои финальные позиции в результирующем массиве.

// 2) медленнее, но меньше потребляет памяти

// здесь реализованна 2)
class Main {
    public static void main(String[] args) throws IOException {
        // put your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] stringDigits = reader.readLine().split(" ");
        int numberOfRotations = Integer.parseInt(reader.readLine());

        int[] array = new int[stringDigits.length];
        for (int i = 0; i < stringDigits.length; i++) {
            array[i] = Integer.parseInt(stringDigits[i]);
        }

        // futureIndexOfLastMovedLeftElement = number of elements,
        // that will be moved left (to the beginning of array), minus 1
        int futureIndexOfLastMovedLeftElement = countFutureIndexOfLastMovedLeftElement(numberOfRotations, array.length);
        int currentIndexOfLastMovedLeftElement = array.length - 1;

        // this for-statement runs n times, n = number of elements, that will be moved left (to the beginning of array)
        for (int delta = futureIndexOfLastMovedLeftElement; delta >= 0; delta--) {

            // тут вопрос, что больше изначально. В зависимости от ситуации...
            int futureIndexOfCurrentMovedLeftElement = Math.abs(delta - futureIndexOfLastMovedLeftElement);
            int indexOfCurrentMovedLeftElement = currentIndexOfLastMovedLeftElement - delta;
            int valueOfCurrentMovedLeftElement = array[indexOfCurrentMovedLeftElement];

            // this for-statement runs m times, m - number of elements,
            // that will be moved right (to the ending of array)
//            for (
//                    int indexOfCurrentMovedRightElement = indexOfCurrentMovedLeftElement - 1;
//                    indexOfCurrentMovedRightElement >= futureIndexOfCurrentMovedLeftElement;
//                    indexOfCurrentMovedRightElement--
//            ) {
//                array[indexOfCurrentMovedRightElement + 1] = array[indexOfCurrentMovedRightElement];
//            }
            if (indexOfCurrentMovedLeftElement - futureIndexOfCurrentMovedLeftElement >= 0) {
                System.arraycopy(
                        array,
                        futureIndexOfCurrentMovedLeftElement,
                        array,
                        futureIndexOfCurrentMovedLeftElement + 1,
                        indexOfCurrentMovedLeftElement - futureIndexOfCurrentMovedLeftElement
                );
            }
            array[futureIndexOfCurrentMovedLeftElement] = valueOfCurrentMovedLeftElement;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static int countFutureIndexOfLastMovedLeftElement(int numberOfRotations, int length) {
        return (numberOfRotations > length ? numberOfRotations % length : numberOfRotations) - 1;
    }
}