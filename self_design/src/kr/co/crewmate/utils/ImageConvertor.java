package kr.co.crewmate.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 클래스명: <code>ImageConvertor</code>
 *
 * <pre>
 *  이미지를 리사이즈하는 유틸
 *  
 *  원래는 이미지 리사이즈에 파일명은 필요가 없어야한다
 *  
 *  하지만 현실은 java의 이미지 리사이즈는 jpec과 기타 이미지와 틀리다
 *  이는 성능과 관계있으며 jpec을 여타 다른 이미지 리사이징 알고리즘을 
 *  돌리게 되면 성능에 치명적인 문제가발생하므로 
 *  3번째 파라매터로 이미지파일명 혹은 이미지를 구분할수있는 코드값을 
 *  로직이 알고있어야 한다.
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
public class ImageConvertor {
    
    /**
     * <pre>
     * 이미지 리사이즈
     * 
     * </pre>
     * @param bytes 이미지
     * @param size 사이즈
     * @param src 파일명
     * @return
     * @throws Exception
     */
    public static byte[] execute(byte[] bytes, int size, String src) {
        return execute(bytes, size, size, src);
    }
    
    /**
     * <pre>
     * 이미지 리사이즈
     * </pre>
     * @param bytes 이미지 
     * @param standardSize 사이즈
     * @param src 파일명
     * @return
     * @throws Exception
     */
    public static byte[] resize(byte[] bytes, int standardSize, String src) throws Exception {
    	Image srcImg = null;
    	String suffix = src.substring(src.lastIndexOf('.') + 1).toLowerCase();
    	
        if (suffix.equals("bmp") || suffix.equals("png") || suffix.equals("gif")) {
            srcImg = ImageIO.read(new ByteArrayInputStream(bytes));
        } else {
            srcImg = new ImageIcon(bytes).getImage();
        }
        
        int imgWidth = srcImg.getWidth(null);   //이미지 width 사이즈
        int imgHeight = srcImg.getHeight(null);   //이미지 height 사이즈
        
        int reHeight = 0;   //resize될 Height 값
        reHeight = (int) Math.round( ((double)imgHeight / (double)imgWidth) * standardSize ) ;
        
        return execute(bytes, standardSize, reHeight, src);
    }

    /**
     * <pre>
     *  이미지 리사이즈
     * </pre>
     * @param bytes 이미지
     * @param width 가로
     * @param height 세로
     * @param src 파일명
     * @return
     * @throws Exception
     */
    public static byte[] execute(byte[] bytes, int width, int height, String src) {
        Image srcImg = null;
        try {
            String suffix = src.substring(src.lastIndexOf('.') + 1).toLowerCase();
            if (suffix.equals("bmp") || suffix.equals("png") || suffix.equals("gif")) {
                srcImg = ImageIO.read(new ByteArrayInputStream(bytes));
            } else {
                srcImg = new ImageIcon(bytes).getImage();
            }
            
            Image imageResult = srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            int pixels[] = new int[width * height]; 
            PixelGrabber pg = new PixelGrabber(imageResult, 0, 0, width, height, pixels, 0, width); 
            pg.grabPixels();
            BufferedImage destImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
            destImg.setRGB(0, 0, width, height, pixels, 0, width);
            ByteArrayOutputStream os = new ByteArrayOutputStream();  
            ImageIO.write(destImg, "jpg", os);
            return os.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
