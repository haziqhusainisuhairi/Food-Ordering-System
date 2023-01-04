
 
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main 
{
    public static void main(String[] args) 
    {
        //Declarations
        Scanner s = new Scanner(System.in);
       
        int orderNo, custCount = 0, saleCount = 0, highestfood = 0;
        double totalprice = 0, totalsale = 0, avgsale;
        boolean nextCust = true, confirmOrder = true, errorDetect = true, cycle = true;
        String hfString = "Cheese Burger";
        
        //Menu Counter
        int cb=0, jh=0, f=0, sg=0, fs=0, sh=0;
        
        //Arrays
        Customer cust[] = new Customer[100];
        String[] menu = {"Cheese Burger","Jolly Hotdog","Fries","Sundae Glaze","Fried Siomai","Shawarma"};
        int[] menuPrice = { 12, 10, 7, 5, 6, 9 };
        int[] quantity = new int [100];
        double[] price = new double [100];
        String custOrder[] = new String [100];
        
        //I/O Declare
        PrintWriter receipt = null;
        BufferedReader infile = null;
        
        System.out.println("\n ====================== Food Ordering System ======================");
        System.out.println(" ======================== You Can Order Now ========================");

        do
        {
            do
            {
                System.out.print("\n How many orders would you like to make? : ");
                int orders = s.nextInt();
                
                for(int i=0;i < orders;i++)
                {

                    do
                    {
                        //display menu  
                        dispMenu dispMenu = new dispMenu();
                        
                        System.out.println(" Order No. : [" + (i+1) + "]");
                        System.out.print("\n What would you like to order? [Choose number] : ");
                        orderNo = s.nextInt();
                        s.nextLine();
                        
                        if(orderNo == 1)
                        {
                            errorDetect=true;
                        }
                        else if(orderNo == 2)
                        {
                            errorDetect=true;
                        }
                        else if(orderNo == 3)
                        {
                            errorDetect=true;
                        }
                        else if(orderNo == 4)
                        {
                            errorDetect=true;
                        }
                        else if(orderNo == 5)
                        {
                            errorDetect=true;
                        }
                        else if(orderNo == 6)
                        {
                            errorDetect=true;
                        }
                        else
                        {
                            System.out.println("\n xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println(" \t  Error!! Wrong input entered \n\t  Please Try Again!");
                            System.out.println(" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("\n\n Press Any Key to Continue...");
                            s.nextLine();
                            
                            System.out.print('\u000C');
                            
                            errorDetect=false;
                        }
                        
                    }while(!errorDetect);
                    
                    System.out.print("\n How many pieces? : ");
                    quantity[i] = s.nextInt();
                    s.nextLine();
                    
                    if(orderNo == 1)
                    {
                            custOrder[i] = menu[0];
                            price[i] = menuPrice[0];
                            cb+=quantity[i];
                    }
                    else if(orderNo == 2)
                    {
                            custOrder[i] = menu[1];
                            price[i] = menuPrice[1];
                            jh+=quantity[i];
                    }
                    else if(orderNo == 3)
                    {
                            custOrder[i] = menu[2];
                            price[i] = menuPrice[2];
                            f+=quantity[i];
                    }
                    else if(orderNo == 4)
                    {
                            custOrder[i] = menu[3];
                            price[i] = menuPrice[3];
                            sg+=quantity[i];
                    }
                    else if(orderNo == 5)
                    {
                            custOrder[i] = menu[4];
                            price[i] = menuPrice[4];
                            fs+=quantity[i];
                    }
                    else if(orderNo == 6)
                    {
                            custOrder[i] = menu[5];
                            price[i] = menuPrice[5];
                            sh+=quantity[i];
                    }
                    
                   
                    totalprice+=(price[i] * quantity[i]);
                    
                    saleCount++;
                }
                

                do
                {
                    totalsale+=totalprice;
                    cust[custCount] = new Customer(totalprice);
                    
                    System.out.print('\u000C');
                    System.out.println("\n ==============================================================");
                    System.out.println("\t\t\t R E C E I P T ");
                    System.out.println(" ==============================================================");
                    System.out.println(" Food/Beverages                 Quantity              Price(RM)");
                    
                    for(int i=0;i < orders;i++)
                    {
                        System.out.printf(" %d. %-30s %-20d %.2f%n",i + 1, custOrder[i], quantity[i], price[i]* quantity[i]);
                    }
                    
                    System.out.println(cust[custCount].toString());
                    
                    
                    System.out.print("\n Do you confirm that this is your order? If you select [N] it will repeat your order [Y/N] : ");
                    String cOrder = s.nextLine();
                    
                    if(cOrder.equalsIgnoreCase("n"))
                    {
                        confirmOrder = false;
                        System.out.print('\u000C');
                        errorDetect=true;
                    }
                    else if(cOrder.equalsIgnoreCase("y"))
                    {
                        System.out.print('\u000C');
                        System.out.println("\n ==============================================================");
                        System.out.println(" \t\tOrder Confirmed!! Printing Receipt");
                        System.out.println(" ==============================================================");
                        System.out.println("\n\n Press Any Key to Continue...");
                        s.nextLine();
                        errorDetect=true;
                        confirmOrder = true;
                        
                        try
                        {
                            receipt = new PrintWriter (new BufferedWriter (new FileWriter ("Customer Receipt ["+(custCount+1)+"].txt")));
                            
                            receipt.print("\n ==============================================================" +
                                          "\n\t\t\t R E C E I P T " +
                                          "\n ==============================================================" +
                                          "\n Food/Beverages                 Quantity              Price(RM)\n" );
                                          
                            for(int i=0;i < orders;i++)
                            {
                                receipt.printf(" %d. %-30s %-20d %.2f%n",i + 1, custOrder[i], quantity[i], price[i]* quantity[i]);
                            }
                            
                            receipt.println(cust[custCount].toString());
                            
                            receipt.close();
                                         
                        }
                        catch (FileNotFoundException fnfe)   
                        {     System.out.println("File not found");  } 
                                                
                        catch (IOException ioe)   
                        {   System.out.println(ioe.getMessage()); }
                                                    
                        catch (Exception e)   
                        {   System.out.println(e.getMessage());   }
                        
                    }
                    else
                    {
                        System.out.println("\n xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println(" \t  Error!! Wrong input entered \n\t  Please Try Again!");
                        System.out.println(" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");    
                        System.out.println("\n\n Press Any Key to Continue...");
                        s.nextLine();
                            
                        System.out.print('\u000C');
                            
                        errorDetect=false;
                    }
                }while(!errorDetect);
                
            }while(!confirmOrder);
            
            System.out.print('\u000C');
            do
            {
                System.out.print("\n\n\n Next Customer? [Y/N] : ");
                String nCust = s.nextLine();
                
                custCount++;
                
                if(nCust.equalsIgnoreCase("n"))
                {
                    nextCust = false;
                    errorDetect=true;
                }
                else if(nCust.equalsIgnoreCase("y"))
                {
                    errorDetect=true;
                }
                else
                {
                    System.out.println("\n xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println(" \t  Error!! Wrong input entered \n\t  Please Try Again!");
                    System.out.println(" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("\n\n Press Any Key to Continue...");
                    s.nextLine();

                    System.out.print('\u000C');

                    errorDetect=false;
                }
            }while(!errorDetect);
            
        }while(nextCust); 
        
        //Finding the highest selling food
        highestfood=cb;
        if(highestfood<jh){ highestfood = jh; hfString="Jolly Hotdog";}
        if(highestfood<f){ highestfood = f; hfString="Fries";}
        if(highestfood<sg){ highestfood = sg; hfString="Sundae Glaze";}
        if(highestfood<fs){ highestfood = fs; hfString="Fried Siomai";}
        if(highestfood<sh){ highestfood = sh; hfString="Shawarma";}
        
        //Average sale per customer
        avgsale=totalsale/custCount;
        
        //Daily Report
        DailyReport dr = new DailyReport(totalsale, custCount, avgsale, highestfood, hfString);
        System.out.print('\u000C');
        System.out.print(dr.toString());
        
        System.out.print("\n\n Do you want to search & delete customer receipts? [Y/N] : ");
        String searchdel = s.nextLine();
        
        if(searchdel.equalsIgnoreCase("Y"))
        {
            do
            {
                System.out.print('\u000C');
                System.out.print("Enter the index number of customer you want to search : ");
                String sCust = s.nextLine();
                
                //For Delete Purposes
                String fileName = "Customer Receipt ["+sCust+"].txt";
                
                do
                {
                    try
                    {
                        infile=new BufferedReader(new FileReader("Customer Receipt ["+sCust+"].txt"));
                        
                        
                        String inData=null;
                        while((inData=infile.readLine())!=null)
                        {
                            System.out.println(inData);
                        }
                            
                        errorDetect = true;
                        infile.close();
                    }
                    catch (FileNotFoundException fnfe)   
                    {     System.out.println("File not found"); errorDetect = false; }         
                                                        
                    catch (IOException ioe)           
                    {   System.out.println(ioe.getMessage()); }        
                                                            
                    catch (Exception e)
                    {   System.out.println(e.getMessage());   }  
                    
                }while(!errorDetect);
                
                do
                {
                    System.out.print("\n Do you want to delete this receipt? [Y/N] : ");
                    String del = s.nextLine();
                    System.out.print('\u000C');
                    
                    if(del.equalsIgnoreCase("Y"))
                    {
                        try
                        {
                            Files.delete(Paths.get(fileName));
                        }
                        catch (FileNotFoundException fnfe)   
                        {     System.out.println("File not found");}
                        catch (IOException ioe)           
                        {   System.out.println(ioe.getMessage()); }        
                                                                
                        catch (Exception e)
                        {   System.out.println(e.getMessage());   }  
                        
                        System.out.println("\n xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("\n "+fileName+ " is deleted from your computer");
                        System.out.println("\n xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("\n\n Press Any Key to Continue...");
                        s.nextLine();
                        
                        errorDetect =true;
                    }
                    else if(del.equalsIgnoreCase("n")){errorDetect =true;}
                    else
                    {
                        System.out.println("\n xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println(" \t  Error!! Wrong input entered \n\t  Please Try Again!");
                        System.out.println(" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("\n\n Press Any Key to Continue...");
                        s.nextLine();
    
                        System.out.print('\u000C');
    
                        errorDetect=false;
                    }
                }while(!errorDetect);
                
                do
                {
                    System.out.print("\n Do you want to search another receipt? [Y/N] : ");
                    String del = s.nextLine();
                    System.out.print('\u000C');
                    
                    if(del.equalsIgnoreCase("Y"))
                    {
                        cycle=true;
                        errorDetect =true;
                    }
                    else if(del.equalsIgnoreCase("n")){cycle=false; errorDetect =true;}
                    else
                    {
                        System.out.println("\n xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println(" \t  Error!! Wrong input entered \n\t  Please Try Again!");
                        System.out.println(" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("\n\n Press Any Key to Continue...");
                        s.nextLine();
    
                        System.out.print('\u000C');
    
                        errorDetect=false;
                    }
                }while(!errorDetect);
                
                    
            }while(cycle);
            
        }
        System.out.println("\n Thank you for using this system! ");
        System.out.println("\n\n Press Any Key to Continue...");
        s.nextLine();
        System.exit(0);
        
        

        
    }

}