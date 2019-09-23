package com.cashe.mobile.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Config {

	//Points to config excel preoperties required to read file
	public static String configPath="C:\\Users\\user\\Desktop\\MyCashe\\src\\test\\resources\\config\\config.xml.xlsx";
	public static String deviceSheetName="DeviceSheet";
	public static String query = "select * from "+deviceSheetName;
	
	//Device List Initialisation
	public static List<HashMap<String, String>> deviceList=new ArrayList<HashMap<String, String>>();
	public static HashMap<String, String> deviceData=new HashMap<String,String>();
	
	static
	{
		File conFile= new File(configPath);
		
		if(conFile.exists())
		{
			Fillo fillo= new Fillo();
			try {
				Connection conn = fillo.getConnection(configPath);
				Recordset recordSet=conn.executeQuery(query);
				
				while(recordSet.next() && recordSet.getField("Device Name")!="")
				{
					HashMap<String, String> tempList= new HashMap<String,String>();
					for(int i=0;i<recordSet.getFieldNames().size();i++)
					{
						tempList.put(recordSet.getFieldNames().get(i), recordSet.getField(recordSet.getFieldNames().get(i)));
					}
					deviceList.add(tempList);
				}
				
				
				
			} catch (FilloException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception at reading Excel Device List: "+e.getLocalizedMessage());
			}
		}
		
	}
	
	public static synchronized HashMap<String, String> getDeviceData()
	{	
		HashMap<String, String> temp= new HashMap<String,String>();
		
		for(HashMap<String, String> device:deviceList)
		{
			deviceData=device;
			temp=device;
		}
		
		return temp;
		
	}
	
	public static void main(String[] args) {
		HashMap<String, String> deviceData=Config.deviceList.get(0);
		System.out.println(deviceData.get("URL"));
		
	}
	

}
