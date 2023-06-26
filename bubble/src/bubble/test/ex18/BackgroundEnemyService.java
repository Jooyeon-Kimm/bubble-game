package bubble.test.ex18;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

// 메인스레드 바쁨 - 키보드 이벤트를 처리하기 바쁘다
// 백그라운드에서 계속 관찰
public class BackgroundEnemyService implements Runnable{

	private BufferedImage image;
	private Enemy enemy;
	
	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;
		
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		// 적군의 위치에 따른 색상 확인
		while(enemy.getState() == 0) {
			
			// 2. 벽 충돌 체크
			// 색상 확인
			Color leftColor = new Color(image.getRGB(enemy.getX() - 10, enemy.getY()+25));
			Color rightColor = new Color(image.getRGB(enemy.getX() + 50 + 15, enemy.getY()+25));
			
			// bottomColor가 -2이면, 바닥이 흰색
			int bottomColor = image.getRGB(enemy.getX() + 10, enemy.getY() + 50 + 5)
					+ image.getRGB(enemy.getX() + 50 - 10, enemy.getY() + 50 + 5); // 왼쪽 아래, 오른쪽 아래 색깔
			
			// 바닥 충돌 화긴
			if(bottomColor != -2) { // 흰 색이 아닐 때
				// System.out.println("바닥에 충돌함");
				enemy.setDown(false);
			} else { // 흰색일 때
				if(!enemy.isUp() && !enemy.isDown()) {
					enemy.down();
				}
				
			}

			// 외벽충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				enemy.setLeft(false);
				if(!enemy.isRight()) {
					enemy.right();
				}
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				enemy.setRight(false);
				if(!enemy.isLeft()) {
					enemy.left();
				}
			} 
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
