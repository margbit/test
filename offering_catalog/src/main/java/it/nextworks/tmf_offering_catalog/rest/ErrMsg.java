package it.nextworks.tmf_offering_catalog.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrMsg {

    @JsonProperty("msg")
    private String msg;

    @JsonCreator
    public ErrMsg(@JsonProperty("msg") String msg) { this.msg = msg; }

    public void setMsg(String msg) { this.msg = msg; }

    public String getMsg() { return msg; }
}
