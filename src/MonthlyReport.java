import java.util.ArrayList;
import java.util.List;

//Считываем данные за месяц/несколько месяцев
public class MonthlyReport {
    FileReader fileReader = new FileReader();
    public List<List<SaverMonthly>> monthlyReports = new ArrayList<>();

    public List<SaverMonthly> monthLoader(String fileName, String monthName, List<SaverMonthly> reports) {  //принмает на вход файл и лист,
                                                                                                            //возвращает лист наполненный
                                                                                                            //экземпляярами класса SaverMonthly
        ArrayList<String> monthReports = fileReader.readFileContents(fileName);
        for (int i = 1; i < monthReports.size(); i++) {
            String[] partsOfContent = monthReports.get(i).split(",");       // item_name,is_expense,quantity,unit_price
            String itemName = partsOfContent[0];                            // название товара
            boolean isExpense = Boolean.parseBoolean(partsOfContent[1]);    // трата(TRUE)/доход(FALSE)
            int quantity = Integer.parseInt(partsOfContent[2]);             // количество закупленного/проданного товара
            int unitPrice = Integer.parseInt(partsOfContent[3]);            // стоимость одной единицы товара
            SaverMonthly saverMonthly = new SaverMonthly(itemName, isExpense, quantity, unitPrice, monthName);
            reports.add(saverMonthly);
        }
        return reports;
    }

    public void readAndSaveReports() {  //ложит месячнные отчеты в лист, содержащщий
                                        //листы с экземплярами класса SaverMonthly
        String monthName = null;
        String fileName = null;
        for (int i = 1; i < 4; i++) {
            fileName = "m.20210" + i + ".csv";
            if (i == 1) {
                monthName = "Январь";
                List<SaverMonthly> month = new ArrayList<>();
                monthLoader(fileName, monthName, month);
                monthlyReports.add(month);
            } else if (i == 2) {
                monthName = "Февраль";
                List<SaverMonthly> month = new ArrayList<>();
                monthLoader(fileName, monthName, month);
                monthlyReports.add(month);
            } else {
                monthName = "Март";
                List<SaverMonthly> month = new ArrayList<>();
                monthLoader(fileName, monthName, month);
                monthlyReports.add(month);
            }
        }
    }
}


