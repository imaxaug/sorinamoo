package kr.co.crewmate.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.crewmate.site.model.Text;

import org.apache.log4j.Logger;

public class ChangeTextImageAction  {

	public static void execute(HttpServletRequest request, HttpServletResponse response, Text text) throws Exception {

		Logger logger = Logger.getLogger("com.miclub.consumer");
		logger.debug("START");

		response.setContentType("image/png");
		OutputStream out = response.getOutputStream();

		createTextImage(text, 350, 40, 11, out);

		logger.debug("END");
	}

	private static void createTextImage(Text text, int imgWidth, int imgHeight, int fontSize, OutputStream out) throws IOException {

		BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400 , imgHeight);

		Font useFont = new Font(text.getFont(), Font.PLAIN, fontSize);
		g.setFont(useFont);
		g.setColor(Color.BLACK);
		g.drawString (text.getText(), 0, 25);

		ImageIO.write(image, "png", out);
	}
}
