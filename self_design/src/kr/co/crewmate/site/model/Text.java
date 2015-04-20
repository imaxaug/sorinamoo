package kr.co.crewmate.site.model;

import java.util.Date;


/**
 * 클래스명: <code>Cart</code>
 *
 * <pre>
 *  장바구니 정보를 저장하는 모델 클래스
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 22.
 */
public class Text extends ToString {
    private String path;
    private String filePath;
    private String fileName;
    private String text;
    private String textAlign;
    private String font;
    private String color;

    public Text() {
    }

    public Text(String path) {
    	setPath(path);
    }

    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}



	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}