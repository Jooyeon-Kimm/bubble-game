package bubble.test.ex04;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class BubbleFrame extends JFrame {
	
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);
		// backgroundMap.setSize(1000, 600);
		// backgroundMap.setLocation(300, 300);
		// add(backgroundMap); // JFrame에 JLabel이 그려진다.	
	}
	
	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); //absoulte 레이아웃 (자유롭게)

		setLocationRelativeTo(null); // JFrame 창이 가운데 뜨도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼으로 창을 끌 때 JVM 같이 종료하기
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			
			// 키보드 클릭 이벤트 핸들러
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.getKeyCode()); // 키보드 코드 번호 확인
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(!player.isLeft()) {
						player.left();
					}
					player.left();
					break;
					
				case KeyEvent.VK_RIGHT:
					if(!player.isRight()) {
						player.right();
					}
					player.right();
					break;
					
				case KeyEvent.VK_UP:
					player.up();
					break;
					
//				case KeyEvent.VK_DOWN:
//					player.down();
//					break;
				}
			}
			
			// 키보드 해제 이벤트 핸들러
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
					
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
					
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
					
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}

}