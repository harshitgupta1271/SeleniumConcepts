package tester;

//Importing necessary classes for file handling and Excel reading
import java.io.FileInputStream;  // To read data from a file input stream
import java.io.IOException;      // To handle input/output exceptions

//Importing Apache POI classes for handling Excel .xlsx files
import org.apache.poi.xssf.usermodel.XSSFCell;     // Represents a cell in an Excel sheet
import org.apache.poi.xssf.usermodel.XSSFRow;      // Represents a row in an Excel sheet
import org.apache.poi.xssf.usermodel.XSSFSheet;    // Represents a sheet in an Excel workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // Represents the Excel workbook

public class dataDrivenTesting {

	public static void main(String[] args) throws IOException {
		
		
		
		  // Create a file input stream to read the Excel file from the specified path
        FileInputStream file = new FileInputStream("/home/harshit/Downloads/selenium/abc/testData/book_data.xlsx");
        
        // Create a workbook instance that refers to the .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Get the first sheet from the workbook (you can use sheet name or index)
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Get the number of the last row (zero-based index)
        int row = sheet.getLastRowNum();

        // Get the number of cells (columns) in the second row (index 1)
        int cell = sheet.getRow(1).getLastCellNum();  // Returns column count (1-based)

        // Print total number of rows and columns
        System.out.println("Row Numbers: " + row);
        System.out.println("Cell Numbers: " + cell);

        // Loop through each row
        for (int i = 0; i <= row; i++) {
            // Get the current row
            XSSFRow row2 = sheet.getRow(i);

            // Loop through each cell in the current row
            for (int j = 0; j < cell; j++) {
                // Get the current cell
                XSSFCell cell2 = row2.getCell(j);

                // Print the value in the cell, converted to string
                System.out.print(cell2.toString() + "    ");
            }

            // Print a new line after each row
            System.out.println();
        }

        // Close the workbook and file input stream to release resources
        workbook.close();
        file.close();
	      
		
		  
	}

}
