package bubble.test.ex12;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 버블이 만들어질 때마다 BackgroundBubbleService는 new 되어야 한다.
// BubbleFrame에서 VK_SPACE할 때 버블이 만들어진다.

// 메인스레드 바쁨 - 키보드 이벤트를 처리하기 바쁘다
// 백그라운드에서 계속 관찰
public class BackgroundBubbleService{

	private BufferedImage image;
	private Bubble bubble;
	
	public BackgroundBubbleService(Bubble bubble) {
		this.bubble = bubble;
		
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean topWall() {
		Color topColor = new Color(image.getRGB(bubble.getX() + 25, bubble.getY()-10));
		if(topColor.getRed() == 255 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
			// System.out.println("위쪽 벽에 충돌함");
			return true;
		} 
		return false;
	}
	
	public boolean leftWall() {
		Color leftColor = new Color(image.getRGB(bubble.getX() - 10, bubble.getY()+25));		
		
		if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			// System.out.println("왼쪽 벽에 충돌함");
			return true; // while 루프 도는 게 아니라서 setLeft 할 필요 없음
		} 

		return false;
	}
	
	public boolean rightWall() {
		Color rightColor = new Color(image.getRGB(bubble.getX() + 50 + 15, bubble.getY()+25));
		
		if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
			// System.out.println("오른쪽 벽에 충돌함");
			return true;
		}
		
		return false;
	}
	
	
}
