package org.popkit.action;

/**
 * @author guobao.jiang
 * @date 12/7/14
 * @time 11:06 PM
 */
public class DemoAction extends BaseAction {
    private String url;
    @Override
    public String execute() throws Exception {
        setPageTitle("good");
        setInfo("good luk!");
        return SUCCESS;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
