import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollation {
    /*
    Для сверки данных программа должна делать следующее:
    Проверить, что месячные и годовой отчёты были считаны из файлов.
    В случае если этого не было сделано, нужно предложить сначала считать данные.
    Подсчитать суммы доходов и расходов по каждому из месяцев.
    Сверить полученные суммы с суммой доходов и расходов в отчёте по году.
    При обнаружении несоответствия программа должна вывести месяц, где оно обнаружено.
    Если несоответствий не обнаружено, приложение должно вывести только информацию об успешном завершении операции.
    */
    public Map<Integer, Integer> monthlyIncome = new HashMap<>();
    public Map<Integer, Integer> monthlyExpense = new HashMap<>();
    public Map<Integer, Integer> yearlyIncome = new HashMap<>();
    public Map<Integer, Integer> yearlyExpense = new HashMap<>();

    public void reportChecker(Map<Integer, Integer> monthlyIncome, Map<Integer, Integer> yearlyIncome,
                              Map<Integer, Integer> monthlyExpense, Map<Integer, Integer> yearlyExpense) {
        /*
        Данный метод сверяет отчеты поданные ему в качестве 4 мап, на месячные доходы и расходы 2 мапы,
        аналогично и для годового отчета. Смотрит имеется ли несоответствия в указанных отчетах,
        ключ к ключу - значение к значению. Ну и сообщает о резуьтатах сверки!
         */

        if (monthlyIncome.isEmpty() || yearlyIncome.isEmpty() ||
                monthlyExpense.isEmpty() || yearlyExpense.isEmpty()) {
            System.out.println("Отчеты не были считаны сверщиком.");
        }
        for (Integer monthNumber : monthlyIncome.keySet()) {
            int monthlyReportAmount = monthlyIncome.get(monthNumber);
            int yearlyReportAmount = yearlyIncome.get(monthNumber);
            if (monthlyReportAmount != yearlyReportAmount) {
                System.out.printf("По результатам проверки месяца %d, обнаружено несоотвествие " +
                        "суммы доходов по версиям ежемесячных отчетов и ежегодного отчета!\n", monthNumber);

            } else {
                System.out.printf("По результатам проверки месяца %d, " +
                        "несоответствий в отчетах о доходах не обнаружено!\n", monthNumber);

            }
        }
        for (Integer monthNumber : monthlyExpense.keySet()) {
            int monthlyReportExpense = monthlyExpense.get(monthNumber);
            int yearlyReportExpense = yearlyExpense.get(monthNumber);
            if (monthlyReportExpense != yearlyReportExpense) {
                System.out.printf("По результатам проверки месяца %d, обнаружено несоотвествие суммы " +
                        "расходов по версиям ежемесячных отчетов и ежегодного отчета!\n", monthNumber);

            } else {
                System.out.printf("По результатам проверки месяца %d, несоответствий " +
                        "в отчетах о расходах не обнаружено!\n", monthNumber);

            }
        }
    }

    public void yearReportToHashMapSaver(List<SaverYearly> saver) { //сохраняет в хешмапу по ключам месяцы
                                                                    //и по значениям доход/расход
        for (SaverYearly save : saver) {
            if (!save.isExpense) {
                yearlyIncome.put(save.month, yearlyIncome.getOrDefault(save.month, 0) + save.amount);
            }
        }
        for (SaverYearly save : saver) {
            if (save.isExpense) {
                yearlyExpense.put(save.month, yearlyExpense.getOrDefault(save.month, 0) + save.amount);

            }
        }
    }

    public void monthReportToHashMapSaver(List<SaverMonthly> saver) {   //сохраняет в хешмапу по ключам месяцы
                                                                        //и по значениям общую сумму доходов/расходов
        for (SaverMonthly save : saver) {
            if (!save.isExpense && save.monthName.equalsIgnoreCase("январь")) {
                int monthNumber = 1;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyIncome.put(monthNumber, monthlyIncome.getOrDefault(monthNumber, 0) + sumOfIncome);
            } else if (!save.isExpense && save.monthName.equalsIgnoreCase("февраль")) {
                int monthNumber = 2;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyIncome.put(monthNumber, monthlyIncome.getOrDefault(monthNumber, 0) + sumOfIncome);
            } else if (!save.isExpense && save.monthName.equalsIgnoreCase("март")) {
                int monthNumber = 3;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyIncome.put(monthNumber, monthlyIncome.getOrDefault(monthNumber, 0) + sumOfIncome);
            }
        }
        for (SaverMonthly save : saver) {
            if (save.isExpense && save.monthName.equalsIgnoreCase("январь")) {
                int monthNumber = 1;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyExpense.put(monthNumber, monthlyExpense.getOrDefault(monthNumber, 0) + sumOfIncome);
            } else if (!save.isExpense && save.monthName.equalsIgnoreCase("февраль")) {
                int monthNumber = 2;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyExpense.put(monthNumber, monthlyExpense.getOrDefault(monthNumber, 0) + sumOfIncome);
            } else if (!save.isExpense && save.monthName.equalsIgnoreCase("март")) {
                int monthNumber = 3;
                int sumOfIncome = 0;
                int profitOfIncome = save.quantity * save.unitPrice;
                sumOfIncome += profitOfIncome;
                monthlyExpense.put(monthNumber, monthlyExpense.getOrDefault(monthNumber, 0) + sumOfIncome);
            }
        }
    }
}
