package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Try1 {
	Object[] sssObjects;
	Object object;
	JDialog frame;
	int i=1;
	private JPanel contentPane;
	public static  int type = 0;
	private Test mainFrame;
	
	public static int target,startTime,duration;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Try1(String string,Test mainFrame) {
		this.mainFrame=mainFrame;
		initialize(string);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String integer) {
		frame = new JDialog(mainFrame,true);
		frame.setTitle(integer);
		frame.setBounds(100, 100, 450, 300);
		frame.setBounds(// 让新窗口与Swing7窗口示例错开50像素。
				new Rectangle(
						(int) frame.getBounds().getX() + 50,
						(int) frame.getBounds().getY() + 50, 
						(int) frame.getBounds().getWidth(), 
						(int) frame.getBounds().getHeight()
				)
			);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel v1 = new JPanel();
		panel.add(v1);
		
		
	
		v1.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 5, 5));

		final JComboBox comboBox_target = new JComboBox();// 故障类型选择
		comboBox_target.setBorder(new TitledBorder(null, "故障目标：",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		comboBox_target.setModel(new DefaultComboBoxModel(new String[] { 
				"内存注入","CPU", "I/O", "bus" }));	
		comboBox_target.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(comboBox_target.getSelectedItem());// 将参数传递给“故障开始时间参数”
				
				target=comboBox_target.getSelectedIndex();
				// comboBox_1.
				switch (target) {
				case 0:
					object=new MemWave();
					 System.out.println("mem ready");
					break;
					
				case 1:
					 
					 object=new CpuWave();
					 System.out.println("cpu ready");
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
		});

		v1.add(comboBox_target);

		final JComboBox comboBox_type = new JComboBox();
		comboBox_type.setBorder(new TitledBorder(null, "故障类型：",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		comboBox_type.setModel(new DefaultComboBoxModel(new String[] { "线性增加",
				"指数增加", "恒定值", "正弦变化" }));
		comboBox_type.setToolTipText("\u7EBF\u6027b\r\n");
		
		comboBox_type.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(comboBox_type.getSelectedItem());
				type=comboBox_type.getSelectedIndex();
				

			}
		});
		v1.add(comboBox_type);

		
	
	
		JButton button = new JButton("\u786E\u5B9A");
		v1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CpuWave cpuWave= new CpuWave();

				try {
//					CpuWave cpuWave = new CpuWave();
//					
//					String string="第"+i+"个阶段";
//					i=i++;
//					
//					mainFrame.map.put(string, cpuWave);
//					frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING) );
//					System.out.println(mainFrame.map);
//					for (String key : mainFrame.map.keySet()) {  
//						  
//					    Object value = mainFrame.map.get(key);  
//					  
//					    System.out.println("Key = " + key +"ddd"+value.toString());  
//					  
//					}  
//					mainFrame.fillPList();
//					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	

		JButton button_1 = new JButton("\u53D6\u6D88");
		v1.add(button_1);
		
		JLabel lblNewLabel = new JLabel();
		frame.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Console console=new Console();
//				CpuWave cpuWave = new CpuWave();
				mainFrame.bObjects.add(object);
				frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING) );
				mainFrame.fillPList();
				Iterator<Object> iter = mainFrame.bObjects.iterator();  
				  
      
				while(iter.hasNext())  
				{  
				   System.out.println(iter.next().toString()); 
				}
			}
		});

	}


		
}
