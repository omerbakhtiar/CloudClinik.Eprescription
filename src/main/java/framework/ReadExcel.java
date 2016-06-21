package framework;
import helper.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ReadExcel {
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	String path = null;
	public static WebDriver driver;
	private String Title;
	private String Gender;
	private String FirstNam;
	private String Middle;
	private String Last;
	private int Age;
	private String Unit;
	private int prMobile;
	private String passsword;
	private String cPasssword;
	private String Mstatus;
	private String National;
	private String ID;
	private String country;
	private String state;
	private String City;
	private String BuildNm;
	private String SAddresss;
	private String Znumber;
	private int Secon;
	private int otrnum;
	private String email;

	public static ArrayList<ReadExcel> lst = new ArrayList<ReadExcel>();

	public ReadExcel(WebDriver driver) throws IOException {
		///CloudClinik.Eprescription/src/main/java/testdata
		path =  "D:\\cloudclinik-workspace\\CloudClinik.Eprescription\\src\\testdata.xlsx";
		System.out.println("file path :: " + path);
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public int getSheetRows(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);

		return sheet.getLastRowNum() + 1;
	}

	public int getSheetColumns(String sheetName) {

		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);

		row = sheet.getRow(0);
		return (row.getLastCellNum());
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);

		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		return cell.getStringCellValue();
	}

	public double getCellDataNumeric(String sheetName, int colNum, int rowNum) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);

		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		return cell.getNumericCellValue();
	}

	public void ReadData(int index) throws IOException {

		ReadExcel read = new ReadExcel(driver);

		read.Title = read.getCellData("LoginTest", 0, index);
		read.Gender = read.getCellData("LoginTest", 1, index);
		read.FirstNam = read.getCellData("LoginTest", 2, index);
		read.Middle = read.getCellData("LoginTest", 3, index);
		read.Last = read.getCellData("LoginTest", 4, index);
		read.Age = (int) read.getCellDataNumeric("LoginTest", 5, index);
		read.Unit = read.getCellData("LoginTest", 6, index);
		read.prMobile = (int) read.getCellDataNumeric("LoginTest", 7, index);
		read.passsword = read.getCellData("LoginTest", 8, index);
		read.cPasssword = read.getCellData("LoginTest", 9, index);
		read.Mstatus = read.getCellData("LoginTest", 10, index);
		read.National = read.getCellData("LoginTest", 11, index);
		read.ID = read.getCellData("LoginTest", 12, index);
		read.country = read.getCellData("LoginTest", 13, index);
		read.state = read.getCellData("LoginTest", 14, index);
		read.City = read.getCellData("LoginTest", 15, index);
		read.BuildNm = read.getCellData("LoginTest", 16, index);
		read.SAddresss = read.getCellData("LoginTest", 17, index);
		read.Znumber = read.getCellData("LoginTest", 18, index);
		read.Secon = (int) read.getCellDataNumeric("LoginTest", 19, index);
		read.otrnum = (int) read.getCellDataNumeric("LoginTest", 20, index);
		read.email = read.getCellData("LoginTest", 21, index);
		lst.add(read);
	}
  
	
	
	public void Call(int index) throws Exception {

		DatabseConnection dao = new DatabseConnection();
		Helper help =new Helper(driver);
		Thread.sleep(5000);
		Register first = new Register(driver);
		first.SelectTitle(lst.get(index).Title);
		first.SelectGender();
		first.SetFirstName(lst.get(index).FirstNam);
		first.SetLastName(lst.get(index).Last);
		first.setNationality(lst.get(index).National);
		first.SetAge(lst.get(index).Age);
		first.SetUnit(lst.get(index).Unit);
		first.setPassword(lst.get(index).passsword);
		first.setConfirmPassword(lst.get(index).cPasssword);
		first.setCountry(lst.get(index).country);
		first.selectState(lst.get(index).state);
		first.selectCity(lst.get(index).City);
		first.setId(lst.get(index).ID);
		first.setBuildingNumber(lst.get(index).BuildNm);
		first.setStreetAdress(lst.get(index).SAddresss);
		first.setZoneNumber(lst.get(index).Znumber);
		first.setMobileNumber(lst.get(index).prMobile);
		first.setOtherMobile(lst.get(index).otrnum);
		first.setSecondaryMoblie(lst.get(index).Secon);
		first.setEmail(lst.get(index).email);
		Thread.sleep(5000);
		first.clickProceed();
		Thread.sleep(5000);
		dao.readDataBase();
		help.WindowHandles();
		Thread.sleep(50000);
		driver.findElement(By.linkText("Enter account activation code")).click();
		Thread.sleep(50000);
		help.WindowHandles();
		driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:activationCodeDlgForm:ActivationCode")).sendKeys(DatabseConnection.activation_cod);
		driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:activationCodeDlgForm:CloudClinicNo")).sendKeys(DatabseConnection.cloudclinik_no);
        Thread.sleep(50000);	
        driver.findElement(By.id("_SignUp_WAR_CloudClinikportlet_:activationCodeDlgForm:SubmitButton")).click();
        
	
	}

	
	  public static void main(String[] args) throws Exception {
	  
	   //ReadExcel read = new ReadExcel(driver); read.ReadData(1);
	   //read.ReadData(2);
			DatabseConnection dao = new DatabseConnection();
			dao.readDataBase();
			System.out.println(DatabseConnection.activation_cod);
			System.out.println(DatabseConnection.cloudclinik_no);
		       
	  
	  }
	 

}
