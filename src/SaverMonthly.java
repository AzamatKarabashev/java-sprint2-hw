public class SaverMonthly {
    public String itemName;
    public boolean isExpense;
    public int quantity;
    public int unitPrice;
    public String monthName;

    public SaverMonthly(String itemName, boolean isExpense, int quantity, int unitPrice, String monthName) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.monthName = monthName;

    }

}
