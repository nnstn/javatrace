package com.nuoya.design.prototype.simple;

/**
 * @author wangjn_bj 2020/5/27
 */
public class PrototypeTest {
    public static void main(String[] args) {
        SunWuKong sunWuKong = new SunWuKong();
        sunWuKong.setRange("72变");

        JingGuBang jingGuBang = new JingGuBang();
        jingGuBang.setHigh(7201);
        jingGuBang.setWegiht(1222);
        jingGuBang.setDescribe("mydescribe");
        sunWuKong.setJingGuBang(jingGuBang);

        try {
            SunWuKong huaguoshan = (SunWuKong)sunWuKong.clone();

            System.out.println(sunWuKong==huaguoshan);
            System.out.println(sunWuKong.getJingGuBang()==huaguoshan.getJingGuBang());
            System.out.println(huaguoshan);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
