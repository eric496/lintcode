/*
Given a watch with a binary display time and a non-negative integer n which represents the number of 1s on a given timetable, return all possible time.

Notice
    The order of output does not matter.
    The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
    The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

Example
    Given n = 1
    Return ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
*/

/*
Thought process:
    Backtrack
*/

public class Solution {
    public List<String> binaryTime(int num) {
        List<String> result = new ArrayList<String>();
        int[] hours = new int[]{8, 4, 2, 1}, mins = new int[]{32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(hours, i);
            List<Integer> list2 = generateDigit(mins, num - i);
            for(int hour: list1) {
                if(hour >= 12) continue;
                for(int minute: list2) {
                    if(minute >= 60) continue;
                    result.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
        }
        return result;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> result = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, result);
        return result;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> result) {
        if(count == 0) {
            result.add(sum);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], result);    
        }
    }
}
