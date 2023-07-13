import java.util.HashMap;
import java.util.List;

public class MonthlyStatsPrinter {
    /*
    Программа должна поддерживать вывод информации из месячных и годового отчёта.
    Информация из месячных отчётов.

    При вызове этой функции программа должна выводить следующие данные по каждому из месяцев:
    название месяца;
    самый прибыльный товар, название товара и сумму;
    самую большую трату, название товара и сумму.

    Перед выполнением подсчётов необходимо проверить, что месячные отчёты были считаны из файла.
    В случае если этого сделано не было, нужно предложить сначала считать данные.
     */
    void searchTopAndPrint(List<SaverMonthly> saver) {  //принимает на вход лист с месячными отчетами,
                                                        //считает и выводит по тз самый прибыльный товар и сумму прибыли
        /*
        метод сохраняет в хешмапу навзание самого прибыльного товара
        и сумму на которую он был продан. ключи хешмапы это названия товаров
        значения хешмапы это прибыль
        PROFIT самый прибыльный товар — это товар, для которого is_expense == false,
        а произведение количества (quantity) на сумму (unit_price) максимально.
         */
        String topUnit = null;
        String monthName = null;
        int topProfit = 0;
        HashMap<String, Integer> asMemory = new HashMap<>();
        for (SaverMonthly saverMonthly : saver) {
            if (!saverMonthly.isExpense) {
                monthName = saverMonthly.monthName;
                int profit = saverMonthly.quantity * saverMonthly.unitPrice;
                asMemory.put(saverMonthly.itemName, asMemory.getOrDefault(saverMonthly.itemName, 0) + profit);
            }
        }
        for (String unit : asMemory.keySet()) {
            if (topProfit < asMemory.get(unit)) {
                topProfit = asMemory.get(unit);
                topUnit = unit;
            }
        }
        System.out.printf("За %s, наибольшая выручка была в секции: %s, зароботок составил: %d! \n",
                monthName, topUnit, topProfit);
    }

    void searchWorstAndPrint(List<SaverMonthly> saver) {    //принимает на вход лист с месячными отчетами,
                                                            //считает и выводит по тз самый убыточный товар и сумму убытков
        String worstUnit = null;
        String monthName = null;
        int maxWaste = 0;
        HashMap<String, Integer> asMemory = new HashMap<>();
        for (SaverMonthly saverMonthly : saver) {
            if (saverMonthly.isExpense) {
                monthName = saverMonthly.monthName;
                int waste = saverMonthly.quantity * saverMonthly.unitPrice;
                asMemory.put(saverMonthly.itemName, asMemory.getOrDefault(saverMonthly.itemName, 0) + waste);
            }
        }
        for (String unit : asMemory.keySet()) {
            if (maxWaste < asMemory.get(unit)) {
                maxWaste = asMemory.get(unit);
                worstUnit = unit;
            }
        }
        System.out.printf("Также за %s, больше всего потрачено на: %s, сумма трат составила: %d! \n",
                monthName, worstUnit, maxWaste);
        System.out.println();
    }
}





















