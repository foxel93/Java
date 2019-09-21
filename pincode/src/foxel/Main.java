package foxel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            char []pin = reader.readLine().toCharArray();
            int len = pin.length;
            short []variants = new short[]{257, 22, 46, 76, 178, 372, 616, 400, 929, 832};
            short []num = new short[len];
            char []str = new char[len];
            for (int i = 0; i < len; i++) {
                if (!Character.isDigit(pin[i]))
                    throw new IOException();
                num[i] = variants[pin[i] - '0'];
            }
            rec(num,0,str, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rec(short[] num, int i, char[] str, int k)
    {
        int a;
        int b;

        a = 0;
        if (i == num.length) {
            if (k != i)
                System.out.print(",");
            System.out.print(str);
            return;
        }
        b = num[i];
        while (b != 0)
        {
            if ((b & 1) == 1)
            {
                str[i] = (char)(a + '0');
                rec(num, i + 1, str, ++k);
            }
            a++;
            b = b >> 1;
        }
    }
}

