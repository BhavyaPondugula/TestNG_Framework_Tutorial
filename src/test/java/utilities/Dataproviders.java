package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	@DataProvider(name="dataprovider")
	public Object[][] data() throws IOException{
		
		String path="C:\\Users\\kasim\\Documents\\testdata.xlsx";
		ExcelUtilities utilities=new ExcelUtilities(path);
		int row_count=utilities.getRowCount("sheet1");
		int col_count=utilities.getCloumnCount("sheet1",0);
		Object[][] data=new Object[row_count-1][col_count];
		for(int i=1;i<row_count;i++) {
			for(int j=0;j<col_count;j++) {
				data[i-1][j]=utilities.getCellData("sheet1",i,j);
				
			}
		}
		return data;
	}

}
