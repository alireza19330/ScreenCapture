package ir.developairs.capture;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Capture {

	private Properties props = null;
	public Properties getProps() {
		return props;
	}

	public static void main(String[] args) throws IOException, AWTException {
		Capture capture = new Capture();
		BufferedImage image = capture.getImage();
		capture.saveImage(image);
		JOptionPane.showMessageDialog(null, "Image is saved!");
	}

	private void saveImage(RenderedImage image) throws IOException, AWTException {
		ImageIO.write(image, "jpeg", new File(location+"//image"+formatter.format(new Date())+".jpeg"));
	}

	private BufferedImage getImage() throws AWTException {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = new Robot().createScreenCapture(screenRect);
		return image;
	}
	
	private String location = "C://Users//a_abazari//Pictures//ScreenShots//";
//	private String settingsFileName = location + "setting.properties";
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS");

}
