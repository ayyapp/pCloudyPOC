package com.cash.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.cashe.base.BasePage;

public class DataBaseConnection extends BasePage {
	
	public static Connection conn=null;
	public static Statement st=null;
	public static ResultSet rs=null;
	public static String platformName=null;
	
	public DataBaseConnection(String platformNm)
	{
		DataBaseConnection.platformName=platformNm;
	}
	
	public static Connection connection() throws Exception {
		// TODO Auto-generated constructor stub
		try {
			System.out.println("tetet");
			Class.forName("org.mariadb.jdbc.Driver");
			//conn = DriverManager.getConnection(pro.getProperty("db"), pro.getProperty("db_username"), pro.getProperty("db_password"));
			conn = DriverManager.getConnection("jdbc:mariadb://172.16.0.49:3306/pcloudy_sample","swapna","password");
			System.out.println("donee");
			logger.debug("Database Connection Established Successfully...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Database Connection Terminated... "+e.getLocalizedMessage());
		}
		 
		return conn;
		
	}
	
	public static String getObject(String object,String PageName) throws Exception
	{
		
		String query="select * from pcloudy_sample.pcloudy_object_repo where Page_Name='"+PageName+"' AND Object_Name='"+object+"';";
		conn=connection();
		System.out.println("Connectio is ::"+conn);
		st = conn.createStatement();
		System.out.println("statment is ::"+st);
		rs=st.executeQuery(query);
		String xPath="";
		while(rs.next())
		{
			if(platformName.equalsIgnoreCase("Android"))
				{
				xPath=rs.getString("Android_Locator");
				System.out.println("Returning Android Xpath as "+xPath);
				}
			else if(platformName.equalsIgnoreCase("iOS"))
			{
				xPath=rs.getString("iOS_Locator");
				System.out.println("Returning iOS Xpath as "+xPath);
			}
			else
				throw new Exception();
		}
		return xPath;
	}
	
	
	//Fetching data from DB
	public List<String> dataBaseSelect(String sql){
		List<String> DataResponse = new ArrayList<String>();
		Connection conn = null; 
		String q;
		initilize();
		//System.out.println("NAme is:"+ pro.getProperty("db_username"));
		/*Properties pro=new Properties();
		try {
			pro.load(new FileInputStream(System.getProperty("user.dir") +"/src/main/resources/properties/constant.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//conn = DriverManager.getConnection(pro.getProperty("db"), pro.getProperty("db_username"), pro.getProperty("db_password"));
			conn = DriverManager.getConnection("jdbc:mariadb://172.16.3.226:3306/pcloudy_sample","swapna","password");

			logger.debug("Database Connection Established Successfully...");
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);
			logger.debug("Result Set :::" + rs);
			rs.beforeFirst();
			ResultSetMetaData md = rs.getMetaData();
			int colCount = md.getColumnCount();
			logger.debug("SQl query ::: " + sql);
			logger.debug("Number of Columns ::: " + colCount);

			if (rs.next())
			{
				do{ 
					for (int j = 1; j<=colCount;j++)
					{
						q = rs.getString(j);
						DataResponse.add(q);
					}

				}while(rs.next());
			}
			//closing DB connection
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Message : " + e.getMessage());
		}
		//System.out.println("In function"+DataResponse);
		return DataResponse ;

	}

	//Upadating data into DB 
	public void dataBaseUpdate(String query){
		Connection conn = null; 

		initilize();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(pro.getProperty("db"), pro.getProperty("db_username"), pro.getProperty("db_password"));
			logger.debug("Database Connection Established Successfully...",true);
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			logger.debug("SQl query ::: " + query);
			logger.debug("Query executed");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Message : " + e.getMessage());
		}
	}
	
	

}
