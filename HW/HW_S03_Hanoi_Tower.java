public class HW_S03_Hanoi_Tower {
    public static void main(String[] args) {
        steps(3, 1, 3); // кол-во дисков; номер оси, С которой перемещаем; номер оси, НА которую перемещаем
    }

    public static void steps(int n, int from, int to) {
        if (n == 1) {
            System.out.printf("%d -> %d\n", from, to);
        } else {
            int through = 6 - from - to; // номер промежуточной оси (т.к. 1 + 2 + 3 = 6)
            steps(n - 1, from, through);
            System.out.printf("%d -> %d\n", from, to);
            steps(n - 1, through, to);

        }

    }
}
