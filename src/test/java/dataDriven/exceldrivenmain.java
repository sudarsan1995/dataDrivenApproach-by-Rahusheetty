package dataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class exceldrivenmain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExcelDriven excel=new ExcelDriven();
		ArrayList store=excel.getData("signup");
		
		System.out.println(store.get(0));
		System.out.println(store.get(1));
		System.out.println(store.get(2));
	
	}

}
