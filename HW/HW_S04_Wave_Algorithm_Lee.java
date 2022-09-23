// Реализовать волновой алгоритм.
// Строится ортогональный путь.
public class HW_S04_Wave_Algorithm_Lee {
    public static void get_wave(int field[][], int x_start, int y_start, int x_fin, int y_fin) {

        field[x_start][y_start] = 1;
        int count = 1;
        while (field[x_fin][y_fin] == 0) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == count) {
                        if (i - 1 >= 0 && field[i - 1][j] == 0) {
                            field[i - 1][j] = count + 1;
                        }
                        if (i + 1 < field.length && field[i + 1][j] == 0) {
                            field[i + 1][j] = count + 1;
                        }
                        if (j - 1 >= 0 && field[i][j - 1] == 0) {
                            field[i][j - 1] = count + 1;
                        }
                        if (j + 1 < field[i].length && field[i][j + 1] == 0) {
                            field[i][j + 1] = count + 1;
                        }
                    }
                }
            }
            count++;
        }
    }

    public static void get_way(int field[][], int x_fin, int y_fin) {
        int i = x_fin;
        int j = y_fin;
        while (field[i][j] > 1) {
            if (i - 1 >= 0 && field[i - 1][j] == field[i][j] - 1) {
                field[i][j] = -10; // -10 обозначаем ячейку, куда делаем шаг
                i--;
                continue;
            }
            if (i + 1 < field.length && field[i + 1][j] == field[i][j] - 1) {
                field[i][j] = -10; // -10 обозначаем ячейку, куда делаем шаг
                i++;
                continue;
            }
            if (j - 1 >= 0 && field[i][j - 1] == field[i][j] - 1) {
                field[i][j] = -10; // -10 обозначаем ячейку, куда делаем шаг
                j--;
                continue;
            }
            if (j + 1 < field[i].length && field[i][j + 1] == field[i][j] - 1) {
                field[i][j] = -10; // -10 обозначаем ячейку, куда делаем шаг
                j++;
                continue;
            }
        }

    }

    public static void print_field(int field[][], int x_fin, int y_fin) {
        String s = "";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (i == x_fin & j == y_fin) {
                    s += "!F!\t";
                } else {
                    if (field[i][j] == 0) {
                        s += " - \t";
                    }
                    if (field[i][j] == -1) {
                        s += " X \t";
                    }
                    if (field[i][j] == 1) {
                        s += "!S!\t";
                    }
                    if (field[i][j] > 1) {
                        s += " " + field[i][j] + "\t";
                    }
                    if (field[i][j] == -10) {
                        s += "<+>\t";
                    }
                }
            }
            s += "\n";
        }
        s += "\n\n\n";
        System.out.println(s);
    }

    public static void main(String[] args) {
        int field[][] = new int[10][10];
        int x_start = 5; // координата стартовой ячейки
        int y_start = 3; // координата стартовой ячейки
        int x_fin = 6; // координата финишной ячейки
        int y_fin = 8; // координата финишной ячейки
        field[3][4] = -1; // непроходная ячейка
        field[4][4] = -1; // непроходная ячейка
        field[5][4] = -1; // непроходная ячейка
        field[6][4] = -1; // непроходная ячейка

        get_wave(field, x_start, y_start, x_fin, y_fin);
        print_field(field, x_fin, y_fin); // рисуем волну
        get_way(field, x_fin, y_fin);
        print_field(field, x_fin, y_fin); // рисуем путь
    }
}
