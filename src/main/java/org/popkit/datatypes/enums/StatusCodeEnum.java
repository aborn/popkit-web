package org.popkit.datatypes.enums;

/**
 * @author guobao.jiang
 * @date 12/11/14
 * @time 12:11 AM
 */
public enum  StatusCodeEnum {
    ERROR("error"),
    FAILED("failed"),
    SUCCESS("success"),
    PARAM_ILLEGAL("param_illegal"),
    ;
    private String value;

    private StatusCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
