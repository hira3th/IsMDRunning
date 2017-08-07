package com.example.mathias.ismdrunning.json_objects.show_request;

import java.util.List;

/**
 * Created by Mathias on 14.07.2017.
 */

public class Broadcast implements Comparable{
    private Integer id;
    private Integer stationID;
    private String title;
    private String v;
    private String u;
    private Integer startTime;
    private Integer duration;
    private String l;
    private String t;
    private Boolean a;
    private Boolean b;
    private Boolean c;
    private Boolean d;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private String j;
    private String q;
    private Object k;
    private Boolean e;
    private List<Integer> m = null;

    @Override
    public int compareTo(Object o) {
        Broadcast temp = (Broadcast) o;
        return (this.startTime == temp.getStartTime()) ? 0 : (this.startTime > temp.getStartTime()) ? -1 : 1;

    }
    public Integer getStationID() {return stationID;}

    public void setStationID(int stationID){
        this.stationID = stationID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Boolean getA() {
        return a;
    }

    public void setA(Boolean a) {
        this.a = a;
    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    public Boolean getC() {
        return c;
    }

    public void setC(Boolean c) {
        this.c = c;
    }

    public Boolean getD() {
        return d;
    }

    public void setD(Boolean d) {
        this.d = d;
    }

    public Boolean getF() {
        return f;
    }

    public void setF(Boolean f) {
        this.f = f;
    }

    public Boolean getG() {
        return g;
    }

    public void setG(Boolean g) {
        this.g = g;
    }

    public Boolean getH() {
        return h;
    }

    public void setH(Boolean h) {
        this.h = h;
    }

    public Boolean getI() {
        return i;
    }

    public void setI(Boolean i) {
        this.i = i;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Object getK() {
        return k;
    }

    public void setK(Object k) {
        this.k = k;
    }

    public Boolean getE() {
        return e;
    }

    public void setE(Boolean e) {
        this.e = e;
    }

    public List<Integer> getM() {
        return m;
    }

    public void setM(List<Integer> m) {
        this.m = m;
    }
}
