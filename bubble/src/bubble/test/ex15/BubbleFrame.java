package bubble.test.ex15;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Getter
@Setter
public class BubbleFrame extends JFrame {
	
	private BubbleFrame mContext = this;
	private JLabel backgroundMap;
	private Player player;
	private Enemy enemy;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player(mContext);
		add(player);
		enemy = new Enemy(mContext);
		add(enemy);
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
					if(!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
					
				case KeyEvent.VK_RIGHT:
					if(!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
					
				case KeyEvent.VK_UP:
					if(!player.isUp() && !player.isDown()) { // 위키 계속 눌러도 더 위로 올라가지 않음
						player.up();
					}
					break;
				
				case KeyEvent.VK_SPACE:
					player.attack();
					break;
					
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

					break;
					
				case KeyEvent.VK_DOWN:
					break;
				}
			}
		});
	}
	
	// 자바로 만드는 모든 프로그램은
	// main을 가진 클래스 (context)가
	// 모든 객체 (heap)의 정보를 가지고 있다.
	public static void main(String[] args) {
		new BubbleFrame();
	}

}
