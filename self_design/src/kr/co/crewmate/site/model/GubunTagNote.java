package kr.co.crewmate.site.model;

import java.util.ArrayList;
import java.util.List;

import kr.co.crewmate.site.CodeName;

/**
 * 
 * 클래스명: <code>ClassNote</code>
 * 
 * <pre>
 * 구분정의
 * </pre>
 * 
 * @author 이경연
 * @date 2011. 11. 17.
 * 
 */

@SuppressWarnings("serial")
public class GubunTagNote extends ToString {

    private static GubunTagNote instance = new GubunTagNote();

    public static GubunTagNote getInstance() {
        return instance;
    }

    private GubunTagNote() {

    }

    /**
     * <pre>
     * 이경연
     * 최초작성
     * 2011-11-17
     * </pre>
     */
    private final List<Parameter> ynboolean = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("true", "예"));
            add(new ParameterImpl("false", "아니오"));
        }
    };
    
    private final List<Parameter> ynbooleanCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("true", "예!"));
            add(new ParameterImpl("false", "아니오!"));
        }
    };

    /**
     * <pre>
     * 이경연
     * 최초작성
     * 2013-05-20
     * </pre>
     */
    private final List<Parameter> allBoolean = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("true", "예"));
            add(new ParameterImpl("false", "아니오"));
        }
    };
    private final List<Parameter> allBooleanCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("true", "예!"));
            add(new ParameterImpl("false", "아니오!"));
        }
    };

    /**
     * <pre>
     * 임샛별 
     * n,y 순서변경 
     * 2011-11-17
     * </pre>
     */
    private final List<Parameter> nyboolean = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("false", "아니오"));
            add(new ParameterImpl("true", "예"));
        }
    };
    private final List<Parameter> nybooleanCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("false", "아니오!"));
            add(new ParameterImpl("true", "예!"));
        }
    };

    private final List<Parameter> nyAllBoolean = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("false", "아니오"));
            add(new ParameterImpl("true", "예"));
        }
    };
    private final List<Parameter> nyAllBooleanCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("false", "아니오!"));
            add(new ParameterImpl("true", "예!"));
        }
    };

    /**
     * 메일 도메인 리스트
     */
    
    private final List<Parameter> mailDomains = new ArrayList<Parameter>(15) {
        {
            add(new ParameterImpl("dreamwiz.com", "dreamwiz.com"));
            add(new ParameterImpl("empas.com", "empas.com"));
            add(new ParameterImpl("freechal.com", "freechal.com"));
            add(new ParameterImpl("gmail.com", "gmail.com"));
            add(new ParameterImpl("hanmail.net", "hanmail.net"));
            add(new ParameterImpl("hanmir.com", "hanmir.com"));
            add(new ParameterImpl("hotmail.com", "hotmail.com"));
            add(new ParameterImpl("korea.com", "korea.com"));
            add(new ParameterImpl("lycos.co.kr", "lycos.co.kr"));
            add(new ParameterImpl("nate.com", "nate.com"));
            add(new ParameterImpl("naver.com", "naver.com"));
            add(new ParameterImpl("paran.com", "paran.com"));
            add(new ParameterImpl("yahoo.co.kr", "yahoo.co.kr"));
            add(new ParameterImpl("insert", "직접입력"));
        }
    };
    
    private final List<Parameter> mailDomainsCn = new ArrayList<Parameter>(15) {
        {
            add(new ParameterImpl("qq.com", "qq.com"));
            add(new ParameterImpl("dreamwiz.com", "dreamwiz.com"));
            add(new ParameterImpl("empas.com", "empas.com"));
            add(new ParameterImpl("freechal.com", "freechal.com"));
            add(new ParameterImpl("gmail.com", "gmail.com"));
            add(new ParameterImpl("hanmail.net", "hanmail.net"));
            add(new ParameterImpl("hanmir.com", "hanmir.com"));
            add(new ParameterImpl("hotmail.com", "hotmail.com"));
            add(new ParameterImpl("korea.com", "korea.com"));
            add(new ParameterImpl("lycos.co.kr", "lycos.co.kr"));
            add(new ParameterImpl("nate.com", "nate.com"));
            add(new ParameterImpl("naver.com", "naver.com"));
            add(new ParameterImpl("paran.com", "paran.com"));
            add(new ParameterImpl("yahoo.co.kr", "yahoo.co.kr"));
            add(new ParameterImpl("insert", "直接输入"));
        }
    };


    /**
     * 휴대폰 앞번호 코드
     */
    
    private final List<Parameter> hdphnNumGubun = new ArrayList<Parameter>(6) {
        {
            add(new ParameterImpl("010", "010"));
            add(new ParameterImpl("011", "011"));
            add(new ParameterImpl("016", "016"));
            add(new ParameterImpl("017", "017"));
            add(new ParameterImpl("018", "018"));
            add(new ParameterImpl("019", "019"));
        }
    };
    
    private final List<Parameter> hdphnNumGubunCn = new ArrayList<Parameter>(6) {
        {
            add(new ParameterImpl("010", "010"));
            add(new ParameterImpl("011", "011"));
            add(new ParameterImpl("016", "016"));
            add(new ParameterImpl("017", "017"));
            add(new ParameterImpl("018", "018"));
            add(new ParameterImpl("019", "019"));
        }
    };

    /**
     * <pre>
     * 임샛별 
     * y,n 문자열
     * 2012-03-07
     * </pre>
     */
    
    private final List<Parameter> ynString = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("Y", "예"));
            add(new ParameterImpl("N", "아니오"));
        }
    };
    
    private final List<Parameter> ynStringCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("Y", "예!"));
            add(new ParameterImpl("N", "아니오!"));
        }
    };
    
    
    /**
     * <pre>
     * 임샛별 
     * y,n 문자열
     * 2012-03-07
     * </pre>
     */
    
    private final List<Parameter> sendGbn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("N", "미송신"));
            add(new ParameterImpl("F", "송신실패"));
            add(new ParameterImpl("S", "송신"));
        }
    };
    
    private final List<Parameter> sendGbnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("N", "미송신!"));
            add(new ParameterImpl("F", "송신실패!"));
            add(new ParameterImpl("S", "송신!"));
        }
    };
    
    /**
     * <pre>
     * 이경연 
     * 배치상태구분
     * 2013-03-27
     * </pre>
     */
    
    private final List<Parameter> batchStatGbn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("P", "진행중"));
            add(new ParameterImpl("S", "성공"));
            add(new ParameterImpl("F", "실패"));
        }
    };
    
    private final List<Parameter> batchStatGbnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("P", "진행중!"));
            add(new ParameterImpl("S", "성공!"));
            add(new ParameterImpl("F", "실패!"));
        }
    };
    
    
    private final List<Parameter> tabGbn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("B", "하단"));
            add(new ParameterImpl("R", "우측"));
        }
    };
    
    private final List<Parameter> tabGbnCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("B", "하단!"));
            add(new ParameterImpl("R", "우측!"));
        }
    };
    
    
    private final List<Parameter> useYn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("Y", "사용"));
            add(new ParameterImpl("N", "미사용"));
        }
    };
    
    private final List<Parameter> useYnCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("Y", "사용!"));
            add(new ParameterImpl("N", "미사용!"));
        }
    };
    
    
    private final List<Parameter> dispAllYn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("Y", "사용"));
            add(new ParameterImpl("N", "미사용"));
        }
    };
    
    private final List<Parameter> dispAllYnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("Y", "사용!"));
            add(new ParameterImpl("N", "미사용!"));
        }
    };

    
    /**
     * <pre>
     * 조우상 
     * 게시판 검색어 구분범위(전체,제목검색, 내용검색) 
     * 2013-05-20
     * </pre>
     */
    
    private final List<Parameter> boardSrchGbn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("T", "제목"));
            add(new ParameterImpl("D", "내용"));
        }
    };
    
    private final List<Parameter> boardSrchGbnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("T", "제목!"));
            add(new ParameterImpl("D", "내용!"));
        }
    };
    
    
    private final List<Parameter> boardSrchGbn2 = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "제목/내용"));
            add(new ParameterImpl("T", "제목"));
            add(new ParameterImpl("D", "내용"));
        }
    };
    
    private final List<Parameter> boardSrchGbn2Cn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "제목/내용!"));
            add(new ParameterImpl("T", "제목!"));
            add(new ParameterImpl("D", "내용!"));
        }
    };
    
    
    private final List<Parameter> boardSrchGbn3 = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("T", "제목"));
            add(new ParameterImpl("D", "내용"));
        }
    };
    
    private final List<Parameter> boardSrchGbn3Cn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("T", "제목!"));
            add(new ParameterImpl("D", "내용!"));
        }
    };
    
    /**
     * <pre>
     * 남세건
     * 성별 구분
     * </pre>
     */
    
    private final List<Parameter> genderGbn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("M", "남성"));
            add(new ParameterImpl("F", "여성"));
        }
    };
    
    private final List<Parameter> genderGbnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "所有"));
            add(new ParameterImpl("M", "男性"));
            add(new ParameterImpl("F", "女性"));
        }
    };
    
    private final List<Parameter> localGbn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("0", "내국인"));
            add(new ParameterImpl("1", "외국인"));
        }
    };
    
    private final List<Parameter> localGbnCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("0", "내국인"));
            add(new ParameterImpl("1", "외국인"));
        }
    };
    
    private final List<Parameter> phoneCorpGbn = new ArrayList<Parameter>(4) {
        {
            add(new ParameterImpl("SKT", "SKT"));
            add(new ParameterImpl("KTF", "KT"));
            add(new ParameterImpl("LGT", "LG U+"));
            add(new ParameterImpl("SKM", "SKTmvno"));
            add(new ParameterImpl("KTM", "KTmvno"));
        }
    };
    
    private final List<Parameter> phoneCorpGbnCn = new ArrayList<Parameter>(4) {
        {
            add(new ParameterImpl("SKT", "SKT"));
            add(new ParameterImpl("KTF", "KT"));
            add(new ParameterImpl("LGT", "LG U+"));
            add(new ParameterImpl("SKM", "SKTmvno"));
            add(new ParameterImpl("KTM", "KTmvno"));
        }
    };
    
    /**
     * <pre>
     * 남세건
     * 얼리어답터 진행상태
     * </pre>
     */
    
    private final List<Parameter> proStateGbn = new ArrayList<Parameter>(6) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("R", "준비중"));
            add(new ParameterImpl("A", "신청중"));
            add(new ParameterImpl("D", "신청마감"));
            add(new ParameterImpl("E", "체험중"));
            add(new ParameterImpl("F", "종료"));
        }
    };
    
    private final List<Parameter> proStateGbnCn = new ArrayList<Parameter>(6) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("R", "준비중!"));
            add(new ParameterImpl("A", "신청중!"));
            add(new ParameterImpl("D", "신청마감!"));
            add(new ParameterImpl("E", "체험중!"));
            add(new ParameterImpl("F", "종료!"));
        }
    };
    
    /**
     * <pre>
     * 조우상 
     * 기획전 진행상태
     * 2013-06-09
     * </pre>
     */
    
    private final List<Parameter> splSellStateGbn = new ArrayList<Parameter>(4) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("S", "대기"));
            add(new ParameterImpl("P", "진행중"));
            add(new ParameterImpl("E", "종료"));
        }
    };
    
    private final List<Parameter> splSellStateGbnCn = new ArrayList<Parameter>(4) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("S", "대기!"));
            add(new ParameterImpl("P", "진행중!"));
            add(new ParameterImpl("E", "종료!"));
        }
    };
    
    
    private final List<Parameter> dispEttGbn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("N", "배너 조회"));
            add(new ParameterImpl("P", "상품 조회"));
            add(new ParameterImpl("S", "기획전 조회"));
        }
    };
    
    private final List<Parameter> dispEttGbnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("N", "배너 조회!"));
            add(new ParameterImpl("P", "상품 조회!"));
            add(new ParameterImpl("S", "기획전 조회!"));
        }
    };
    
    /**
     * <pre>
     * 조우상
     * allBoolean 순서 변경
     * 2013-06-11
     * </pre>
     */
    
    private final List<Parameter> ynAllBoolean = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("true", "예"));
            add(new ParameterImpl("false", "아니오"));
            add(new ParameterImpl("", "전체"));
        }
    };
    
    private final List<Parameter> ynAllBooleanCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("true", "예!"));
            add(new ParameterImpl("false", "아니오!"));
            add(new ParameterImpl("", "전체!"));
        }
    };
    
    
    private final List<Parameter> payGbn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("S", "적립금"));
            add(new ParameterImpl("C", "쿠폰"));
        }
    };
    
    private final List<Parameter> payGbnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("S", "적립금!"));
            add(new ParameterImpl("C", "쿠폰!"));
        }
    };
    
    
    private final List<Parameter> payGbnExceptAll = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("S", "적립금"));
            add(new ParameterImpl("C", "쿠폰"));
        }
    };
    
    private final List<Parameter> payGbnExceptAllCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("S", "적립금!"));
            add(new ParameterImpl("C", "쿠폰!"));
        }
    };
    
    
    private final List<Parameter> sendYn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("T", "전체"));
            add(new ParameterImpl("", "송신"));
            add(new ParameterImpl("N", "미송신"));
        }
    };
    
    private final List<Parameter> sendYnCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("T", "전체!"));
            add(new ParameterImpl("", "송신!"));
            add(new ParameterImpl("N", "미송신!"));
        }
    };
    
    
    private final List<Parameter> userNameGbn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("K", "고객명(K)"));
            add(new ParameterImpl("E", "고객명(E)"));
        }
    };
    
    private final List<Parameter> userNameGbnCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("K", "고객명(K)!"));
            add(new ParameterImpl("E", "고객명(E)!"));
        }
    };
    
    
    private final List<Parameter> allNotUserGbn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("Y", "회원"));
            add(new ParameterImpl("N", "비회원"));
        }
    };
    
    private final List<Parameter> allNotUserGbnCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("Y", "회원!"));
            add(new ParameterImpl("N", "비회원!"));
        }
    };
    
    
    private final List<Parameter> allNotGenderGbn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("M", "남성"));
            add(new ParameterImpl("F", "여성"));
        }
    };
    
    private final List<Parameter> allNotGenderGbnCn = new ArrayList<Parameter>(2) {
        {
            add(new ParameterImpl("M", "남성!"));
            add(new ParameterImpl("F", "여성!"));
        }
    };
    
    /**
     * <pre>
     * 조우상
     * y,n 문자열
     * 2013-06-14
     * </pre>
     */
    
    private final List<Parameter> allYnString = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("Y", "예"));
            add(new ParameterImpl("N", "아니오"));
        }
    };
    
    private final List<Parameter> allYnStringCn = new ArrayList<Parameter>(3) {
        {
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("Y", "예!"));
            add(new ParameterImpl("N", "아니오!"));
        }
    };
    

    
    private final List<Parameter> fcYn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("Y", "외산"));
            add(new ParameterImpl("N", "국산"));
        }
    }; 
    
    private final List<Parameter> fcYnCn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("Y", "외산!"));
            add(new ParameterImpl("N", "국산!"));
        }
    }; 
    
    
    private final List<Parameter> dispTgtCode = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("B", "브랜드"));
            add(new ParameterImpl("X", "브랜드 + 아이템"));
        }
    }; 
    
    private final List<Parameter> dispTgtCodeCn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("B", "브랜드!"));
            add(new ParameterImpl("X", "브랜드 + 아이템!"));
        }
    }; 
    
    
    private final List<Parameter> dispYn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("Y", "비적용"));
            add(new ParameterImpl("N", "해제"));
        }
    }; 
    
    private final List<Parameter> dispYnCn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("Y", "비적용!"));
            add(new ParameterImpl("N", "해제!"));
        }
    }; 
    
    
    private final List<Parameter> openYn = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("Y", "일반글"));
            add(new ParameterImpl("N", "비밀글"));
        }
    };
    
    private final List<Parameter> openYnCn = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("Y", "일반글!"));
            add(new ParameterImpl("N", "비밀글!"));
        }
    };
    
    
    private final List<Parameter> prmYn = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("Y", "프리미엄"));
            add(new ParameterImpl("N", "일반"));
        }
    };
    
    private final List<Parameter> prmYnCn = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("Y", "프리미엄!"));
            add(new ParameterImpl("N", "일반!"));
        }
    };
    
    
    private final List<Parameter> ltlTitleDispGbn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("P", "개별상품"));
            add(new ParameterImpl("D", "행사상품"));
        }
    };
    
    private final List<Parameter> ltlTitleDispGbnCn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("P", "개별상품!"));
            add(new ParameterImpl("D", "행사상품!"));
        }
    };
    
    
    private final List<Parameter> areaNumGubun = new ArrayList<Parameter>(17) {
        {
            add(new ParameterImpl("02", "02"));
            add(new ParameterImpl("031", "031"));
            add(new ParameterImpl("032", "032"));
            add(new ParameterImpl("033", "033"));
            add(new ParameterImpl("041", "041"));
            add(new ParameterImpl("042", "042"));
            add(new ParameterImpl("043", "043"));
            add(new ParameterImpl("044", "044"));
            add(new ParameterImpl("051", "051"));
            add(new ParameterImpl("052", "052"));
            add(new ParameterImpl("053", "053"));
            add(new ParameterImpl("054", "054"));
            add(new ParameterImpl("055", "055"));
            add(new ParameterImpl("061", "061"));
            add(new ParameterImpl("062", "062"));
            add(new ParameterImpl("063", "063"));
            add(new ParameterImpl("064", "064"));
        }
    };
    
    private final List<Parameter> areaNumGubunCn = new ArrayList<Parameter>(17) {
        {
            add(new ParameterImpl("02", "02!"));
            add(new ParameterImpl("031", "031!"));
            add(new ParameterImpl("032", "032!"));
            add(new ParameterImpl("033", "033!"));
            add(new ParameterImpl("041", "041!"));
            add(new ParameterImpl("042", "042!"));
            add(new ParameterImpl("043", "043!"));
            add(new ParameterImpl("044", "044!"));
            add(new ParameterImpl("051", "051!"));
            add(new ParameterImpl("052", "052!"));
            add(new ParameterImpl("053", "053!"));
            add(new ParameterImpl("054", "054!"));
            add(new ParameterImpl("055", "055!"));
            add(new ParameterImpl("061", "061!"));
            add(new ParameterImpl("062", "062!"));
            add(new ParameterImpl("063", "063!"));
            add(new ParameterImpl("064", "064!"));
        }
    };
    
    
    private final List<Parameter> postNumGbn = new ArrayList<Parameter>(5) {
        { 
            add(new ParameterImpl("1", "도로명+건물번호"));
            add(new ParameterImpl("2", "동(읍/면/리)명+지번"));
            add(new ParameterImpl("3", "건물명(아파트명 등)"));
            add(new ParameterImpl("4", "사서함+사서함번호"));
            add(new ParameterImpl("5", "지번주소"));
        }
    };
    
    private final List<Parameter> postNumGbnCn = new ArrayList<Parameter>(5) {
        { 
            add(new ParameterImpl("1", "도로명+건물번호!"));
            add(new ParameterImpl("2", "동(읍/면/리)명+지번!"));
            add(new ParameterImpl("3", "건물명(아파트명 등)!"));
            add(new ParameterImpl("4", "사서함+사서함번호!"));
            add(new ParameterImpl("5", "지번주소!"));
        }
    };
    

    
    private final List<Parameter> bestIconGbn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("01", "적용"));
            add(new ParameterImpl("N01", "미적용"));
        }
    }; 
    
    private final List<Parameter> bestIconGbnCn = new ArrayList<Parameter>(2) {
        { 
            add(new ParameterImpl("01", "적용!"));
            add(new ParameterImpl("N01", "미적용!"));
        }
    }; 
    

    
    private final List<Parameter> orderValidDate = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("0", "D-0(당일)"));
            add(new ParameterImpl("1", "D-1(전날)"));
            add(new ParameterImpl("2", "D-2(전전날)"));
        }
    }; 
    
    private final List<Parameter> orderValidDateCn = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("0", "D-0(当天 )!"));
            add(new ParameterImpl("1", "D-1(前一天)!"));
            add(new ParameterImpl("2", "D-2(前二天)!"));
        }
    }; 
    
    
    private final List<Parameter> storeFloor = new ArrayList<Parameter>(5) {
        { 
            add(new ParameterImpl("-1", "B1F"));
            add(new ParameterImpl("1", "01F"));
            add(new ParameterImpl("2", "02F")); 
            add(new ParameterImpl("3", "03F"));
        }
    }; 
    
    private final List<Parameter> storeFloorCn = new ArrayList<Parameter>(5) {
        { 
            add(new ParameterImpl("-1", "B1F"));
            add(new ParameterImpl("1", "01F"));
            add(new ParameterImpl("2", "02F")); 
            add(new ParameterImpl("3", "03F"));
        }
    }; 
    
    
    private final List<Parameter> winIssueYn = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("", "전체"));
            add(new ParameterImpl("Y", "발표"));
            add(new ParameterImpl("N", "대기"));
        }
    };
    
    private final List<Parameter> winIssueYnCn = new ArrayList<Parameter>(3) {
        { 
            add(new ParameterImpl("", "전체!"));
            add(new ParameterImpl("Y", "발표!"));
            add(new ParameterImpl("N", "대기!"));
        }
    };

    
    private final List<Parameter> week = new ArrayList<Parameter>(7) {
        { 
            add(new ParameterImpl("1", "월"));
            add(new ParameterImpl("2", "화"));
            add(new ParameterImpl("3", "수"));
            add(new ParameterImpl("4", "목"));
            add(new ParameterImpl("5", "금"));
            add(new ParameterImpl("6", "토"));
            add(new ParameterImpl("7", "일"));
        }
    }; 
    
    private final List<Parameter> weekCn = new ArrayList<Parameter>(7) {
        { 
            add(new ParameterImpl("1", "월!"));
            add(new ParameterImpl("2", "화!"));
            add(new ParameterImpl("3", "수!"));
            add(new ParameterImpl("4", "목!"));
            add(new ParameterImpl("5", "금!"));
            add(new ParameterImpl("6", "토!"));
            add(new ParameterImpl("7", "일!"));
        }
    }; 
    
    
    private final List<Parameter> orderStatCode2 = new ArrayList<Parameter>(15) {
         { 
             add(new ParameterImpl("00", "주문완료"));
             add(new ParameterImpl("01", "주문접수")); 
             add(new ParameterImpl("02", "상품준비완료"));
             add(new ParameterImpl("03", "상품준비완료"));
             add(new ParameterImpl("04", "상품준비완료"));
             add(new ParameterImpl("05", "운송준비중"));
             add(new ParameterImpl("06", "운송준비중"));
             add(new ParameterImpl("07", "운송준비중"));
             add(new ParameterImpl("08", "운송중"));
             add(new ParameterImpl("09", "운송중"));
             add(new ParameterImpl("10", "운송완료"));
             add(new ParameterImpl("11", "인도완료"));
             add(new ParameterImpl("90", "미인도"));
             add(new ParameterImpl("91", "재반입"));
             add(new ParameterImpl("99", "결제취소"));
         }
     };
     
     private final List<Parameter> orderStatCode2Cn = new ArrayList<Parameter>(15) {
         { 
             add(new ParameterImpl("00", "完成订购"));
             add(new ParameterImpl("01", "接受订购")); 
             add(new ParameterImpl("02", "正在准备商品"));
             add(new ParameterImpl("03", "正在准备商品"));
             add(new ParameterImpl("04", "正在准备商品"));
             add(new ParameterImpl("05", "正在准备运送"));
             add(new ParameterImpl("06", "正在准备运送"));
             add(new ParameterImpl("07", "正在准备运送"));
             add(new ParameterImpl("08", "运送中"));
             add(new ParameterImpl("09", "运送中"));
             add(new ParameterImpl("10", "运送完毕"));
             add(new ParameterImpl("11", "取货完毕"));
             add(new ParameterImpl("90", "未领取"));
             add(new ParameterImpl("91", "再运进"));
             add(new ParameterImpl("99", "取消付款"));
         }
     };
     
     
     private final List<Parameter> cnclAcptStatCode2 = new ArrayList<Parameter>(3) {
          {  
              add(new ParameterImpl("01", "취소접수"));
              add(new ParameterImpl("02", "취소처리중"));
              add(new ParameterImpl("03", "취소처리중"));
              add(new ParameterImpl("04", "취소완료")); 
          }
     };
     
     private final List<Parameter> cnclAcptStatCode2Cn = new ArrayList<Parameter>(3) {
         {  
             add(new ParameterImpl("01", "接受取消"));
             add(new ParameterImpl("02", "正在处理取消"));
             add(new ParameterImpl("03", "正在处理取消"));
             add(new ParameterImpl("04", "取消完毕")); 
         }
     };
    
     
     private final List<Parameter> splSrchDtGbn = new ArrayList<Parameter>(3) {
         {
             add(new ParameterImpl("N", "기간조회안함"));
             add(new ParameterImpl("O", "주문일"));
             add(new ParameterImpl("E", "출국일"));
         }
     };
     
     private final List<Parameter> splSrchDtGbnCn = new ArrayList<Parameter>(2) {
         {
             add(new ParameterImpl("O", "주문일!"));
             add(new ParameterImpl("E", "출국일!"));
         }
     };
     

     
     private final List<Parameter> airMainYn = new ArrayList<Parameter>(2) {
         { 
             add(new ParameterImpl("true", "주요항공"));
             add(new ParameterImpl("false", "기타항공"));
         }
     }; 
     
     private final List<Parameter> airMainYnCn = new ArrayList<Parameter>(2) {
         { 
             add(new ParameterImpl("true", "주요항공!"));
             add(new ParameterImpl("false", "기타항공!"));
         }
     }; 
     
     
     private final List<Parameter> orderInitYn = new ArrayList<Parameter>(4) {
         { 
             add(new ParameterImpl("N", "기본"));
             add(new ParameterImpl("X", "진행중"));
             add(new ParameterImpl("F", "실패수신"));
             add(new ParameterImpl("Y", "초기화 상태"));
         }
     }; 
     
     private final List<Parameter> orderInitYnCn = new ArrayList<Parameter>(4) {
         { 
             add(new ParameterImpl("N", "기본!"));
             add(new ParameterImpl("X", "진행중!"));
             add(new ParameterImpl("F", "실패수신!"));
             add(new ParameterImpl("Y", "초기화 상태!"));
         }
     }; 

     
     private final List<Parameter> smsAdminNum = new ArrayList<Parameter>(2) {
         { 
             add(new ParameterImpl("basic", "1577-0161"));
             add(new ParameterImpl("second", "051-749-1244"));
         }
     }; 
     
     private final List<Parameter> smsAdminNumCn = new ArrayList<Parameter>(2) {
         { 
             add(new ParameterImpl("basic", "1577-0161"));
             add(new ParameterImpl("second", "051-749-1244"));
         }
     }; 
     
     
     private final List<Parameter> salesDateType = new ArrayList<Parameter>(2) {
         { 
             add(new ParameterImpl("T", "티켓팅 일자"));
             add(new ParameterImpl("O", "주문일자"));
         }
     }; 
     
     private final List<Parameter> salesDateTypeCn = new ArrayList<Parameter>(2) {
         { 
             add(new ParameterImpl("T", "티켓팅 일자"));
             add(new ParameterImpl("O", "주문일자"));
         }
     }; 
     
     private final List<Parameter> sortType = new ArrayList<Parameter>(5) {
         {
             add(new ParameterImpl("best", "베스트순"));
             add(new ParameterImpl("hit", "인기상품순"));
             add(new ParameterImpl("new", "신상품순"));
             add(new ParameterImpl("lowPrice", "저가격순"));
             add(new ParameterImpl("hiPrice", "고가격순"));
         }
     };
     
     private final List<Parameter> sortTypeCn = new ArrayList<Parameter>(5) {
         {
             add(new ParameterImpl("best", "베스트순"));
             add(new ParameterImpl("hit", "인기상품순"));
             add(new ParameterImpl("new", "신상품순"));
             add(new ParameterImpl("lowPrice", "저가격순"));
             add(new ParameterImpl("hiPrice", "고가격순"));
         }
     };
     
    
     private final List<Parameter> salesProductType = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("", "전체"));
             add(new ParameterImpl("true", "외산품"));
             add(new ParameterImpl("false", "토산품"));
         }
     };
     
     private final List<Parameter> salesProductTypeCn = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("", "전체"));
             add(new ParameterImpl("true", "외산품"));
             add(new ParameterImpl("false", "토산품"));
         }
     };
     
     private final List<Parameter> salesDateGubun = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("day", "일자별"));
             add(new ParameterImpl("month", "월별"));
             add(new ParameterImpl("year", "연간"));
         }
     };
     
     private final List<Parameter> salesDateGubunCn = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("day", "일자별"));
             add(new ParameterImpl("month", "월별"));
             add(new ParameterImpl("year", "연간"));
         }
     };

     private final List<Parameter> orderGbn = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("1", "한국어 웹"));
             add(new ParameterImpl("2", "중국어 웹"));
             add(new ParameterImpl("3", "모바일"));
         }
     };

     private final List<Parameter> orderGbnCn = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("1", "韩国语网页"));
             add(new ParameterImpl("2", "中文网页"));
             add(new ParameterImpl("3", "手机版"));
         }
     };
     
     private final List<Parameter> sortGbn = new ArrayList<Parameter>(5) {
         { 
             add(new ParameterImpl("best", "인기순"));
             add(new ParameterImpl("hit", "hit"));
             add(new ParameterImpl("new", "신상품"));
             add(new ParameterImpl("lowPrice", "저가격순"));
             add(new ParameterImpl("hiPrice", "고가격순"));
             add(new ParameterImpl("review", "상품평순"));
         }
     };
     
     // 2014.3.26 중국어로 변역
     private final List<Parameter> sortGbnCn = new ArrayList<Parameter>(5) {
         { 
             add(new ParameterImpl("best", "排行榜"));
             add(new ParameterImpl("hit", "按人气商品排序"));
             add(new ParameterImpl("new", "按新商品排序"));
             add(new ParameterImpl("lowPrice", "按低价排序"));
             add(new ParameterImpl("hiPrice", "按高价排序"));
             add(new ParameterImpl("review", "按品牌排序"));
         }
     };
     
     private final List<Parameter> menuSearchType = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("", "전체"));
             add(new ParameterImpl("menuId", "메뉴ID"));
             add(new ParameterImpl("menuName", "메뉴명"));
         }
     };
     
     private final List<Parameter> menuSearchTypeCn = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("", "전체"));
             add(new ParameterImpl("menuId", "메뉴ID"));
             add(new ParameterImpl("menuName", "메뉴명"));
         }
     };
     
     private final List<Parameter> failGbn = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("R", "런타임"));
             add(new ParameterImpl("P", "사용"));
             add(new ParameterImpl("C", "사용취소"));
             add(new ParameterImpl("S", "적립"));
             add(new ParameterImpl("K", "적립취소"));
         }
     };
     
     private final List<Parameter> pymntMeansTypeCn = new ArrayList<Parameter>(3) {
         { 
             add(new ParameterImpl("06", "银联卡"));
             add(new ParameterImpl("01", "信用卡"));
             add(new ParameterImpl("02", "转账"));
         }
     };     
     
     private final List<Parameter> eventCmntSrchGbn = new ArrayList<Parameter>(3) {
         {
             add(new ParameterImpl("", "전체"));
             add(new ParameterImpl("D", "내용"));
             add(new ParameterImpl("I", "ID"));
         }
     };     
     
     public List<Parameter> getFailGbn() {
        return failGbn;
    }
     
     public List<Parameter> getFailGbn(String langCode) {
         return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? failGbn : failGbn;
     }

    public List<Parameter> getMenuSearchType() {
         return menuSearchType;
     }

     public List<Parameter> getMenuSearchType(String langCode) {
         return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? menuSearchTypeCn : menuSearchType;
     }
    
    public List<Parameter> getSalesDateGubun() {
        return salesDateGubun;
    }

    public List<Parameter> getSalesDateGubun(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? salesDateGubunCn : salesDateGubun;
    }
    
    public List<Parameter> getSortType() {
        return salesDateType;
    }
    
    public List<Parameter> getSortType(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? sortTypeCn : sortType;
    }

     public List<Parameter> getSalesDateType() {
         return salesDateType;
     }
     
     public List<Parameter> getSalesDateType(String langCode) {
         return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? salesDateTypeCn : salesDateType;
     }
     
     public List<Parameter> getSalesProductType() {
         return salesProductType;
     }
     public List<Parameter> getSalesProductType(String langCode) {
         return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? salesProductTypeCn : salesProductType;
     }
     
     public static void setInstance(GubunTagNote instance) {
         GubunTagNote.instance = instance;
     }

    public List<Parameter> getYnboolean() {
        return ynboolean;
    }
    
    public List<Parameter> getYnboolean(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? ynbooleanCn : ynboolean;
    }

    public List<Parameter> getAllBoolean() {
        return allBoolean;
    }

    public List<Parameter> getAllBoolean(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? allBooleanCn : allBoolean;
    }
    
    public List<Parameter> getNyboolean() {
        return nyboolean;
    }
    public List<Parameter> getNyboolean(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? nybooleanCn : nyboolean;
    }

    public List<Parameter> getNyAllBoolean() {
        return nyAllBoolean;
    }
    public List<Parameter> getNyAllBoolean(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? nyAllBooleanCn : nyAllBoolean;
    }

    public List<Parameter> getMailDomains() {
        return mailDomains;
    }
    public List<Parameter> getMailDomains(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? mailDomainsCn : mailDomains;
    }

    public List<Parameter> getHdphnNumGubun() {
        return hdphnNumGubun;
    }
    public List<Parameter> getHdphnNumGubun(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? hdphnNumGubunCn : hdphnNumGubun;
    }

    public List<Parameter> getYnString() {
        return ynString;
    }
    public List<Parameter> getYnString(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? ynStringCn : ynString;
    }

    public List<Parameter> getSendGbn() {
        return sendGbn;
    }
    public List<Parameter> getSendGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? sendGbnCn : sendGbn;
    }

    public List<Parameter> getBatchStatGbn() {
        return batchStatGbn;
    }
    public List<Parameter> getBatchStatGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? batchStatGbnCn : batchStatGbn;
    }

    public List<Parameter> getTabGbn() {
        return tabGbn;
    }
    public List<Parameter> getTabGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? tabGbnCn : tabGbn;
    }

    public List<Parameter> getUseYn() {
        return useYn;
    }
    public List<Parameter> getUseYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? useYnCn : useYn;
    }

    public List<Parameter> getDispAllYn() {
        return dispAllYn;
    }
    public List<Parameter> getDispAllYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? dispAllYnCn : dispAllYn;
    }

    public List<Parameter> getBoardSrchGbn() {
        return boardSrchGbn;
    }
    public List<Parameter> getBoardSrchGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? boardSrchGbnCn : boardSrchGbn;
    }

    public List<Parameter> getBoardSrchGbn2() {
        return boardSrchGbn2;
    }
    public List<Parameter> getBoardSrchGbn2(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? boardSrchGbn2Cn : boardSrchGbn2;
    }

    public List<Parameter> getBoardSrchGbn3() {
        return boardSrchGbn3;
    }
    public List<Parameter> getBoardSrchGbn3(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? boardSrchGbn3Cn : boardSrchGbn3;
    }

    public List<Parameter> getGenderGbn() {
        return genderGbn;
    }
    public List<Parameter> getGenderGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? genderGbnCn : genderGbn;
    }

    public List<Parameter> getProStateGbn() {
        return proStateGbn;
    }
    public List<Parameter> getProStateGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? proStateGbnCn : proStateGbn;
    }

    public List<Parameter> getSplSellStateGbn() {
        return splSellStateGbn;
    }
    public List<Parameter> getSplSellStateGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? splSellStateGbnCn : splSellStateGbn;
    }

    public List<Parameter> getDispEttGbn() {
        return dispEttGbn;
    }
    public List<Parameter> getDispEttGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? dispEttGbnCn : dispEttGbn;
    }

    public List<Parameter> getYnAllBoolean() {
        return ynAllBoolean;
    }
    public List<Parameter> getYnAllBoolean(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? ynAllBooleanCn : ynAllBoolean;
    }

    public List<Parameter> getPayGbn() {
        return payGbn;
    }
    public List<Parameter> getPayGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? payGbnCn : payGbn;
    }

    public List<Parameter> getPayGbnExceptAll() {
        return payGbnExceptAll;
    }
    public List<Parameter> getPayGbnExceptAll(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? payGbnExceptAllCn : payGbnExceptAll;
    }

    public List<Parameter> getSendYn() {
        return sendYn;
    }
    public List<Parameter> getSendYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? sendYnCn : sendYn;
    }

    public List<Parameter> getUserNameGbn() {
        return userNameGbn;
    }
    public List<Parameter> getUserNameGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? userNameGbnCn : userNameGbn;
    }

    public List<Parameter> getAllNotUserGbn() {
        return allNotUserGbn;
    }
    public List<Parameter> getAllNotUserGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? allNotUserGbnCn : allNotUserGbn;
    }

    public List<Parameter> getAllNotGenderGbn() {
        return allNotGenderGbn;
    }
    public List<Parameter> getAllNotGenderGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? allNotGenderGbnCn : allNotGenderGbn;
    }

    public List<Parameter> getAllYnString() {
        return allYnString;
    }
    public List<Parameter> getAllYnString(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? allYnStringCn : allYnString;
    }

    public List<Parameter> getFcYn() {
        return fcYn;
    }
    public List<Parameter> getFcYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? fcYnCn : fcYn;
    }

    public List<Parameter> getDispTgtCode() {
        return dispTgtCode;
    }
    public List<Parameter> getDispTgtCode(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? dispTgtCodeCn : dispTgtCode;
    }

    public List<Parameter> getDispYn() {
        return dispYn;
    }
    public List<Parameter> getDispYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? dispYnCn : dispYn;
    }

    public List<Parameter> getOpenYn() {
        return openYn;
    }
    public List<Parameter> getOpenYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? openYnCn : openYn;
    }

    public List<Parameter> getPrmYn() {
        return prmYn;
    }
    public List<Parameter> getPrmYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? prmYnCn : prmYn;
    }

    public List<Parameter> getLtlTitleDispGbn() {
        return ltlTitleDispGbn;
    }
    public List<Parameter> getLtlTitleDispGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? ltlTitleDispGbnCn : ltlTitleDispGbn;
    }

    public List<Parameter> getAreaNumGubun() {
        return areaNumGubun;
    }
    public List<Parameter> getAreaNumGubun(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? areaNumGubunCn : areaNumGubun;
    }

    public List<Parameter> getPostNumGbn() {
        return postNumGbn;
    }
    public List<Parameter> getPostNumGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? postNumGbnCn : postNumGbn;
    }

    public List<Parameter> getBestIconGbn() {
        return bestIconGbn;
    }
    public List<Parameter> getBestIconGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? bestIconGbnCn : bestIconGbn;
    }

    public List<Parameter> getOrderValidDate() {
        return orderValidDate;
    }
    public List<Parameter> getOrderValidDate(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? orderValidDateCn : orderValidDate;
    }

    public List<Parameter> getStoreFloor() {
        return storeFloor;
    }
    public List<Parameter> getStoreFloor(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? storeFloorCn : storeFloor;
    }

    public List<Parameter> getWinIssueYn() {
        return winIssueYn;
    }
    public List<Parameter> getWinIssueYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? winIssueYnCn : winIssueYn;
    }

    public List<Parameter> getWeek() {
        return week;
    }
    public List<Parameter> getWeek(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? weekCn : week;
    }

    public List<Parameter> getOrderStatCode2() {
        return orderStatCode2;
    }
    public List<Parameter> getOrderStatCode2(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? orderStatCode2Cn : orderStatCode2;
    }

    public List<Parameter> getCnclAcptStatCode2() {
        return cnclAcptStatCode2;
    }
    public List<Parameter> getCnclAcptStatCode2(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? cnclAcptStatCode2Cn : cnclAcptStatCode2;
    }

    public List<Parameter> getSplSrchDtGbn() {
        return splSrchDtGbn;
    }
    public List<Parameter> getSplSrchDtGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? splSrchDtGbnCn : splSrchDtGbn;
    }

    public List<Parameter> getAirMainYn() {
        return airMainYn;
    }
    public List<Parameter> getAirMainYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? airMainYnCn : airMainYn;
    }

    public List<Parameter> getOrderInitYn() {
        return orderInitYn;
    }
    public List<Parameter> getOrderInitYn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? orderInitYnCn : orderInitYn;
    }

    public List<Parameter> getSmsAdminNum() {
        return smsAdminNum;
    }
    public List<Parameter> getSmsAdminNum(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? smsAdminNumCn : smsAdminNum;
    }

    public List<Parameter> getOrderGbn() {
        return orderGbn;
    }
    public List<Parameter> getOrderGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? orderGbnCn : orderGbn;
    }

    public List<Parameter> getSortGbn() {
        return sortGbn;
    }
    public List<Parameter> getSortGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? sortGbnCn : sortGbn;
    }

    public List<Parameter> getLocalGbn() {
        return localGbn;
    }
    public List<Parameter> getLocalGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? localGbnCn : localGbn;
    }
    
    public List<Parameter> getPhoneCorpGbn() {
        return phoneCorpGbn;
    }
    public List<Parameter> getPhoneCorpGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? phoneCorpGbnCn : phoneCorpGbn;
    }
    
    
    public List<Parameter> getPymntMeansTypeCn() {
        return pymntMeansTypeCn;
    }
    public List<Parameter> getPymntMeansTypeCn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? pymntMeansTypeCn : pymntMeansTypeCn;
    }    
    public List<Parameter> getEventCmntSrchGbn() {
        return eventCmntSrchGbn;
    }
    public List<Parameter> getEventCmntSrchGbn(String langCode) {
        return CodeName.SITE_NATN_CODE_CN.equals(langCode) ? eventCmntSrchGbn : eventCmntSrchGbn;
    }
}
