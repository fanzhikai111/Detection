package test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;

public class Test extends JFrame {

	private JPanel contentPane;
	private ChangeListener cl = new TimeNodeListener();
	private String maxTimeString = "0分钟";
	List<Object> bObjects=new ArrayList<Object>();
	JSlider timeSlide = new JSlider(0, 100, 0);
	JList<String> tpList = new JList<String>();
	JLabel timePoint = new JLabel();
	JScrollPane scrollPane = new JScrollPane();
	


	private JPanel timeLine;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {

		setTitle("fault injection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel v1 = new JPanel();
		contentPane.add(v1);
		v1.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		v1.add(panel);

		final JComboBox comboBox_startTime = new JComboBox();
		panel.add(comboBox_startTime);
		comboBox_startTime.setBorder(new TitledBorder(null, "故障开始时间",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		comboBox_startTime.setEditable(true);

		comboBox_startTime.setModel(new DefaultComboBoxModel(new String[] {
				"现在", "半小时后", "一小时后", "两小时后" }));

		final JComboBox comboBox_duration = new JComboBox();
		panel.add(comboBox_duration);
		comboBox_duration.setBorder(new TitledBorder(null, "故障持续时间",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		comboBox_duration.setEditable(true);
		comboBox_duration.setModel(new DefaultComboBoxModel(new String[] {
				"15分钟", "30分钟", "60分钟", "120分钟", "24小时", "48小时" }));

		JPanel panel_3 = new JPanel();
		v1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel();
		panel_3.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		lblNewLabel.setText("开始时间：" + sdf.format(new Date()) + "结束时间：sssss"
				+ "持续时间：" + comboBox_duration.getSelectedItem());

		comboBox_duration.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				maxTimeString = (String) comboBox_duration.getSelectedItem();

				comboBox_duration.getSelectedIndex();
				JSlider timeSlide = new JSlider();
				slider(maxTimeString);

			}

			private void slider(String maxTimeString) {

				timeSlide.setMinorTickSpacing(2);
				timeSlide.setMajorTickSpacing(20);
				timeSlide.setPaintTicks(true);
				timeSlide.setPaintLabels(true);
				timeSlide.setSnapToTicks(true);
				timeSlide.setFont(new Font("微软雅黑", Font.PLAIN, 12));
				timeSlide.setMaximum(100);
				timeSlide.setValue(0);

				// timeSlide.setPaintTrack(false);
				Dictionary<Integer, JComponent> timeLabel = new Hashtable<Integer, JComponent>();
				timeLabel.put(timeSlide.getMaximum(), new JLabel(maxTimeString));
				timeLabel.put(0, new JLabel("0"));
				timeSlide.setLabelTable(timeLabel);
			}
		});

		comboBox_startTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(comboBox_startTime.getSelectedItem());// 将参数传递给“故障开始时间参数”
				comboBox_startTime.getSelectedIndex();
			}
		});

		timeLine = new JPanel();
		timeLine.setBorder(new TitledBorder(null, "timeLine",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		contentPane.add(timeLine);
		timeLine.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "TimeLine", TitledBorder.LEFT,
				TitledBorder.BELOW_TOP, null, null));
		timeLine.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));

		panel_2.add(timeSlide);
		timeSlide.addChangeListener(cl);
		JPanel panel_1 = new JPanel();

		panel_2.add(panel_1);

		JButton confirm = new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				timeSlide.setValue(timeSlide.getMaximum());
				Iterator<Object> iterator = bObjects.iterator();  
			      
							while(iterator.hasNext())  
							{  
								Object object=iterator.next();
								if(object instanceof CpuWave){
									((CpuWave) object).execute();							
								}
								if(object instanceof MemWave){
									((MemWave) object).execute();		
								System.out.println("memwave完成");	
								}
							
//								while(!((CpuWave) object).){
//									
//								}
//							   continue;
							}			
				timeLine.remove(scrollPane);
				scrollPane = new JScrollPane(tpList);
				timeLine.add(scrollPane);
				timeLine.setVisible(false);
				timeLine.setVisible(true);
		
			}
		});
		panel_1.add(confirm);

		JButton addTime = new JButton("添加时间点");
		addTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_list_valueChanged();
			}

			
		});
		panel_1.add(addTime);

		JButton reset = new JButton("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("重置");
				
				bObjects.clear();
				
				fillPList();
				
				
			}
		});
		panel_1.add(reset);
		scrollPane.setEnabled(false);
		// SSLContext
		// JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		timeLine.add(scrollPane);

	}
	public void fillPList() {
//		
//		tpList = new JList(sssStrings);
		timeSlide.setValue(timeSlide.getMinimum());
////		timePoint.setText("创建时间节点" + timeSlide.getValue() + "ddd");
////		System.out.println("-------------" + timeSlide.getValue());
////		pList.add(maxTimeString+"的百分之"+timeSlide.getValue()*0.01);
		tpList=new JList(bObjects.toArray()) ;
		tpList.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(tpList.getSelectedValue());
				System.out.println(tpList.getSelectedIndex());
				do_list_valueChanged();

			}
		});
		timeLine.remove(scrollPane);
		scrollPane = new JScrollPane(tpList);
		timeLine.add(scrollPane);
		timeLine.setVisible(false);
		timeLine.setVisible(true);
	}
	protected int do_list_valueChanged() {

		Try1 window = new Try1("第"+(bObjects.size()+1)+"个阶段",this);
		window.frame.setVisible(true);
		return 0;
	}


	private class TimeNodeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			int time = timeSlide.getValue();

		}

	}
	
}
