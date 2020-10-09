package com.atmecs.phptravels.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.phptravels.constants.Constants;
import com.atmecs.phptravels.testsuit.BaseTest;

public class DataProviderClass extends BaseTest {

	@DataProvider(name = "Data")
	public static Object[][] getData() throws IOException {
		ExcelData xls = new ExcelData(Constants.Excel_file);
		Object[][] data = xls.readExcelData("DataSheet");
		return data;

	}
}