// Реализовать алгоритм пирамидальной сортировки (HeapSort)
public class HW_S03_HeapSort {
    public void sort(int arr[]) {
        int len = arr.length;

        // Построение кучи
        for (int i = len / 2 - 1; i >= 0; i--)
            shift(arr, len, i);

        for (int i = len - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            shift(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом с
    // индексом i
    void shift(int arr[], int len, int i) {
        int i_max = i; // предположим, что наибольший элемент - это корень
        int l = 2 * i + 1; // левый дочерний элемент
        int r = 2 * i + 2; // правый дочерний элемент

        // Если левый дочерний элемент больше корня
        if (l < len && arr[l] > arr[i_max])
            i_max = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (r < len && arr[r] > arr[i_max])
            i_max = r;
        // Если самый большой элемент не корень
        if (i_max != i) {
            int tmp = arr[i];
            arr[i] = arr[i_max];
            arr[i_max] = tmp;

            // Рекурсивно преобразуем в двоичную кучу текущее поддерево
            shift(arr, len, i_max);
        }
    }

    static void printArray(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 10, 12, 11, 3, 6, 8 };

        HW_S03_HeapSort obj = new HW_S03_HeapSort();// ????????????????????????????
        obj.sort(arr);
        // sort(arr);
        printArray(arr);
    }
}
