package lab.assignments;

class Calc {
    int calc_count = 0; 

    int add(int a, int b) {
        calc_count++;
        return a + b;
    }

    float add(float x, float y) {
        calc_count++;
        return x + y;
    }

    int add(int l, int m, int n) {
        calc_count++;
        return l + m + n;
    }
}

public class calc_Example {
    public static void main(String args[]) {
        Calc c = new Calc();

        int intA = 10;
        int intB = 20;
        System.out.println("Two integers: " + intA + " + " + intB + " = " + c.add(intA, intB));
        System.out.println("Number of calculations: " + c.calc_count);

        float floatX = 12.5f;
        float floatY = 3.75f;
        System.out.println("Two floats: " + floatX + " + " + floatY + " = " + c.add(floatX, floatY));
        System.out.println("Number of calculations: " + c.calc_count);

        int i1 = 1, i2 = 2, i3 = 3;
        System.out.println("Three integers: " + i1 + " + " + i2 + " + " + i3 + " = " + c.add(i1, i2, i3));
        System.out.println("Number of calculations: " + c.calc_count);
    }
}
