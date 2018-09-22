package com.ky.ct.rzdj.dto;

public class Msg {
    private int state;
    private String msg;

    public Msg() {
    }

    public Msg(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                '}';
    }
}
