import java.text.*;
public class DailyReport
{
    private double totalsale;
    private int totalcustomer;
    private double avgsale;
    private int highestfood;
    private String hfString;
    DecimalFormat df = new DecimalFormat("0.00");
    
    public DailyReport()
    {
        totalsale = 0.0;
        totalcustomer = 0;
        avgsale = 0.0;
        highestfood = 0;
        hfString = null;
    }
    
    public DailyReport(double totalsale, int totalcustomer, double avgsale, int highestfood, String hfString)
    {
        this.totalsale = totalsale;
        this.totalcustomer = totalcustomer;
        this.avgsale = avgsale;
        this.highestfood = highestfood;
        this.hfString = hfString;
    }
    
    public String toString()
    {
        return "\n ====================================================================== " +
               "\n \t\t\t D A I L Y    R E P O R T" +
               "\n ====================================================================== " +
               "\n Total Sale : RM " + df.format(totalsale) +
               "\n Total Customer : " + totalcustomer +
               "\n Average Sale per Customer : RM " + df.format(avgsale) +
               "\n Highest Selling Food : " + hfString + "\tQuantity : " +highestfood;
               
    }
    
}
