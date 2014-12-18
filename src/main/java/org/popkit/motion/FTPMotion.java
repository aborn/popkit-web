package org.popkit.motion;

import org.apache.commons.lang.StringUtils;

/**
 * @author guobao.jiang
 * @date 12/8/14
 * @time 12:11 AM
 */
public class FTPMotion extends BaseMotion{
    public static void main(String[] args) {
        String test = "-12";
        Integer testInt = Integer.parseInt(test);
        boolean isTrue = StringUtils.isNumeric(test);
        if (isTrue) {
            System.out.print(test + "is a Numeric" );
        } else {
            System.out.print(test + "is not a Numeric" + testInt);
        }
    }
}
