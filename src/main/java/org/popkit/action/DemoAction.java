package org.popkit.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author guobao.jiang
 * @date 12/7/14
 * @time 11:06 PM
 */
public class DemoAction extends ActionSupport{
    private String info;
    @Override
    public String execute() throws Exception {
        info = "good luk!";
        return SUCCESS;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
