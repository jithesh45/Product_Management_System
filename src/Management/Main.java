package Management;
import java.util.Scanner;
import AdminManagement.*;
import CustomerReg.*;
import ProductManagement.*;

class Main 
{
	public static void main(String[] args) 
	{
		Scanner s =new Scanner(System.in);
		int ch,check=0,check1=0,check2=0;
		do
		{
			check=0;
			System.out.println("1.Admin\n2.Customer");
			ch=s.nextInt();
			if(ch==1)
			{
				Admin ad = new Admin();
				String hi = ad.checkadmin();
				if(hi=="ok")
				{
					System.out.println("Welcome ADMIN....");
					Product prd = new Product();
					do
					{
						check1=0;
						System.out.println("-----------------------");
						System.out.println("1.Add Product\n2.Update Product\n3.Search Product\n4.Print Product\n5.Delete Product\n Enter your Choice:");
						System.out.println("-----------------------");

						int pro_ch=s.nextInt();
						if(pro_ch==1)
						{
							prd.addprod();
						}
						else if(pro_ch==2)
						{
							prd.updateprod();
						}
						else if(pro_ch==3)
						{
							prd.searchprod();
						}
						else if(pro_ch==4)
						{
							prd.printprod();
						}
						else if(pro_ch==5)
						{
							prd.deleteprod();
						}
						else
						{
							System.out.println("Please Choose the Correct option....");
						}
						String adminchoice="yes";
						while(adminchoice.equals("yes"))
						{
							System.out.println("Do you want to continue again in Admin Mode(y/n) : ");
							adminchoice=s.next();
							adminchoice=adminchoice.toLowerCase();
							if(adminchoice.equals("y")||adminchoice.equals("yes"))
							{
								check1=1;
							}
							else
							{
								System.out.println("Thank You Vist Again...");
							}
						}
						
					}while(check1==1);
				}
				else
				{
					String managechoice="yes";
					while(managechoice.equals("yes"))
					{
						System.out.println("Do you want to continue(y/n) : ");
						managechoice=s.next();
						managechoice=managechoice.toLowerCase();
						if(managechoice.equals("y")||managechoice.equals("yes"))
						{
							check=1;
						}
						else
						{
							System.out.println("Thank You Vist Again...");
						}
					}
				}
				String managechoice="yes";
				while(managechoice.equals("yes"))
				{
					System.out.println("Do you want to continue this Application(y/n) : ");
					managechoice=s.next();
					managechoice=managechoice.toLowerCase();
					if(managechoice.equals("y")||managechoice.equals("yes"))
					{
						check=1;
					}
					else
					{
						System.out.println("Thank You Vist Again...");
					}
				}
			}
			else if(ch==2)
			{
				int check3=0;
				do
				{
				int con_choice=0;
				System.out.println("welcome customer...\n1.Login\n2.Register");
				con_choice=s.nextInt();
				Customer cr = new Customer();
				if(con_choice==1)
				{
					String hi = cr.login();
					if(hi=="ok")
					{
						System.out.println("Welcome CUSTOMER");
						Product prd = new Product();
						do
						{
							check2=0;
							System.out.println("-----------------------");
							System.out.println("1.Search Product\nEnter your Choice:");
							System.out.println("-----------------------");

							int pro_ch=s.nextInt();
							if(pro_ch==1)
							{
								prd.searchprod();
							}
							else
							{
								System.out.println("Please Choose the Correct option....");
							}
							String customerchoice="yes";
							while(customerchoice.equals("yes"))
							{
								System.out.println("Do you want to continue in Customer Mode(y/n) : ");
								customerchoice=s.next();
								customerchoice=customerchoice.toLowerCase();
								if(customerchoice.equals("y")||customerchoice.equals("yes"))
								{
									check2=1;
								}
								else
								{
									System.out.println("Thank You Vist Again...");
								}
							}
						}while(check2==1);
					}
					else
					{
						String managechoice="yes";
						while(managechoice.equals("yes"))
						{
							System.out.println("Do you want to continue(y/n) : ");
							managechoice=s.next();
							managechoice=managechoice.toLowerCase();
							if(managechoice.equals("y")||managechoice.equals("yes"))
							{
								check3=1;
							}
							else
							{
								System.out.println("Thank You Vist Again...");
							}
						}
					}
					String managechoice="yes";
					while(managechoice.equals("yes"))
					{
						System.out.println("Do you want to continue this Application(y/n) : ");
						managechoice=s.next();
						managechoice=managechoice.toLowerCase();
						if(managechoice.equals("y")||managechoice.equals("yes"))
						{
							check3=1;
						}
						else
						{
							System.out.println("Thank You Vist Again...");
						}
					}
				}
				else if(con_choice==2)
				{
					cr.reg();
				}
				else
				{
					System.out.println("Your choice is Wrong... Please Enter the Correct choice...");
				}
				}while(check3==1);
			}
			else
			{
				System.out.println("Please Enter the Correct choice...");
			}
		}while(check==1);
	}
}

