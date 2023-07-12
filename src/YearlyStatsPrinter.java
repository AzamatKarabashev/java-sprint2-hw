import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YearlyStatsPrinter {
    void searchYearStatsAndPrint(List<SaverYearly> saver) { // данный метод принимает лист содержащий экземпляры класса
                                                            // SaverYearly и считает средний доход/расход по году.
                                                            // После всего выводит статистику.
     /*
    Информация из годового отчёта.
    При вызове этой функции программа должна выводить такие данные:

    рассматриваемый год;
    прибыль по каждому месяцу;
    средний расход за все имеющиеся операции в году;
    средний доход за все имеющиеся операции в году.

    Перед выполнением подсчётов необходимо проверить, что годовой отчёт был считан из файла.
    В случае если этого сделано не было, нужно предложить сначала считать данные.
      */
        int yearNumber = 2021;
        int averageExpenseInYear = 0;   // средний расход
        int averageIncomeInYear = 0;    // средний доход
        int sumOfExpense = 0;
        int sumIfIncome = 0;
        /*
        средний доход/расход за год мы посчитаем так:
        если isExpense == false (доход) сумма amount / на количество месяцев (3)
         */
        System.out.printf("В %d году прибыль в месяце: \n", yearNumber);
        for (SaverYearly saverYearly : saver) {
            if (!saverYearly.isExpense) {
                sumOfExpense += saverYearly.amount;
                averageIncomeInYear = sumOfExpense / 3;
                System.out.printf("%d составила: %d\n", saverYearly.month, saverYearly.amount);
            }
        }
        System.out.printf("Средний доход за год составил: %d\n", averageIncomeInYear);

        for (SaverYearly saverYearly : saver) {
            if (saverYearly.isExpense) {
                sumIfIncome += saverYearly.amount;
                averageExpenseInYear = sumIfIncome / 3;
            }
        }
        System.out.printf("Средний расход за год составил: %d\n", averageExpenseInYear);
    }
}
