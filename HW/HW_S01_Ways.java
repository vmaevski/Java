// На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раза, а умножается на c
// - команда 2 (к2): увеличить на d, к a прибавляется d
// написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
// Пример 1: а = 1, b = 7, c = 2, d = 1
// ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2
// Можно начать с более простого – просто подсчёта общего количесвтва вариантов
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: нет решения.
// *Подумать над тем, как сделать минимальное количество команд

// В решении находится кол-во путей

// import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class HW_S01_Ways {
    public static void main(String[] args) {
        System.out.println(solve(2, 30, 2, 4));
        System.out.println(recursion_solve(2, 30, 2, 4));
        
    }

    static int solve(int start, int end, int com1, int com2) {
        int[] ways = new int[end + 1];
        ways[start] = 1;

        for (int index = start + com1; index <= end; index++) {
            if (index % com2 == 0) {
                ways[index] = ways[index - com1] + ways[index / com2];
            } else {
                ways[index] = ways[index - com1];
            }
        }
        return ways[end];
    }    

    static int recursion_solve(int start, int end, int com1, int com2) {
        if (end == start) return 1;
        else if (end < start) return 0;
        else {
            if (end % com2 == 0)
                return recursion_solve(start, end - com1, com1, com2) + recursion_solve(start, end / com2, com1, com2);
            else return recursion_solve(start, end - com1, com1, com2);
        }
    }
    
}
