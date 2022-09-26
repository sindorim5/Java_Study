package com.ssafy.springtest.dto;

public class CountryStatusDto {
    private int seq;
    private String cname;
    private int population;
    private String rcode;
    
    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public String getRcode() {
        return rcode;
    }
    public void setRcode(String rcode) {
        this.rcode = rcode;
    }
    
    @Override
    public String toString() {
        return "CountryStatusDto [seq=" + seq + ", cname=" + cname + ", population=" + population + ", rcode=" + rcode
                + "]";
    }
}
