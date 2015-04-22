package kr.co.crewmate.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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


	/**
	 * 썸네일 생성 <br>
	 * 주어진 orgName을 기준으로
	 * 원본이미지명_width_height.확장자 형태로 썸네일 이미지를 생성한다.
	 *
	 * @param orgName
	 *            원본 이미지 파일 경로
	 * @param width
	 *            줄일 가로 길이
	 * @param height
	 *            줄일 세로 길이
	 * @return 썸네일 파일 이름
	 * @throws IOException
	 */
	public static String createThumb(String orgName, int width, int height) throws IOException {

		File orgFile = new File(orgName);

		String orgFileNm = orgFile.getName();
		int lastIndexPoint = orgFileNm.lastIndexOf('.');

		String tempFileNm = orgFileNm.substring(0, lastIndexPoint);
		String tempFileExt = orgFileNm.substring(lastIndexPoint + 1);

		String destFilePath = orgFile.getParent() + "/" + tempFileNm + "_" + width + "_" + height + "." + tempFileExt;

		File destFile = new File(destFilePath);

		return createThumb(orgFile, destFile, width, height);
	}

	/**
	 * 썸네일 생성
	 *
	 * @param orgName
	 *            원본 이미지 파일 경로
	 * @param destName
	 *            썸에릴로 저장될 이미지 파일 경로
	 * @param width
	 *            줄일 가로 길이
	 * @param height
	 *            줄일 세로 길이
	 * @return 썸네일 파일 이름
	 * @throws IOException
	 */
	public static String createThumb(String orgName, String destName, int width, int height) throws IOException {
		File orgFile = new File(orgName);
		File destFile = new File(destName);

		return createThumb(orgFile, destFile, width, height);
	}

	/**
	 * 썸네일 생성
	 *
	 * @param orgFile
	 *            원본 이미지 파일 객체
	 * @param destFile
	 *            썸네일로 저장될 이미지 파일 객체
	 * @param width
	 *            줄일 가로 길이
	 * @param height
	 *            줄일 세로 길이
	 * @return 썸네일 파일이름
	 * @throws IOException
	 */
	public static String createThumb(File orgFile, File destFile, int width, int height) throws IOException {
		Image srcImg = null;
		String suffix = orgFile.getName().substring(orgFile.getName().lastIndexOf('.') + 1).toLowerCase();

		if (suffix.equals("bmp") || suffix.equals("png") || suffix.equals("gif")) {
//			logger.debug("--> original file path : {} ", orgFile.getAbsolutePath());
//			logger.debug("--> original file can read : {} ", orgFile.canRead());
			srcImg = ImageIO.read(orgFile);
		} else {
			srcImg = new ImageIcon(orgFile.toString()).getImage();
		}

		int srcWidth = srcImg.getWidth(null);
		int srcHeight = srcImg.getHeight(null);
		int destWidth = -1, destHeight = -1;

		if (width < 0) {
			destWidth = srcWidth;
		} else if (width > 0) {
			destWidth = width;
		}

		if (height < 0) {
			destHeight = srcHeight;
		} else if (height > 0) {
			destHeight = height;
		}

		Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH);
		int pixels[] = new int[destWidth * destHeight];
		PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight, pixels, 0, destWidth);

		try {
			pg.grabPixels();
		} catch (InterruptedException e) {
			throw new IOException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		BufferedImage destImg = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
		destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);
		ImageIO.write(destImg, "jpg", destFile);

		return destFile.getName();
	}
}