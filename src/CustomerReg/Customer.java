package CustomerReg;
import java.sql.*;
import java.util.Scanner;

public class Customer 
{
	public long cphnum,cpin;
	public String cfname,clname,caddrs,cmail;
	Scanner sc = new Scanner(System.in);
	public void reg()
	{
		try
		{
			System.out.println("Enter Your First Name : ");
			cfname=sc.nextLine();
			System.out.println("Enter Your Last Name : ");
			clname=sc.nextLine();
			System.out.println("Enter Your Phone Number :(Number Should be in 10 digits...)");
			cphnum=sc.nextLong();
			System.out.println("Enter Your Address : ");
			caddrs=sc.next();
			System.out.println("Enter Your Pincode : ");
			cpin=sc.nextLong();
			System.out.println("Enter Your Email ID : ");
			cmail=sc.next();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagement","root","jithesh@1998");
			PreparedStatement ps=con.prepareStatement("insert into customerdetails values(?,?,?,?,?,?)");
			ps.setString(1,cfname);
			ps.setString(2,clname);
			ps.setLong(3,cphnum);
			ps.setString(4,caddrs);
			ps.setLong(5,cpin);
			ps.setString(6,cmail);
			ps.executeUpdate();
			con.close();
			System.out.println("Customer Detail Saved...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public String login()
	{
		String ok="";
		try
		{
			System.out.println("Login");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagement","root","jithesh@1998");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from customerdetails");
			while(rs.next())
			{
				int check=0,check1=0;
				do
				{
					check=0;
					System.out.println("Please enter your username : ");
					String customer_username = sc.next();
					if(customer_username.equals(rs.getString(1)))
					{
						do
						{
							check1=0;
							System.out.println("Please enter your phone number : ");
							String customer_phonenumber = sc.next();
							if(customer_phonenumber.equals(rs.getString(3)))
							{
								System.out.println("Login Sucessfully!...");
								ok="ok";
							}
							else
							{
								System.out.println("Wrong Phone number...");
								String phonenumberwrong="yes";
								while(phonenumberwrong.equals("yes"))
								{
									System.out.println("Do you want to retype the phone number(y/n) : ");
									phonenumberwrong=sc.next();
									phonenumberwrong=phonenumberwrong.toLowerCase();
									if(phonenumberwrong.equals("y")||phonenumberwrong.equals("yes"))
									{
										check1=1;
									}
									else
									{
										ok= "ok1";
									}
								}
							}
						}while(check1==1);
					}
					else
					{
						System.out.println("Wrong Username...");
						String usernamewrong="yes";
						while(usernamewrong.equals("yes"))
						{
							System.out.println("Do you want to retype the username(y/n) : ");
							usernamewrong=sc.next();
							usernamewrong=usernamewrong.toLowerCase();
							if(usernamewrong.equals("y")||usernamewrong.equals("yes"))
							{
								check=1;
							}
							else
							{
								ok= "ok1";
							}
						}
					}
				}while(check==1);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ok;
	}
}
