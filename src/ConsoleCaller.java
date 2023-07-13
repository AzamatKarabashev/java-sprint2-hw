import java.util.List;
import java.util.Scanner;

public class ConsoleCaller {

    public void userConsole() {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        MonthlyStatsPrinter monthlyStatsPrinter = new MonthlyStatsPrinter();
        YearlyReport yearlyReport = new YearlyReport();
        YearlyStatsPrinter yearlyStatsPrinter = new YearlyStatsPrinter();
        DataCollation dataCollation = new DataCollation();
        while (true) {
            printMenu();
            String input = scanner.next().trim();
            switch (input) {
                case "1":
                    monthlyReport.readAndSaveReports();
                    if (monthlyReport.monthlyReports.isEmpty()) {
                        System.out.println("Отчеты считать не получилось =(");
                        continue;
                    }
                    System.out.println("Месячные отчеты считаны");
                    break;
                case "2":
                    yearlyReport.readAndSaveReports();
                    if (yearlyReport.yearlyReports.isEmpty()) {
                        System.out.println("Годовой отчет считать не получилось =(");

                    } else {
                        System.out.println("Годовой отчет считан");
                    }
                    break;
                case "3":

                    if (yearlyReport.yearlyReports.isEmpty() || monthlyReport.monthlyReports.isEmpty()) {
                        System.out.println("Отчеты для сверки еще не считаны =(\n" +
                                "Сначала используйте команды 1 и 2 для считывания годового и месячных отчетов!");
                    } else {
                        for (List<SaverMonthly> report : monthlyReport.monthlyReports) {
                            if (monthlyReport.monthlyReports.isEmpty()) {
                                System.out.println("Отчеты для сверки еще не считаны =(\n" +
                                        "Сначала используйте команды 1 и 2 для считывания годового и месячных отчетов!");
                            } else {
                                dataCollation.monthReportToHashMapSaver(report);
                            }
                        }

                        if (yearlyReport.yearlyReports.isEmpty()) {
                            System.out.println("Отчеты считаны неверно!");
                        } else {
                            dataCollation.yearReportToHashMapSaver(yearlyReport.yearlyReports.get(0));
                            dataCollation.reportChecker(dataCollation.monthlyIncome, dataCollation.yearlyIncome,
                                    dataCollation.monthlyExpense, dataCollation.yearlyExpense);
                        }
                    }
                    break;
                case "4":
                    if (monthlyReport.monthlyReports.isEmpty()) {
                        System.out.println("Сначала необходимо считать месячные отчеты!");
                        continue;
                    }
                    for (List<SaverMonthly> report : monthlyReport.monthlyReports) {
                        monthlyStatsPrinter.searchTopAndPrint(report);
                        monthlyStatsPrinter.searchWorstAndPrint(report);
                    }
                    break;
                case "5":
                    if (yearlyReport.yearlyReports.isEmpty()) {
                        System.out.println("Сначала необходимо считать годовой отчет!");
                        continue;
                    }
                    for (List<SaverYearly> report : yearlyReport.yearlyReports) {
                        yearlyStatsPrinter.searchYearStatsAndPrint(report);
                    }
                    break;
                case "0":
                    System.out.println("Пока пока!");
                    return;
                default:
                    System.out.println("Такой команды пока нет!");
                    break;
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
