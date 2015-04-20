package kr.co.crewmate.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

import kr.co.crewmate.site.model.Text;

public class TextToImage {

	public static boolean createImage(Text text) throws IOException {
		File file = new File(text.getFilePath() + "/" + text.getFileName() + ".PNG");
		Font font = new Font(text.getFont(), Font.PLAIN, 20);

		FontRenderContext frc = new FontRenderContext(null, true, true);
		Rectangle2D bounds = font.getStringBounds(text.getText(), frc);
		int w = (int) bounds.getWidth();
		int h = (int) bounds.getHeight();
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g.drawString(text.getText(), (float) bounds.getX(), (float) -bounds.getY());
		g.dispose();

		return ImageIO.write(image, "png", new FileImageOutputStream((File)file));
	}
}
