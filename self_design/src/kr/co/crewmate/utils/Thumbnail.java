package kr.co.crewmate.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class Thumbnail {
	public Thumbnail(){

	}

	/**
	 * 자바 API 방식
	 * @param loadFile
	 * @param saveFile
	 * @param zoom
	 * @throws IOException
	 */
	public static void createImage(String loadFile, String saveFile, int zoom) throws IOException{
		File save = new File(saveFile);
		FileInputStream fis = new FileInputStream(loadFile);
		BufferedImage im = ImageIO.read(fis);

		if (zoom <= 0) {
			zoom = 1;
		}

		int width = 100;//im.getWidth() / zoom;
		int height = 100;//im.getHeight() / zoom;

		BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = thumb.createGraphics();

		g2.drawImage(im, 0, 0, width, height, null);
		ImageIO.write(thumb, "jpg", save);
	}

	public static void main(String args[]){
		String loadFile = "c://badpark.jpg";
		String saveFile = "d://res.jpg";
		int zoom = 5;

		try {
			Thumbnail.createImage(loadFile, saveFile, zoom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * thumbnail api를 이용
	 * https://code.google.com/p/thumbnailator/wiki/Examples
	 * watermark 사용 가능
	 * @param loadFile
	 * @param saveFile
	 * @param zoom
	 * @throws IOException
	 */
	public static void createImage(String loadFile, String saveFile, int width, int height, boolean watermark) throws IOException {
		BufferedImage originalImage = ImageIO.read(new File(loadFile));
		BufferedImage watermarkImage = ImageIO.read(new File("watermark.png"));
		BufferedImage thumbnail = null;

		if(watermark) {
			thumbnail = Thumbnails.of(originalImage)
			                      .size(200, 200)
			                      .watermark(Positions.BOTTOM_RIGHT, watermarkImage, 0.5f)
			                      .asBufferedImage();
		} else {
			Thumbnails.of(new File(loadFile))
					  .size(width, height)
					  .toFile(new File(saveFile));
		}
	}

	public static void createImage(String loadFile, String saveFile, int width, int height) throws IOException {
		createImage(loadFile, saveFile, width, height, false);
	}
}