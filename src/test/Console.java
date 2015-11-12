package test;

//import java.sql.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class Console {
	
	
	
	
	
	public static final double TIME = 1000;

	/**
	 * @param args
	 *            the command line arguments
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	long startInjection = System.currentTimeMillis();
	double duration = TIME;
	int wait = 0, dur = 0,type=0;
	Object object=null;
	Try1 try1;
	// 选择故障注入时间点
	public long selectItem(int wait) {
		switch (wait) {
		case 0:
			startInjection = System.currentTimeMillis();
			break;
		case 1:
			startInjection = System.currentTimeMillis() + 30 * (long) TIME;
			break;
		case 2:
			startInjection = System.currentTimeMillis() + 60 * (long) TIME;
			break;
		case 3:
			startInjection = System.currentTimeMillis() + 120 * (long) TIME;
		default:
			break;
		}
		return startInjection;
	}
	//选择故障持续时间
	public double selctedDuration(int dur) {
		switch (dur) {
		case 0:
			duration = 30 * TIME;
			break;
		case 1:
			duration = 30 * 60 * TIME;
			break;
		case 2:
			duration = 60 * 60 * TIME;
			break;
		case 3:
			duration = 120 * 60 * TIME;
			break;
		case 4:
			duration = 24 * 60 * 60 * TIME;
			break;
		case 5:
			duration = 48 * 60 * 60 * TIME;
			break;

		default:
			break;
		}
		return duration;
	}

	
	public static void selectedType(int type) {
		Object object=null;
		switch (type) {
		case 0:
			 object=new CpuWave();
			 System.out.println("cpu ready");
			break;
			
		case 1:
			 object=new MemWave();
			 System.out.println("mem ready");
			break;
		case 2:
			object=new IOWave();
			 System.out.println("Io ready");
			break;
		case 3:
			object=new BusWave();
			 System.out.println("bus ready");
			break;

		default:
			break;
		}
		
	}

public static void timestamp() throws IOException{
	Date date=new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String str=sdf.format(date);
	System.out.println(str);
	Console.output(str);
}

	public static void  output(String output) throws IOException {
		File f=new File("C:\\Users\\FAN\\Desktop\\file.txt");
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        System.out.println(output);
	}
}
