package test;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class V1 {
List<Object> bObjects=new ArrayList<Object>();
	public static  int type = 0;
	private JFrame frame;
	public static int target,startTime,duration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 window = new V1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public V1() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel v1 = new JPanel();
		frame.getContentPane().add(v1);
		v1.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel("\u6545\u969C\u76EE\u6807\uFF1A");
		v1.add(label);

		final JComboBox comboBox_target = new JComboBox();// 故障类型选择
		// comboBox_1.setBorder(BorderFactory.createTitledBorder("选择:"));

		comboBox_target.setModel(new DefaultComboBoxModel(new String[] { "CPU",
				"Mem", "I/O", "bus" }));

		comboBox_target.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(comboBox_target.getSelectedItem());// 将参数传递给“故障开始时间参数”

				target = comboBox_target.getSelectedIndex();
				// comboBox_1.
			}
		});

		v1.add(comboBox_target);
		JLabel label_1 = new JLabel("故障类型");
		v1.add(label_1);

		final JComboBox comboBox_type = new JComboBox();
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

		JLabel label_2 = new JLabel(
				"\u6545\u969C\u5F00\u59CB\u65F6\u95F4\uFF1A");
		v1.add(label_2);

		final JComboBox comboBox_startTime = new JComboBox();// 故障开始时间
		comboBox_startTime.setEditable(true);
		comboBox_startTime.setModel(new DefaultComboBoxModel(new String[] {
				"现在", "半小时后", "一小时后", "两小时后" }));

		comboBox_startTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(comboBox_startTime.getSelectedItem());// 将参数传递给“故障开始时间参数”
				startTime=comboBox_startTime.getSelectedIndex();
			}
		});
		v1.add(comboBox_startTime);

		JLabel label_3 = new JLabel(
				"\u6545\u969C\u6301\u7EED\u65F6\u95F4\uFF1A");
		v1.add(label_3);

		final JComboBox comboBox_duration = new JComboBox();
		comboBox_duration.setEditable(true);
		comboBox_duration.setModel(new DefaultComboBoxModel(new String[] {
				"15分钟", "30分钟", "60分钟", "120分钟", "24小时", "48小时" }));
		comboBox_duration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(comboBox_duration.getSelectedItem());// 将参数传递给“故障开始时间参数”
				duration=comboBox_duration.getSelectedIndex();
				System.out.println(duration);
			}
		});
		v1.add(comboBox_duration);
		JButton button = new JButton("\u786E\u5B9A");
		v1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CpuWave cpuWave= new CpuWave();

				try {
					CpuWave cpuWave = new CpuWave();
					Console console = new Console();
					cpuWave.execute();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton button_1 = new JButton("\u53D6\u6D88");
		v1.add(button_1);
		
		JLabel lblNewLabel = new JLabel("结束");
		v1.add(lblNewLabel);

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CpuWave cpuWave = new CpuWave();
			
				bObjects.add(cpuWave);
				Iterator<Object> iter = bObjects.iterator();  
		          
		       
		        while(iter.hasNext())  
		        {  
		           System.out.println(iter.next().toString()); 
		            
		        }  
			}
		});

	}

}

/**
 * Initialize the contents of the frame.
 */

