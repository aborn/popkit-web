package org.popkit.action;

/**
 * @author guobao.jiang
 * @date 12/7/14
 * @time 11:06 PM
 */
public class DemoAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        setInfo("good luk!");
        return SUCCESS;
    }
}
