import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Pair position and speed, then sort by position descending
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i]; // time to reach
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // sort by position descending

        Stack<Double> stack = new Stack<>();
        for (double[] car : cars) {
            double time = car[1];
            // If current car takes more time than the fleet ahead, it forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Else, it gets absorbed in the fleet ahead (do nothing)
        }

        return stack.size(); // each entry in the stack is a fleet
    }
}
