package Generic_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.seleniumhq.jetty9.server.NCSARequestLog;

public class XL {
	public static String getdata (String path, String sheet, int r ,int c) throws FileNotFoundException, IOException, EncryptedDocumentException {
	 String v= " ";
	 try {
		 Workbook wb= WorkbookFactory.create(new FileInputStream(path));
		 v= wb.getSheet(sheet).getRow(r).getCell(c).toString();
		 System.out.println(" Cell value "+ v);
	 } catch (Exception e) {
		 e.printStackTrace();				 
	 }
		return v;
	}

}
