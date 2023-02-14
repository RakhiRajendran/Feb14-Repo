package utilityPack;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReadUtility {
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public static String stringDataRead(int row, int col) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\DataBase.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(row);
		Cell c = r.getCell(col);
		return c.getStringCellValue();
	}

}
