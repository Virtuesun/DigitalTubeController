package deyang.li.digitaltube;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class DigitalTubeController extends JFrame implements DocumentListener {
	/**
	 * 主程序UI绘制类
	 */
	private static final long serialVersionUID = 1L;
	// 数码管显示组件
	private DigitalTube digitalTube;
	// 输入量提示
	private JLabel inputLabel;
	// 输出量提示
	private JLabel outputLabel;
	// 输入内容接收框
	private JTextField inputField;
	// 输出量显示框
	private JTextField outputField;
	// 0、1、2、3、4、5、6、7、8、9、A、b、C、d、E、F的显示码
	private static final String[] DIG_CODE = { "0xff", "0x3f", "0x06", "0x5b", "0x4f", "0x66", "0x6d", "0x7d", "0x07",
			"0x7f", "0x6f", "0x77", "0x7c", "0x39", "0x5e", "0x79", "0x71" };

	/**
	 * 构造方法内完成初始化
	 */
	public DigitalTubeController() {
		init();
	}

	/**
	 * 初始化组件、组件定位、添加监听
	 */
	private void init() {
		// 实例化数码管绘制类
		digitalTube = new DigitalTube();
		// 设置大小、位置
		digitalTube.setBounds(10, 0, 80, 200);
		// 工厂类生成右侧边框
		digitalTube.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));

		// 实例化并设置位置大小
		inputLabel = new JLabel("输入量：");
		inputLabel.setBounds(110, 30, 100, 20);

		outputLabel = new JLabel("输出量:");
		outputLabel.setBounds(110, 90, 100, 20);

		inputField = new JTextField(10);
		inputField.setBounds(150, 60, 100, 25);

		outputField = new JTextField(10);
		outputField.setBounds(150, 120, 100, 25);
		// 设置输出量不可编辑
		outputField.setEditable(false);

		// 获取document对象添加输入量文本内容改变监听
		Document doc = inputField.getDocument();
		doc.addDocumentListener(this);

		// 空布局绝对定位
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		// 添加组件到布局容器
		mainPanel.add(digitalTube);
		mainPanel.add(inputLabel);
		mainPanel.add(inputField);
		mainPanel.add(outputLabel);
		mainPanel.add(outputField);

		// 添加布局容器到主容器
		getContentPane().add(mainPanel);
		setTitle("DigitalTubeController");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 300, 200);
		// 设置窗口大小不可改变
		setResizable(false);
	}

	/**
	 * Frame组件更新方法
	 */
	private void updateFrame() {
		// 获取输入量
		String input = inputField.getText();
		// 设置输入量
		digitalTube.setInput(input);
		// 调用重绘方法
		digitalTube.repaint();

		// 设置输出量
		switch (input) {
		case "0":
			outputField.setText(DIG_CODE[0]);
			break;
		case "1":
			outputField.setText(DIG_CODE[1]);
			break;
		case "2":
			outputField.setText(DIG_CODE[2]);
			break;
		case "3":
			outputField.setText(DIG_CODE[3]);
			break;
		case "4":
			outputField.setText(DIG_CODE[4]);
			break;
		case "5":
			outputField.setText(DIG_CODE[5]);
			break;
		case "6":
			outputField.setText(DIG_CODE[6]);
			break;
		case "7":
			outputField.setText(DIG_CODE[7]);
			break;
		case "8":
			outputField.setText(DIG_CODE[8]);
			break;
		case "9":
			outputField.setText(DIG_CODE[9]);
			break;
		case "A":
		case "a":
			outputField.setText(DIG_CODE[10]);
			break;
		case "B":
		case "b":
			outputField.setText(DIG_CODE[11]);
			break;
		case "C":
		case "c":
			outputField.setText(DIG_CODE[12]);
			break;
		case "D":
		case "d":
			outputField.setText(DIG_CODE[13]);
			break;
		case "E":
		case "e":
			outputField.setText(DIG_CODE[14]);
			break;
		case "F":
		case "f":
			outputField.setText(DIG_CODE[15]);
			break;
		default:
			outputField.setText("");
			break;
		}

	}

	// 实现DocumentListener接口方法
	@Override
	public void changedUpdate(DocumentEvent e) {
		// 更新组件
		updateFrame();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateFrame();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateFrame();
	}
}
