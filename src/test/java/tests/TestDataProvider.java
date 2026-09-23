package tests;

import org.testng.annotations.DataProvider;
import utils.ExcelReader;

import java.io.IOException;

public class TestDataProvider {
    @DataProvider(name="loginData")
    public Object[][] getLoginData() throws IOException{
        return ExcelReader.getExcelData("D://Notes-For-Interview//projects//POM_testNG//src//main//resources//testdata//LoginData.xlsx","LoginData");

    }


}
