package tester;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenTestingWriting {

	public static void main(String[] args) throws IOException {
		
		
		// Create a FileOutputStream to write the Excel file at the given path
        FileOutputStream file = new FileOutputStream("/home/harshit/Downloads/selenium/abc/testData/myexcel.xlsx");

        // Create a new Excel workbook (.xlsx format)
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a new sheet named "seet2" in the workbook
        XSSFSheet sheet = workbook.createSheet("seet2");

        // Scanner to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user for the number of rows to be created
        System.out.println("Enter row number: ");
        int row = sc.nextInt();  // Total rows to be written

        // Ask the user for the number of cells (columns) per row
        System.out.println("Enter cell number: ");
        int cell = sc.nextInt();  // Total cells per row

        // Loop through each row from 0 to row-1
        for (int i = 0; i < row; i++) {

            // Create a new row in the sheet
            XSSFRow r1 = sheet.createRow(i);

            // Loop through each cell in the current row
            for (int j = 0; j < cell; j++) {

                // Create a cell at position j in the current row
                XSSFCell c2 = r1.createCell(j);

                // Ask user to enter a value for the cell
                System.out.println("Enter cell value: ");
                c2.setCellValue(sc.next());  // Set the entered value in the cell
            }
        }

        // Write all the entered data to the Excel file
        workbook.write(file);

        // Close the workbook and file to release resources
        workbook.close();
        file.close();
        sc.close();

        // Print confirmation message
        System.out.println("File is created..");
		 
		 
		 

		

	}

}
