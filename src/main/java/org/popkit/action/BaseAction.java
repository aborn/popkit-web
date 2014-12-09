package org.popkit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author guobao.jiang
 * @date 12/8/14
 * @time 12:09 AM
 */
public class BaseAction extends ActionSupport implements Preparable, ServletResponseAware{
    private String info;     // 返回给html的消息
    private String pageTitle = "popkit";
    private String panelName = "popkit";

    protected HttpServletResponse response;
    protected JSONObject data;
    private ActionContext actionContext = ActionContext.getContext();

    @Override
    public void prepare() throws Exception {
        response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
        data = new JSONObject();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public String execute() throws Exception {
        data.put("status", "success");
        data.put("info", info);

        response.getWriter().print(data.toString());
        return null;
        //return super.execute();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    /**
     * 向浏览器返回一个ajax的响应,json格式
     *
     * @param data
     */
    protected void writeResponse(Object data) {
        Writer writer = null;
        try {
            setHtmlContentNoCacheHeader(response);
            writer = response.getWriter();
            response.getWriter().print(data.toString());
        } catch (IOException e) {
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }


    /**
     * 设置响应的内容类型及编码，同时设置不缓存的头信息
     *
     * @param response
     */
    public static void setHtmlContentNoCacheHeader(HttpServletResponse response) {
        setContentTypeHeader(response);
        setNoCacheHeader(response);
    }

    /**
     * 设置不缓存响应头
     *
     * @param response http响应
     */
    public static void setNoCacheHeader(HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache,no-store");
        response.setDateHeader("Expires", 0);
    }

    /**
     * 设置content-type header以及响应编码,编码从response中的getCharacterEncoding获取编码，如果此编码为空则设置为默认编码（默认为UTF-8）
     *
     * @param response http响应
     */
    public static void setContentTypeHeader(HttpServletResponse response) {
        String encoding = response.getCharacterEncoding();
        if (StringUtils.isBlank(encoding)) {
            encoding = "utf-8";
            response.setCharacterEncoding(encoding);
        }
        response.setContentType("text/html;charset=" + encoding);
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }
}
