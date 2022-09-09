// Задача 3: Написать программу вычисления n-ого треугольного числа. 
// n-е треугольное число T_{n} — это сумма n первых натуральных чисел.


public class HW_S02_triangular_number {

    public static void main(String[] args) {
        System.out.println(solve(10));
    }

    static int solve(int n) {
        int t = n*(n+1)/2;
        return t;
    }    
    
}
