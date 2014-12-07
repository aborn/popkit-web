package org.popkit.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author guobao.jiang
 * @date 12/8/14
 * @time 12:09 AM
 */
public class BaseAction extends ActionSupport {
    private String info;     // 返回给html的消息

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
