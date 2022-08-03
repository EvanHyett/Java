import java.util.ArrayList;
public class CafeUtil {
    public int getStreakGoal() {
        ArrayList<Integer> weekArray = new ArrayList<Integer>();

        int sum = 0;
        for (int i = 0; i < 11; i++){
            weekArray.add(i+1);
            sum = sum + i;
        }
        return sum;
    }

    public int getOrderTotal() {
        int result = 0;
        for(int i = 0; i < Double.length; i++){
            result += i;
        }
        return result;
    }
}