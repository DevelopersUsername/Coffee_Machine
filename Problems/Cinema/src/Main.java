import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> placeMap = new LinkedHashMap<>();
        int maxLength, currentValue;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            maxLength = 0;
            currentValue = 0;
            for (int j = 0; j < m; j++) {
                if (scanner.nextInt() == 0) {
                    currentValue++;
                    maxLength = Math.max(currentValue, maxLength);
                } else {
                    currentValue = 0;
                }
            }
            placeMap.put(i + 1, maxLength);
            System.out.println();
        }

        int k = scanner.nextInt();
        int availableSeats = 0;
        for (Map.Entry<Integer, Integer> entry : placeMap.entrySet()) {
            if (entry.getValue() >= k) {
                availableSeats = entry.getKey();
                break;
            }
        }
        System.out.println(availableSeats);
    }
}