import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image currentImage,img,img1,img2,img3;
	Image img1_1,img1_2;
	int flag1;
	int x,y;
	public MainCanvas(){
		try
		{
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");

			img1_1=Image.creatImage("/sayo02.png");
			img1_2=Image.creatImage("/sayo22.png");
			currentImage=img;
			x=120;
			y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImage,x,y,0);
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			currentImage=img1;

			/*让hero走得更逼真*/
	`		for(flag1=1;flag1<=15;flag1++){
				if(flag1 % 2==0)
					currentImage=img1_1;
				else if(flag1%2!=0)
					currentImage=img1_2;
				x=x-1;
			}
			
			/*让hero在左方向上移动*/
			//x=x-1;
			System.out.println("向左转");
			repaint();
		}
		
		if(action==RIGHT){
			currentImage=img3;
			x=x+1;
			System.out.println("向右转");
			repaint();
		}
		if(action==UP){
			currentImage=img2;
			y=y-1;
			System.out.println("向上转");
			repaint();
		}
		if(action==DOWN){
			currentImage=img;
			y=y+1;
			System.out.println("向下转");
			repaint();
		}
	}
}