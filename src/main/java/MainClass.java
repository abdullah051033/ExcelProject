import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Programme started from main Method ....");
		//Link of this tutorial >>
		//https://www.youtube.com/watch?v=qT3qheuc9bU  [watch this video : Write Excell File in Java with Apache POI]
		//line added . please delete this line
		
		try {
			
	        ProductsModel pModel = new ProductsModel();
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("List Product");
			XSSFSheet sheet2 = workbook.createSheet("Produt Name");
			
			//creating Heading
			Row rowheading = sheet.createRow(0); 
			rowheading.createCell(0).setCellValue("ID");  
			rowheading.createCell(1).setCellValue("Name");
			rowheading.createCell(2).setCellValue("Creation Date");
			rowheading.createCell(3).setCellValue("Price");
			rowheading.createCell(4).setCellValue("Quantity");
			rowheading.createCell(5).setCellValue("Sub Total");
			
			for(int i=0; i< 6 ; i++) {
				CellStyle stylerowHeading = workbook.createCellStyle();
				Font font =  workbook.createFont();
				font.setBold(true);
				font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
				font.setFontHeightInPoints((short) 11);
				stylerowHeading.setFont(font);
				stylerowHeading.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
				stylerowHeading.setFillPattern(CellStyle.BRICKS);				
				stylerowHeading.setVerticalAlignment(CellStyle.ALIGN_CENTER);
				rowheading.getCell(i).setCellStyle(stylerowHeading); 
			}
			

			
			//From here we are creating second row immediate after the heading row that is why r = 1 instead of r=0
			int r = 1;
			for(Product p: pModel.findAll()) {
				
				Row row = sheet.createRow(r);
				Cell cellId =row.createCell(0);
				cellId.setCellValue(p.getId());
				
				Cell cellName = row.createCell(1);
				cellName.setCellValue(p.getName());
				
				Cell cellCreationDate = row.createCell(2);
				cellCreationDate.setCellValue(p.getCreationDate());
				
				CellStyle styleCreationDate = workbook.createCellStyle();
				XSSFDataFormat dfCreationDate = workbook.createDataFormat();
				styleCreationDate.setDataFormat(dfCreationDate.getFormat("m/d/yyyy"));
				cellCreationDate.setCellStyle(styleCreationDate);
				
				r++;
			}
			
			
			//Autofit cell size
			for(int i=0 ; i< 6; i++) {
				sheet.autoSizeColumn(i);
			}
			
			//Save to excell File
			FileOutputStream  FileOutPut = new FileOutputStream(new File("C:\\Users\\suman\\Desktop\\listProducts.xlsx"));
			workbook.write(FileOutPut);
			FileOutPut.close();
			System.out.println("Excell written Successfully ..... !!!!!!!!!!!!");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		

	}

}
