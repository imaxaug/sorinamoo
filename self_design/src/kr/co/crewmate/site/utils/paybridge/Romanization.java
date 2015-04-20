package kr.co.crewmate.site.utils.paybridge;


public class Romanization {

	// 초성
	final String[] cho0   
	 = { "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", 
		 "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };
	final String[] cho1   
	 = { "G", "Kk", "N", "D", "Tt", "R", "M", "B", "Pp", "S", 
		 "Ss", "O", "J", "Jj", "Ch", "K", "T", "P", "H" };
	
	// 중성
	final String[] jung0  
	 = { "ㅏ", "ㅐ",  "ㅑ",  "ㅒ", "ㅓ",  "ㅔ",  "ㅕ",  "ㅖ", "ㅗ", "ㅘ", 
		 "ㅙ", "ㅚ",  "ㅛ",  "ㅜ", "ㅝ",  "ㅞ",  "ㅟ",  "ㅠ", "ㅡ", "ㅢ",
		 "ㅣ" };
	final String[] jung1   
	 = { "a", "ae", "ya", "yae", "eo", "e", "yeo", "ye", "o", "wa", 
		 "wae", "oe", "yo", "u", "wo", "we", "wi", "yu", "eu", "ui", 
		 "i" };
	
	// 종성
	final String[] chong0  
	 = {  "", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", 
		 "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", 
		 "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };	
	final String[] chong1  
	 = {  "", "k", "kk", "ks", "n", "nz", "nh", "t", "l", "lk", 
		"lm", "lp", "ls", "lt", "lp", "lh", "m", "p", "pt", "t", 
		"ss", "ng",  "t", "t",  "k",  "t", "p", "h" };
	
	public String toEng(String str) {
		if (str == null){
			return null;
		}
		String t = "";
		String tmp = "";
		
		int np = 0, np1 = 0, np2, np3 = 0;
		int n, n1, n2, n3;
		int nn = 0, nn1 = 0, nn2, nn3;

		char c, cn, cp;
		
		String [] ss = str.split(" ");
		
		for (String s: ss){
			for (int i = 0; i < s.length(); i++){
				c = s.charAt(i);
				n = (int) (c & 0xFFFF);
				
				if (i < s.length()-1){
					cn = s.charAt(i+1);
					nn = (int) (cn & 0xFFFF);
				}
				
				if (i > 0){
					cp = s.charAt(i-1);
					np = (int) (cp & 0xFFFF);
				}
				
				if (n >= 0xAC00 && n <= 0xD7A3) {
					if (np >= 0xAC00 && np <= 0xD7A3){
						np = np - 0xAC00;
						np1 = np / (21 * 28);
						np = np % (21 * 28);
						np2 = np / 28;
						np3 = np % 28;	
					}

					n = n - 0xAC00;
					n1 = n / (21 * 28);
					n = n % (21 * 28);
					n2 = n / 28;
					n3 = n % 28;
					
					if (nn >= 0xAC00 && nn <= 0xD7A3 && i < s.length()-1){
						nn = nn - 0xAC00;
						nn1 = nn / (21 * 28);
						nn = nn % (21 * 28);
						nn2 = nn / 28;
						nn3 = nn % 28;
					}

					if (i == 0){
						if (n3 == 8 && nn1 == 5){
							tmp = cho1[n1].toLowerCase() + jung1[n2] + "l";
						} else if (np3 == 8 && n1 == 5){
							tmp = "l" + jung1[n2] + chong1[n3];	
						} else {
							tmp = cho1[n1].toLowerCase() + jung1[n2] + chong1[n3];
						}
						tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1, tmp.length());
						
						if ("seu".equalsIgnoreCase(tmp)){
							tmp = "S";
						} else if ("feu".equalsIgnoreCase(tmp)){
							tmp = "F";
						} else if ("teu".equalsIgnoreCase(tmp)){
							tmp = "T";
						} else if ("beu".equalsIgnoreCase(tmp)){
							tmp = "B";
						} else if ("deu".equalsIgnoreCase(tmp)){
							tmp = "D";
						} else if ("peu".equalsIgnoreCase(tmp)){
							tmp = "P";
						}
					} else {
						if (n3 == 8 && nn1 == 5){
							tmp = cho1[n1].toLowerCase() + jung1[n2] + "l";
						} else if (np3 == 8 && n1 == 5){
							tmp = "l" + jung1[n2] + chong1[n3];
						} else {
							tmp = cho1[n1].toLowerCase() + jung1[n2] + chong1[n3];
						}
						
						if ("seu".equalsIgnoreCase(tmp)){
							tmp = "s";
						} else if ("feu".equalsIgnoreCase(tmp)){
							tmp = "f";
						} else if ("teu".equalsIgnoreCase(tmp)){
							tmp = "t";
						} else if ("beu".equalsIgnoreCase(tmp)){
							tmp = "b";
						} else if ("deu".equalsIgnoreCase(tmp)){
							tmp = "d";
						} else if ("peu".equalsIgnoreCase(tmp)){
							tmp = "p";
						}
					}
					
					if (tmp.length() > 1 && (tmp.charAt(0) == 'O' || tmp.charAt(0) == 'o')){
						if (i == 0){
							tmp = ("" + tmp.charAt(1)).toUpperCase() + tmp.substring(2);
						} else {
							tmp = ("" + tmp.charAt(1)) + tmp.substring(2);
						}
					}
					
					t += tmp;
				} else {
					t += c;
				}
			}
			
			t = t + " ";
		}
		
		return t.trim();
	}

	public static void main(String[] args) {
		Romanization romanization = new Romanization();
		String data = "프랑스 파리 퍼펙트 빠리 킬러 이자녹스 립스틱 에스라인 스마일 해피 러브 에뛰드 스킨로션 구미MBC 울릉-island 월령Zone 영동City 백암's 옥천-street 합덕IC 호법JC Happy-월곶 벚꽃 한밭 구리 설악 칠곡 임실 울릉 대관령 백마 신문로 종로 왕십리 별내 신라 학여울 알약";
		System.out.println(data + " = \n[" +romanization.toEng(data) + "]");
	}
}
