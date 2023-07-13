import java.util.ArrayList;
import java.util.List;

//Считываем данные за год
public class YearlyReport {
    FileReader fileReader = new FileReader();
    public List<List<SaverYearly>> yearlyReports = new ArrayList<>();

    public void yearLoader(String fileName, int yearNumber, List<SaverYearly> reports) {   //принмает на вход файл и лист,
                                                                                                        //возвращает лист наполненный
                                                                                                        //экземпляярами класса SaverYearly
        List<String> yearContent = fileReader.readFileContents(fileName);
        for (int i = 1; i < yearContent.size(); i++) {
            String[] partsOfContent = yearContent.get(i).split(",");
            int month = Integer.parseInt(partsOfContent[0]);
            int amount = Integer.parseInt(partsOfContent[1]);
            boolean isExpense = Boolean.parseBoolean(partsOfContent[2]);
            SaverYearly saverYearly = new SaverYearly(month, amount, isExpense, yearNumber);
            reports.add(saverYearly);
        }
    }

    public void readAndSaveReports() {  //ложит годовой отчет в лист, содержащщий
                                        //лист с экземплярами класса SaverYearly
        if (yearlyReports.isEmpty()) {
            int yearNumber = 2021;
            String filename = "y.2021.csv";
            List<SaverYearly> year = new ArrayList<>();
            yearLoader(filename, yearNumber, year);
            yearlyReports.add(year);
        } else {
            System.out.println("Годовой отчет уже был считан!");
        }
    }
}

