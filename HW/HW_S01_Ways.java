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


// import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class HW_S01_Ways {
    public static void main(String[] args) {
        int start = 2; int end = 18; int com1 = 5; int com2 = 2;
        System.out.println(how_many_ways(start, end, com1, com2));
        System.out.println(recursion_solve(start, end, com1, com2));
        one_way(start, end, com1, com2);
    }
// В решении 1) выводится в терминал массив с индексами; 2) находится кол-во путей:
    static int how_many_ways(int start, int end, int com1, int com2) {
        int[] ways = new int[end + 1];
        ways[start] = 1;
        int start_index = start + com1  < start * com2 ? start + com1 : start * com2;
        System.out.format("(%d)%d ", start, ways[start]);

        for (int index = start_index; index <= end; index++) {
            if (index % com2 == 0) {
                ways[index] = (index - com1 < 0 ? 0 : ways[index - com1]) + ways[index / com2];
            } else {
                ways[index] = index - com1 < 0 ? 0 : ways[index - com1];
            }
            System.out.format("(%d)%d ", index, ways[index]);
        }
        System.out.format("\n");
        return ways[end];
    }    
// В решении находится кол-во путей (при помощи рекурсии):
    static int recursion_solve(int start, int end, int com1, int com2) {
        if (end == start) return 1;
        else if (end < start) return 0;
        else {
            if (end % com2 == 0)
                return recursion_solve(start, end - com1, com1, com2) + recursion_solve(start, end / com2, com1, com2);
            else return recursion_solve(start, end - com1, com1, com2);
        }
    }

// Метод возвращает массив
    static int[] arr_how_many_ways(int start, int end, int com1, int com2) {
        int[] ways = new int[end + 1];
        ways[start] = 1;
        int start_index = start + com1  < start * com2 ? start + com1 : start * com2;
        for (int index = start_index; index <= end; index++) {
            if (index % com2 == 0) {
                ways[index] = (index - com1 < 0 ? 0 : ways[index - com1]) + ways[index / com2];
                
            } else {
                ways[index] = index - com1 < 0 ? 0 : ways[index - com1];
            }
        }
        return ways;
    }     

// Метод возвращает один путь    
    static void one_way(int start, int end, int com1, int com2){
        int[] ways = arr_how_many_ways(start, end, com1, com2);
        if (ways[end] != 0){
            // System.out.format("Пути есть!");   
            String res = " = " + end;
            int value = end;
            while (value >= start) {
                if (value == start) {
                    res = start + res;
                    break;
                }
                if ((value - com1 >= start) && (ways[value - com1] != 0)){
                    value -= com1;
                    res = " + " + com1 + res;
                } else{
                    if ((value % com2 == 0) & (ways[value / 2] !=0)) {
                        value /= com2;
                        res = " x " + com2 + res;
                    }
                }
            }
            System.out.println(res);
        } else{
            System.out.format("Нет путей от %d до %d", start, end);    
        }
        
    }

}


