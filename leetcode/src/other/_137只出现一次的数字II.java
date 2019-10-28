package other;

public class _137只出现一次的数字II {
    public int singleNumber(int[] nums) {
        int b[] = new int[32];
        int res = 0;
        int length = nums.length;

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < length; j++) {
                b[i] += nums[j] & 1;
                b[i] %= 3;
                nums[j] >>= 1;
            }
        }
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res += b[i];
        }
        return res;
    }

    public int singleNumber1(int[] nums) {
        int length = nums.length;
        int a=0,b=0,c=0;

        for (int j = 0; j < length; j++) {
            b|= a&nums[j];
            a^=nums[j];
            c=a&b;
            b&=~c;
            a&=~c;
        }

        return a;

    }

    public static void main(String[] args) {
        int[] a={2,2,-3,2};
        System.out.println(new _137只出现一次的数字II().singleNumber1(a));
    }
}
