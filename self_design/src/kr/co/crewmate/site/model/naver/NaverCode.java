package kr.co.crewmate.site.model.naver;

import java.util.HashSet;
import java.util.Set;

public class NaverCode {
    
    private Set<String> naverCodes = new HashSet<String>();
    
    private String naverCode;

    public Set<String> getNaverCodes() {
        return naverCodes;
    }

    public void setNaverCodes(Set<String> naverCodes) {
        this.naverCodes = naverCodes;
    }

    public String getNaverCode() {
        return naverCode;
    }

    public void setNaverCode(String naverCode) {
        this.naverCode = naverCode;
    }

    public void add(String prdtCode) {
        this.naverCodes.add(prdtCode);
    }

    public boolean contains(String prdtCode) {
        return this.naverCodes.contains(prdtCode);
    }
}
