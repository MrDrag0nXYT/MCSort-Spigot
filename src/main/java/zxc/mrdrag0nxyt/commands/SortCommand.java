package zxc.mrdrag0nxyt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import zxc.mrdrag0nxyt.enums.SortType;

import java.util.Arrays;

public class SortCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        int nums[] = new int[(strings.length - 1)];

        try {
            for (int i = 0; i < (strings.length - 1); i++) {
                nums[i] = Integer.parseInt(strings[(i + 1)]);
            }
        } catch (Exception exp) {
            commandSender.sendMessage(" ");
            commandSender.sendMessage("Введённый вами набор данных не является набором чисел. Как прикажете это сортировать?");
            commandSender.sendMessage(" ");
            return false;
        }

        switch (strings[0].toLowerCase()) {
            case "help":
                commandSender.sendMessage(" ");
                commandSender.sendMessage("+=========+ MCSort - помощь +=========+");
                commandSender.sendMessage(" - /sort <тип сортировки> <числа> - отсортировать числа");
                commandSender.sendMessage(" - /sort help - показать эту штуку");
                commandSender.sendMessage("+===================================+");
                commandSender.sendMessage(" ");
                return false;
        }

        commandSender.sendMessage(" ");
        commandSender.sendMessage("Изначальный массив: " + Arrays.toString(nums));

        switch (SortType.valueOf(strings[0].toLowerCase())) {
            case SELECTION:
                selectionSort(nums);
                break;
            case HEAP:
                heapSort(nums);
                break;
            case SHELL:
                shellSort(nums);
                break;
            case SIMPLE:
                simpleSort(nums);
                break;
            default:
                commandSender.sendMessage("Такого варианта в списке нет!");
        }

        commandSender.sendMessage("Отсортированный массив: " + Arrays.toString(nums));
        commandSender.sendMessage(" ");

        return true;
    }


    private static void selectionSort(int[] nums) {
        int n = nums.length;

        // перебор всех элементов массива
        for (int i = 0; i < n - 1; i++) {

            // поиск минимального элемента в оставшейся части массива
            int minNumber = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minNumber]) {
                    minNumber = j;
                }
            }

            // обмен местами между минимальным и первым неотсортированным элементом
            int temp = nums[minNumber];
            nums[minNumber] = nums[i];
            nums[i] = temp;
        }
    }


    private static void heapSort(int[] nums) {
        int n = nums.length;

        // перегруппировка массива (создание кучи)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // извлечение одного за другим элементов из кучи
        for (int i = n - 1; i > 0; i--) {
            // обмен местами между текущим корнем и последним элементом
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }
    }

    // преобразование поддерева с наибольшим элементом i в кучу с n элементами
    private static void heapify(int[] nums, int n, int i) {
        int largest = i; // создаём наибольший элемент - корень
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // если левая часть больше корня
        if (leftChild < n && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        // если правая часть больше корня
        if (rightChild < n && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        // если наибольший элемент в нашем массиве не корень
        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            // повторно вызываем эту функцию для поддерева
            heapify(nums, n, largest);
        }
    }

    private static void shellSort(int[] nums) {
        int n = nums.length;

        // начинаем с большого интервала, постепенно уменьшаем
        for (int interval = n / 2; interval > 0; interval /= 2) {
            // проходим по подмассивам и сортируем их с использованием вставочной сортировки
            for (int i = interval; i < n; i++) {
                int temp = nums[i];
                int j;
                for (j = i; j >= interval && nums[j - interval] > temp; j -= interval) {
                    nums[j] = nums[j - interval];
                }
                nums[j] = temp;
            }
        }
    }

    private static void simpleSort(int[] nums) {
        Arrays.sort(nums);
    }
}

