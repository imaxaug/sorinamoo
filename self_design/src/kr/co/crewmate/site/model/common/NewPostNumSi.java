package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ToString;

public class NewPostNumSi extends ToString implements Parameter{

    private int seq;
    
    private String si;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    @Override
    public String getKey() {
        return getSi();
    }

    @Override
    public String getValue() {
        return getSi();
    }
    
    
}
