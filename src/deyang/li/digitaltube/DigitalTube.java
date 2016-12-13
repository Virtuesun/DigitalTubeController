package deyang.li.digitaltube;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class DigitalTube extends JComponent {

	/**
	 * 数码管“8”字图案绘制类
	 */
	private static final long serialVersionUID = 1L;

	// 输入量
	private String input;
	// 绘图起始位置X坐标
	private static final int X = 10;
	// 绘图起始位置Y坐标
	private static final int Y = 30;
	// 绘制图形宽度
	private static final int WIDTH = 50;
	// 绘制图形线段宽度
	private static final int LINEWIDTH = 5;

	/**
	 * 自定制绘图方式
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(LINEWIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		displayDigital(input, g2d);
	}

	/**
	 * 用于绘制一条确定的线段
	 * 
	 * @param x1
	 *            线段起始位置x坐标
	 * @param y1
	 *            线段起始位置y坐标
	 * @param x2
	 *            线段结束位置x坐标
	 * @param y2线段结束位置y坐标
	 * @param color
	 *            当前线段颜色
	 * @param g2d
	 *            绘图Graphics2D对象
	 */
	private void drawLine(int x1, int y1, int x2, int y2, Color color, Graphics2D g2d) {
		g2d.setColor(color);
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		g2d.draw(line);
	}

	/**
	 * 根据给定颜色绘制“8”字图案
	 * 
	 * @param colors
	 *            7条线段对应的颜色 线段编号从上到下，从左到右
	 * @param g2d
	 *            绘图Graphics2D对象
	 */
	private void drawDigital(Color[] colors, Graphics2D g2d) {
		drawLine(X + LINEWIDTH, Y, X + WIDTH - LINEWIDTH, Y, colors[0], g2d);
		drawLine(X, Y + LINEWIDTH, X, Y + WIDTH - LINEWIDTH, colors[1], g2d);
		drawLine(X + WIDTH, Y + LINEWIDTH, X + WIDTH, Y + WIDTH - LINEWIDTH, colors[2], g2d);
		drawLine(X + LINEWIDTH, Y + WIDTH, X + WIDTH - LINEWIDTH, Y + WIDTH, colors[3], g2d);
		drawLine(X, Y + WIDTH + LINEWIDTH, X, Y + 2 * WIDTH - LINEWIDTH, colors[4], g2d);
		drawLine(X + WIDTH, Y + WIDTH + LINEWIDTH, X + WIDTH, Y + 2 * WIDTH - LINEWIDTH, colors[5], g2d);
		drawLine(X + LINEWIDTH, Y + 2 * WIDTH, X + WIDTH - LINEWIDTH, Y + 2 * WIDTH, colors[6], g2d);
	}

	/**
	 * 依据输入量确定所绘制图形颜色
	 * 
	 * @param input
	 *            输入量
	 * @param g2d
	 *            绘图Graphics2D对象
	 */
	private void displayDigital(String input, Graphics2D g2d) {
		Color[] colors = new Color[7];
		if (input == null || input.trim().equals("")) {
			colors[0] = Color.gray;
			colors[1] = Color.gray;
			colors[2] = Color.gray;
			colors[3] = Color.gray;
			colors[4] = Color.gray;
			colors[5] = Color.gray;
			colors[6] = Color.gray;
			drawDigital(colors, g2d);
			return;
		}
		switch (input) {
		case "0":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.red;
			colors[3] = Color.gray;
			colors[4] = Color.red;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "1":
			colors[0] = Color.gray;
			colors[1] = Color.gray;
			colors[2] = Color.red;
			colors[3] = Color.gray;
			colors[4] = Color.gray;
			colors[5] = Color.red;
			colors[6] = Color.gray;
			drawDigital(colors, g2d);
			break;
		case "2":
			colors[0] = Color.red;
			colors[1] = Color.gray;
			colors[2] = Color.red;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.gray;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "3":
			colors[0] = Color.red;
			colors[1] = Color.gray;
			colors[2] = Color.red;
			colors[3] = Color.red;
			colors[4] = Color.gray;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "4":
			colors[0] = Color.gray;
			colors[1] = Color.red;
			colors[2] = Color.red;
			colors[3] = Color.red;
			colors[4] = Color.gray;
			colors[5] = Color.red;
			colors[6] = Color.gray;
			drawDigital(colors, g2d);
			break;
		case "5":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.gray;
			colors[3] = Color.red;
			colors[4] = Color.gray;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "6":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.gray;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "7":
			colors[0] = Color.red;
			colors[1] = Color.gray;
			colors[2] = Color.red;
			colors[3] = Color.gray;
			colors[4] = Color.gray;
			colors[5] = Color.red;
			colors[6] = Color.gray;
			drawDigital(colors, g2d);
			break;
		case "8":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.red;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "9":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.red;
			colors[3] = Color.red;
			colors[4] = Color.gray;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "A":
		case "a":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.red;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.red;
			colors[6] = Color.gray;
			drawDigital(colors, g2d);
			break;
		case "B":
		case "b":
			colors[0] = Color.gray;
			colors[1] = Color.red;
			colors[2] = Color.gray;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "C":
		case "c":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.gray;
			colors[3] = Color.gray;
			colors[4] = Color.red;
			colors[5] = Color.gray;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "D":
		case "d":
			colors[0] = Color.gray;
			colors[1] = Color.gray;
			colors[2] = Color.red;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.red;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "E":
		case "e":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.gray;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.gray;
			colors[6] = Color.red;
			drawDigital(colors, g2d);
			break;
		case "F":
		case "f":
			colors[0] = Color.red;
			colors[1] = Color.red;
			colors[2] = Color.gray;
			colors[3] = Color.red;
			colors[4] = Color.red;
			colors[5] = Color.gray;
			colors[6] = Color.gray;
			drawDigital(colors, g2d);
			break;
		default:
			colors[0] = Color.gray;
			colors[1] = Color.gray;
			colors[2] = Color.gray;
			colors[3] = Color.red;
			colors[4] = Color.gray;
			colors[5] = Color.gray;
			colors[6] = Color.gray;
			drawDigital(colors, g2d);
			break;
		}
	}

	public void setInput(String input) {
		this.input = input;
	}

}
