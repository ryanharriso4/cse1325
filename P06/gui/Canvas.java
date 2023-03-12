package gui; 
import javax.swing.JPanel; 
import javax.swing.BorderFactory; 
import javax.imageio.ImageIO; 

import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Color; 
import java.awt.image.BufferedImage; 
import java.awt.Font; 

import java.io.File; 
import java.io.IOException; 


public class Canvas extends JPanel
{
	private BufferedImage image; 
	public Canvas()
	{
		setBackground(Color.BLACK); 
		String imageFile = "gui/resources/OnlineSnowflake.png"; 
		try{
			image = ImageIO.read(new File(imageFile)); 
		} 
		catch(IOException e)
		{
			throw new RuntimeException("Unable to load image from " + imageFile, e); 
		}
	}

	@Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
    


	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics); 
		Graphics2D g = (Graphics2D) graphics.create();
		

		Color [] colors = new Color []{
			new Color(128, 234, 255), 
			new Color(238, 153, 255), 
			new Color(179, 102, 255), 
			new Color(51, 51, 255)
		};

		int colorIndex = 0;
		for(int x = 0; x <= 400; x += 10)
		{
			g.setColor(colors[colorIndex]);
			colorIndex = (colorIndex < 3) ? colorIndex + 1 : 0;
			g.drawLine(x, 0, x, 300);
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		g.drawString("Better Computers, Better Prices", 50, 300);

		int x = (getBounds().width - image.getWidth()) / 2; 
		int y = (getBounds().height - image.getHeight()) / 2;

		g.drawImage(image, x, y, this); 

	}
}

