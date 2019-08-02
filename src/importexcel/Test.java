package importexcel;
/**    
*  
* @author liuweixin  
* @date 2019年4月2日 下午3:46:27  
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static HashSet<String> getColumnSet(String filePath, int column, int startRow, int endRow) {
		Workbook wb = readExcel(filePath); // 文件
		Sheet sheet = wb.getSheetAt(0); // sheet
		int rownum = sheet.getPhysicalNumberOfRows(); // 行数
		Row row = null;
		HashSet<String> result = new HashSet<>();
		String cellData = null;
		if (wb != null) {
			for (int i = startRow; i < endRow + 1; i++) {
				System.out.println(i);
				row = sheet.getRow(i);
				for (int j = 0; j < column + 1; j++) {
					if (row != null) {
						cellData = (String) getCellValue(row.getCell(column));

					} else {
						break;
					}
					// System.out.println(cellData);
				}

			}
		}
		return result;
	}

	public static HashSet<String> getColumnSet(String filePath, int column, int startRow) {
		Workbook wb = readExcel(filePath); // 文件
		Sheet sheet = wb.getSheetAt(0); // sheet
		// System.out.println("自己："+(String)
		// getCellFormatValue(sheet.getRow(1).getCell(1)));
		// System.out.println("合并单元格数："+sheet.getNumMergedRegions());
		// System.out.println("指定："+getMergedRegionValue(sheet,1,1));
		int rownum = sheet.getPhysicalNumberOfRows(); // 行数
		System.out.println("sumrows " + rownum);

		return getColumnSet(filePath, column, startRow, 22);
	}

	/*
	 * public static Object getCellFormatValue(Cell cell){ Object cellValue = null;
	 * if(cell!=null){ //判断cell类型 switch(cell.getCellType()){ case
	 * Cell.CELL_TYPE_NUMERIC:{ cell.setCellType(Cell.CELL_TYPE_STRING);
	 * //将数值型cell设置为string型 cellValue = cell.getStringCellValue();
	 * //System.out.println(String.valueOf(cellValue)); break; } case
	 * Cell.CELL_TYPE_FORMULA:{ //判断cell是否为日期格式
	 * if(DateUtil.isCellDateFormatted(cell)){ //转换为日期格式YYYY-mm-dd cellValue =
	 * cell.getDateCellValue(); //System.out.println(String.valueOf(cellValue));
	 * }else{ //数字 cellValue = String.valueOf(cell.getNumericCellValue());
	 * //System.out.println(String.valueOf(cellValue)); } break; } case
	 * Cell.CELL_TYPE_STRING:{ cellValue =
	 * cell.getRichStringCellValue().getString();
	 * //System.out.println(String.valueOf(cellValue)); break; } default: cellValue
	 * = ""; //System.out.println(cellValue); } }else{ cellValue = ""; } return
	 * cellValue; }
	 */
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
					// strCell = numberFormat("0.00",cell.getNumericCellValue());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:// boolean类型
				strCell = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_BLANK:
				strCell = "";
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

	/**
	 * 获取合并单元格的值
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static String getMergedRegionValue(Sheet sheet, int row, int column) {

		int sheetMergeCount = sheet.getNumMergedRegions();

		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			// System.out.println("firstRow:"+firstRow);
			// System.out.println("lastRow:"+lastRow);
			//
			// System.out.println("firstColumn："+firstColumn);
			// System.out.println("lastColumn："+lastColumn);

//			if (row >= firstRow && row <= lastRow) {
//				if (column >= firstColumn && column <= lastColumn) {
//					Row fRow = sheet.getRow(firstRow);
//					Cell fCell = fRow.getCell(firstColumn);
//					return String.valueOf(getCellValue(fCell));
//				}
//			}

			Row fRow = sheet.getRow(firstRow);
			Cell fCell = fRow.getCell(firstColumn);
			System.out.println("第"+firstRow+"行，第"+firstColumn+"列:" + String.valueOf(getCellValue(fCell)));
		}

		return null;
	}

	public static String numberFormat(String format, double value) {
		return new DecimalFormat(format).format(value);
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
		//HashSet<String> columnSet = Test.getColumnSet("C:/Users/a2433/Desktop/新建 Microsoft Excel 工作表 (2).xlsx", 0, 0); // 读取第一列的从第90行开始往后的数据
																														// 到set
		//System.out.println(columnSet.size());
		//System.out.println(columnSet.toString());
		Workbook wb = readExcel("C:/Users/a2433/Desktop/新建 Microsoft Excel 工作表 (2).xlsx");
		Sheet sheet = wb.getSheetAt(0);
		getMergedRegionValue(sheet, 0, 0);
	}
}
