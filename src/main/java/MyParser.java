import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MyParser {
    private ArrayList<MyLine> tableStructure;

    public MyParser() {
        tableStructure = new ArrayList<MyLine>();
        infoPars();
    }

    private void infoPars() {
        File excelFile = new File("C:\\Users\\Dmitryi\\Downloads\\Data_Rev.xlsx");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIt = sheet.iterator();


        while (rowIt.hasNext()) {
            Row row = rowIt.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            int  number = 0;
            String a = "";
            String b = "";
            String c = "";
            int a2 = 0 ;
            int b2 = 0;
            int c2 = 0;

            DataFormatter formatter = new DataFormatter();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();


                number = number +1 ;
                if (number == 1){a2 = Integer.parseInt(formatter.formatCellValue(cell));
                }
                if (number == 2){
                    b2 = Integer.parseInt(formatter.formatCellValue(cell));
                };
                if (number == 3){
                    c2 = Integer.parseInt(formatter.formatCellValue(cell));
                  };

            }
            System.out.println("a =  "+ a2 + " | b = " + b2  +" | c = " + c2);
            number = 0;

            tableStructure.add(new MyLine(a2, b2, c2));
        }
    }


    public ArrayList<MyLine> getTableStructure() {
        return tableStructure;
    }
}
