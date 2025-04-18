package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	public FileInputStream file;
	public FileOutputStream Fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	DataFormatter formatter;
	
	public ExcelUtilities(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheet_name) throws IOException {
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheet_name);
		int row_count=sheet.getPhysicalNumberOfRows();
		return row_count;
	}
	
	public int getCloumnCount(String sheet_name,int row_no) throws IOException {
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheet_name);
		row=sheet.getRow(row_no);
		int col_count=row.getLastCellNum();
		return col_count;
		
		}
	
	public String getCellData(String sheet_name,int row_no, int col_no) throws IOException {
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheet_name);
		row=sheet.getRow(row_no);
		cell=row.getCell(col_no);
		formatter=new DataFormatter();
		String value=formatter.formatCellValue(cell);
//		Object value;
//		if(cell.getCellType().toString().equals("STRING")) {
//			value=cell.getStringCellValue();
//		}
//		else if(cell.getCellType().toString().equals("NUMERIC")) {
//			value=cell.getNumericCellValue();
//			
//		}
//		else {
//			value="Invalid Cell Value";
//		}
//		workbook.close();
//		file.close();
		return value;
	}
	
	public void writeCellData( String sheet_name,int row_no, int col_no, String cell_val) throws IOException {
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheet_name);
		row=sheet.getRow(row_no);
		if(row==null) {
			row=sheet.createRow(row_no);
		}
		cell=row.getCell(col_no);
		if(cell==null) {
			cell=row.createCell(col_no)	;
		}
		cell.setCellValue(cell_val);
		Fis=new FileOutputStream(path);
		workbook.write(Fis);
		workbook.close();
		Fis.close();
	}

}
