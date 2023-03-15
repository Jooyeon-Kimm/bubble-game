package bubble.test.ex01;

import javax.swing.JFrame;


// 윈도우 창(JFrame) 내부에 패널(JPanel) 하나를 가지고 있다.
// JFrame은 while문 계속 돌고 있다.
@SuppressWarnings("serial")
public class BubbleFrame extends JFrame {


	public BubbleFrame() {
		setSize(1000, 640);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}

}
