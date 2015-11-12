package test;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

public class MemWave extends SwingWorker<Integer, Object> {
	public static final double TIME = 1000;
	Console console=new Console();
//
//	/**
//	 * @param args
//	 *            the command line arguments
//	 * @throws InterruptedException
//	 * @throws IOException
//	 */
	@Override
	protected  Integer doInBackground() throws Exception {
		
		switch (Try1.type) {
		case 0:
			liner(System.currentTimeMillis(), console
					.selctedDuration(Try1.duration));
			break;
		case 1:
			break;
		case 2:
			constain(System.currentTimeMillis(), console
					.selctedDuration(Try1.duration));
			break;
		case 3:
		
			sin(System.currentTimeMillis(),(double)60*TIME);
			break;
		default:
			break;
		}
		;
		return 0;
		
	}
	
	@Override
	protected void done() {
		System.out.println("mem wave done");
	}
	
	private static void doSomeSimpleWork(double y) {

		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < y) {
		}
	}
	//cpu����ѡ���߱仯
	public void sin(long startInjection, Double duration) throws InterruptedException,
			IOException {
		Console.timestamp();// ��ʼʱ��
		double x = 0;
		double y = 0;
		while (System.currentTimeMillis() - startInjection < duration) {
			y = (Math.sin(x) + 1) * TIME / 2;
			doSomeSimpleWork(y);
			x += 0.1;
			Thread.sleep((long) (TIME - y));
		}
		Console.output("����ʱ��Ϊ ");
		Console.timestamp();// ����ʱ��
	}
	
	//cpuʹ����ά���ڹ̶�ֵ
    public void constain(long startInjection,Double duration) throws InterruptedException {
//        double x = 0;
        double y = 0;

        while (System.currentTimeMillis() - startInjection < duration) {
            y =  1000;
            doSomeSimpleWork(y);  
            Thread.sleep((long) (TIME - y));
        }
    }
    //cpuʹ������������
    public void liner(long startInjection,Double duration) throws InterruptedException {
//      double x = 0;
      double y = 0;

      while (System.currentTimeMillis() - startInjection < duration) {
    		while (y < 990) {
				y += 5;
				doSomeSimpleWork(y);
				Thread.sleep((long) (TIME - y));
			}
			doSomeSimpleWork(y);
      }
  }


}
