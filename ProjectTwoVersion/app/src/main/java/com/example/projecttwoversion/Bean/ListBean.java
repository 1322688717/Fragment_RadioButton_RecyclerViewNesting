package com.example.projecttwoversion.Bean;

import java.io.Serializable;

/**
 * Author : i小灰
 * blog : https://www.jianshu.com/u/37d88b909f3b
 * time   : 2021/5/21 16:29
 * desc   : 数据集合
 */
public class ListBean implements Serializable {
    /**
     * name : 灰灰
     */
  private String equpment,solvent,time,state;

    public String getEqupment() {
        return equpment;
    }

    public void setEqupment(String equpment) {
        this.equpment = equpment;
    }

    public String getSolvent() {
        return solvent;
    }

    public void setSolvent(String solvent) {
        this.solvent = solvent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}