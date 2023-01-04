
public class Customer
{
    private double totalprice;
    
    public Customer()
    {
       totalprice = 0.0;
    }
    
    public Customer(double totalprice)
    {
        this.totalprice = totalprice;
    }
    
    public String toString()
    {
        return "\n Total : RM " + totalprice;
    }
}
