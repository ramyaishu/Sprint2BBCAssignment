package Common;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Utility extends BaseClass
{
    public WebDriverWait wait;

    public void waitTimes(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void writeExcel(ArrayList<String> list1,ArrayList<String> list2) throws IOException {
        String path = "/Users/vanchinathanac/Desktop/SeleniumBBC/src/test/java/BBCExcel.xlsx";
        Row row;
        Cell cell;
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        int count=0;
        for(int i=0;i<list1.size();i++)
        {
            row=sheet.createRow(count);
            cell=row.createCell(0);
            cell.setCellValue(list1.get(i));
            cell=row.createCell(1);
            cell.setCellValue(list2.get(i));
            count++;
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        outputStream.close();
    }

    public void ScreenShot() throws IOException {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formatatter = new SimpleDateFormat("yyMMddHHmmssZ");
        String sdate = formatatter.format(date);
        TakesScreenshot shot = (TakesScreenshot) driver;
        File file = shot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("./ScreenShot/"+sdate+".png"));
    }
}
