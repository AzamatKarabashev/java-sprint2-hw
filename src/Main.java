import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    Приветствую мой дорогой ревьюер! Желаю тебе хорошего настроения=)
    Готов получить люлей за свой ужасно громоздкий код!
    В будущем надеюсь буду писать более компактный и адекватный код!
    На всякий случай я закомментировал все свои методы.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        MonthlyStatsPrinter monthlyStatsPrinter = new MonthlyStatsPrinter();
        YearlyReport yearlyReport = new YearlyReport();
        YearlyStatsPrinter yearlyStatsPrinter = new YearlyStatsPrinter();
        DataCollation dataCollation = new DataCollation();
        while (true) {
            printMenu();
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {
                monthlyReport.readAndSaveReports();
                if (monthlyReport.monthlyReports.isEmpty()) {
                    System.out.println("Отчеты считать не получилось =(");
                    continue;
                }
                System.out.println("Месячные отчеты считаны");
            } else if (input == 2) {
                yearlyReport.readAndSaveReports();
                if (yearlyReport.yearlyReports.isEmpty()) {
                    System.out.println("Годовой отчет считать не получилось =(");
                    continue;
                }
                System.out.println("Годовой отчет считан");
            } else if (input == 3) {
                if (yearlyReport.yearlyReports.isEmpty() || monthlyReport.monthlyReports.isEmpty()) {
                    System.out.println("Отчеты для сверки еще не считаны =(\n" +
                            "Сначала используйте команды 1 и 2 для считывания годового и месячных отчетов!");
                    continue;
                }
                System.out.println("Все отчеты получены и сверщик успешно проанализировал их: ");
                for (List<SaverMonthly> report : monthlyReport.monthlyReports) {
                    dataCollation.monthReportToHashMapSaver(report);
                }
                dataCollation.yearReportToHashMapSaver(yearlyReport.yearlyReports.get(0));
                dataCollation.reportChecker(dataCollation.monthlyIncome, dataCollation.yearlyIncome,
                        dataCollation.monthlyExpense, dataCollation.yearlyExpense);
            } else if (input == 4) {
                if (monthlyReport.monthlyReports.isEmpty()) {
                    System.out.println("Сначала необходимо считать месячные отчеты!");
                    continue;
                }
                for (List<SaverMonthly> report : monthlyReport.monthlyReports) {
                    monthlyStatsPrinter.searchTopAndPrint(report);
                    monthlyStatsPrinter.searchWorstAndPrint(report);
                }
            } else if (input == 5) {
                if (yearlyReport.yearlyReports.isEmpty()) {
                    System.out.println("Сначала необходимо считать годовой отчет!");
                    continue;
                }
                for (List<SaverYearly> report : yearlyReport.yearlyReports) {
                    yearlyStatsPrinter.searchYearStatsAndPrint(report);
                }
            } else if (input == 0) {
                System.out.println("Пока пока!");
                return;
            } else {
                System.out.println("Такой команды пока нет!");
                return;
            }
        }
    }

    static void printMenu() { // печатаем меню
        System.out.println(
                "Введите:\n" +
                        "1 - Считать все месячные отчёты\n" +
                        "2 - Считать годовой отчёт\n" +
                        "3 - Сверить отчёты\n" +
                        "4 - Вывести информацию обо всех месячных отчётах\n" +
                        "5 - Вывести информацию о годовом отчёте\n" +
                        "0 - выход");
    }


}

