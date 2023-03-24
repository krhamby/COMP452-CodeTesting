import java.util.Random;

class RandomTestingDouble extends Random {
    private int index;
    private int[] values;

    public RandomTestingDouble() {
        index = 0;
        values = new int[]{47, 134, 283, 355, 400, 591, 702, 736, 852, 988};
    }

    public int nextInt(int bound) {
        int value = values[index];
        index = (index + 1) % values.length;
        return value;
    } 
}
