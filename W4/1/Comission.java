public class Comission extends Hourly{
    private double totalSales;
    private double comissionRate;

    public Comission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double comissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        //TODO Auto-generated constructor stub
    }


    public void addSales(double totalSales){
        this.totalSales = totalSales;
    }

    @Override
    public double pay(){
        double payment = super.pay();
        payment += totalSales * comissionRate;
        totalSales = 0;
        return payment;
    }

    @Override
    public String toString(){
        String result = super.toString();
        result += "\nTotal sales: " + totalSales;
        return result;
    }


}
