package gui; 
import javax.swing.JPanel; 
import javax.swing.BorderFactory; 
import javax.imageio.ImageIO; 

import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Color; 
import java.awt.image.BufferedImage; 

import java.io.File; 
import java.io.IOException; 


public class Canvas extends JPanel
{
	private BufferedImage image; 
	public Canvas()
	{
		setBackground(Color.BLACK); 
		String imageFile = "gui/resources/Snowflake.png"; 
		try{
			image = ImageIO.read(new File(imageFile)); 
		} 
		catch(IOException e)
		{
			throw new RuntimeException("Unable to load image from " + imageFile, e); 
		}
	}

	

	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics); 
		Graphics2D g = (Graphics2D) graphics.create();
		Line [] lines = new Line []{
			new Line(100, 0, 100, 200),
			new Line(200, 0, 200, 200),
			new Line(300, 0, 300, 200),
			new Line(400, 0, 400, 200)
		};

		Color [] colors = new Color []{
			new Color(128, 234, 255), 
			new Color(238, 153, 255), 
			new Color(179, 102, 255), 
			new Color(51, 51, 255)
		};

		int colorIndex = 0; 
		for(Line l: lines)
		{
			g.setColor(colors[colorIndex]);
			colorIndex = (colorIndex < 3) ? colorIndex + 1 : 0;
			g.drawLine(l.x1, l.y1, l.x2, l.y2); 
		} 
		int x = (getBounds().width - image.getWidth()) / 2; 
		int y = (getBounds().height - image.getHeight()) / 2;

		g.drawImage(image, x, y, this); 

	}
}

class Line{
	int x1; 
	int x2; 
	int y1; 
	int y2; 
	Line(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1; 
		this.x2 = x2; 
		this.y1 = y1; 
		this.y2 = y2; 
	}
}