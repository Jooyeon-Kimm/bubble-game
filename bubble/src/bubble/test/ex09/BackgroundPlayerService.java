package bubble.test.ex09;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 메인스레드 바쁨 - 키보드 이벤트를 처리하기 바쁘다
// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable{

	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		// 플레이어의 위치에 따른 색상 확인
		while(true) {
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY()+25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY()+25));
			
			// bottomColor가 -2이면, 바닥이 흰색
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // 왼쪽 아래, 오른쪽 아래 색깔
			
			// 바닥 충돌 화긴
			if(bottomColor != -2) { // 흰 색이 아닐 때
				// System.out.println("바닥에 충돌함");
				player.setDown(false);
			} else { // 흰색일 때
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
				
			}
			System.out.println("bottomcolor" + bottomColor);

			// 외벽충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				// System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
				
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				// System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
				
			} else { // 충돌하지 않았을 때
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}