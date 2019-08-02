package importexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**    
*  
* @author liuweixin  
* @date 2019年4月3日 下午2:04:13  
*/
public class Test2 {
	static String[] name3 = {"MONTH_M","INVOICE_TO_DEALER","AVG_FINANCED_AMOUNT","PENETRATION","FINANCED_VOLUME_UNITS","FINANCED_VOLUMES","FINANCING_TERM_MONTH","PERIOD_END_OUTSTANDING"};
	static String[] name4 = {"MONTH_M","DEALER_SALE_TO_CUSTOMER","AVG_FINANCED_AMOUNT","PENETRATION","FINANCED_VOLUME_UNITS","FINANCED_VOLUMES","FINANCING_TERM_MONTH","PERIOD_END_OUTSTANDING"};
	static XSSFFormulaEvaluator eva = null;
	public static HashMap<String,String> sheetToMap(Sheet sheet){
		HashMap<String,String> map = new HashMap<String,String>();
		
		for(int i = 0; i < 5; i++) {
			int column = 15*i+1;
			String reportType = getMergedRegionValue(sheet, 1, column);
			map.put("REPORT_TYPE", reportType);
			String year = reportType.substring(0, 4);
			map.put("YEAR_YYYY",year);
			int row2 = 3;
			for(int j = 0; j < 7; j++) {
				String brand = getMergedRegionValue(sheet, row2, column);
				map.put("BRAND", brand);
				int row3 = row2 + 3;
				getColumn(map,sheet, column, column+12, row3, row3 + 7);
				getColumn(map,sheet, column, column+12, row3 + 9, row3 + 16);
				row2 += 25;
			}
			
		}
		return map;
	}
	
	
	public static void getColumn(HashMap<String,String> map,Sheet sheet,int startColumn,int endColumn, int startRow, int endRow){
		Row row = null;
		Cell cell = null;
		String value = null;
		int index = 0;
		int flag = 0;//用于标记Wholesale和Retail数据
		//按列读取数据
		for(int i = startColumn; i <= endColumn; i++) {//外循环列
			for(int j = startRow; j <= endRow; j++) {//内循环行
				row = sheet.getRow(j);
				cell = row.getCell(i);
				value = getCellValue(cell);//获得单元格值
				if(i != startColumn&& j == startRow ){//如果是月份，将英文月份转换为对应的数字，Jan-1,Feb-2...
					value = monthFormat(value);
				}
				
				if(i == startColumn) {
					if(j == startRow) {//根据第一列的第一个单元格判断类型
						
						if(value.equals("Dealer Financing")) {//如果是Dealer Financing(Wholesale)
							flag = 0;
							map.put("DEALER_SALE_TO_CUSTOMER", "");
							map.put("BUSINESS_TYPE", "Wholesale");
						}else if(value.equals("Retail Financing")){//如果是Retail Financing(Retail)
							flag = 1;
							map.put("INVOICE_TO_DEALER", "");
							map.put("BUSINESS_TYPE", "Retail");
						}else {
							
						}
					}
				}else {
					if(flag == 0) {
						map.put(name3[index++], value);
					}else {
						map.put(name4[index++], value);
					}
					
				}
			}
			if(i != startColumn) {
				System.out.println(map);
			}
			index = 0;
		}
	}
	
	//获取单元格值
	public static String getCellValue(Cell cell) {
		String strCell = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:// 字符串类型
				strCell = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:// 数字类型
				if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
					SimpleDateFormat sdf = null;
					sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date = cell.getDateCellValue();
					strCell = sdf.format(date);
				} else {
					strCell = String.valueOf(cell.getNumericCellValue());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:// boolean类型
				strCell = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_BLANK:
				strCell = "";
				break;
			case Cell.CELL_TYPE_FORMULA:
				try {
					strCell = String.valueOf(cell.getNumericCellValue());
				}catch(IllegalStateException e){
					strCell = "";
				}				
				break;
			default:
				strCell = "";
				break;
			}
		}
		if (strCell.equals("") || strCell == null) {
			strCell = "";
		}
		return strCell.trim();
	}
	
	//数值格式化
	public static String numberFormat(String format,double value) {
		return new DecimalFormat(format).format(value);
	}
	
	//月份转换
	public static String monthFormat(String month) {
		switch(month) {
		case "Jan":return "1";
		case "Feb":return "2";
		case "Mar":return "3";
		case "Apr":return "4";
		case "May":return "5";
		case "Jun":return "6";
		case "Jul":return "7";
		case "Aug":return "8";
		case "Sep":return "9";
		case "Oct":return "10";
		case "Nov":return "11";
		case "Dec":return "12";
		default:return null;
		}
	}
	//获取合并单元格的值
	public static String getMergedRegionValue(Sheet sheet, int row, int column) {

		int sheetMergeCount = sheet.getNumMergedRegions();

		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					Row fRow = sheet.getRow(firstRow);
					Cell fCell = fRow.getCell(firstColumn);
					return String.valueOf(getCellValue(fCell));
				}
			}
		}

		return null;
	}
	

	public static Workbook readExcel(String filePath) {
		Workbook wb = null;
		if (filePath == null) {
			return null;
		}
		String extString = filePath.substring(filePath.lastIndexOf("."));
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			if (".xls".equals(extString)) {
				return wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(extString)) {
				return wb = new XSSFWorkbook(is);
			} else {
				return wb = null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
	public static void main(String[] args) {
		Workbook wb = readExcel("C:/Users/a2433/Desktop/新建 Microsoft Excel 工作表 (3).xlsx");
		Sheet sheet = wb.getSheet("Geade");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		System.out.println(value);
		System.out.println("Dealer Name\n经销商名字");
		System.out.println(value.equals("Dealer Name\n经销商名字"));
	}
}
