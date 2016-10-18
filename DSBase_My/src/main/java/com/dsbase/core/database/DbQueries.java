package com.dsbase.core.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;

public class DbQueries 
{	
	private static String queriesPath = "C:\\Selenium_TestData\\Projects\\DSBase\\SQL\\SQL_Queries\\";
	
	public static class DrugRegistryTests
	{
		public static class DrugQueries
		{
			public static class DeletionQueries
			{
				public static class DrugDeletion
				{
					// ����������� ������, ������� ����� �������� � ������ ������� �������
				    public static final String ErrorMessage = "\r\n\r\n��������� ������ ��� ������� �������� ���������.\r\n����� ������:\r\n";
	 
				    // ����������� ������ �������
				    public static String DrugDeletionStatement = readFile(queriesPath + "drug_deletion.sql");
				}
				
				public static class InstructionDeletion
				{
					// ����������� ������, ������� ����� �������� � ������ ������� �������
				    public static final String ErrorMessage = "\r\n\r\n��������� ������ ��� ������� �������� ���������� ���������.\r\n����� ������:\r\n";
	 
				    // ����������� ������ �������
				    public static String InstructionDeletionStatement = readFile(queriesPath + "instruction_deletion.sql");
				}
				
				public static class ChangeDeletion
				{
					// ����������� ������, ������� ����� �������� � ������ ������� �������
				    public static final String ErrorMessage = "\r\n\r\n��������� ������ ��� ������� �������� ��������� ���������.\r\n����� ������:\r\n";
	 
				    // ����������� ������ �������
				    public static String ChangeDeletionStatement = readFile(queriesPath + "drug_change_deletion.sql");
				}
				
				public static class ReferentDrugsDeletion
				{
					// ����������� ������, ������� ����� �������� � ������ ������� �������
				    public static final String ErrorMessage = "\r\n\r\n��������� ������ ��� ������� �������� ����������� ��.\r\n����� ������:\r\n";
	 
				    // ����������� ������ �������
				    public static String RefDrugsDeletionStatement = readFile(queriesPath + "reference_drugs_deletion.sql");
				}
			}
		}
	}
	
	public static class DictionaryTests
	{
		public static class ManufacturersQueries
		{
			public static class DeletionQueries
			{
				public static class ManufacturerDeletion
				{
					// ����������� ������, ������� ����� �������� � ������ ������� �������
				    public static String ErrorMessage = "\r\n\r\n��������� ������ ��� ������� �������� �������������.\r\n����� ������:\r\n";
	 
				    // ����������� ������ �������
				    public static String ManufacturerDeletionStatement = "delete from [dbo].[drug_manufacturer] " +
				    						   				      		 "where manufacturer_en = 'For automation'";
				    
				    // ����������� ������ �������
				    public static String DrugManufacturerDeletionStatement = "delete from [dbo].[drug_manufacturer] " +
				    						   				      		 "where manufacturer_en = 'For drugAdd'";
				}
			}
		}
		public static class DeclarersQueries
		{
			public static class DeletionQueries
			{
				public static class DeclarerDeletion
				{
					// ����������� ������, ������� ����� �������� � ������ ������� �������
				    public static String ErrorMessage = "\r\n\r\n��������� ������ ��� ������� �������� ���������.\r\n����� ������:\r\n";
	 
				    // ����������� ������ �������
				    public static String DeclarerDeletionStatement = "delete from [dict].[dic_declarer] " +
				    						   				      	 "where declarer_en = 'For automation'";
				    
				    // ����������� ������ �������
				    public static String DrugDeclarerDeletionStatement = "delete from [dict].[dic_declarer] " +
				    						   				      	 	 "where declarer_en = 'For drugAdd'";
				}
			}
		}
	}
	
	public static class AdministrationTests
	{
		public static class UsersAndAuditQueries
		{
			public static class DeletionQueries
			{
				// ����������� ������, ������� ����� �������� � ������ ������� �������
			    public static final String ErrorMessage = "\r\n\r\n��������� ������ ��� ������� �������� ������������.\r\n����� ������:\r\n";
 			 			    
			    // ����������� ������ �������
			    public static String UserDeletionStatement = readFile(queriesPath+ "user_deletion.sql");
			}
		}
	}
	
	// ��������� ����� �� �����
	private static String readFile(String path)
	{
		File file = new File(path);
		Reader input = null;
		StringWriter output = new StringWriter();
		try 
		{
			input = new FileReader(file);
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
			Assert.fail("�� ������� ����� ���� ��� ������� ����������� SQL �������.");
		}
		try 
		{
		  IOUtils.copy(input, output);
		  input.close();
		}	  
		catch (Exception e) 
	    {
			e.printStackTrace();
	    }
		String fileContents = output.toString();
		return fileContents;
	}
}
