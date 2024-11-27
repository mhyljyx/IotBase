package com.tztang.enums;

/**
 * 用户类型
 * @author tztang
 * @since 2024-11-27
 */
public enum UserTypeEnum {

    USER_FORMAL(1, "正式"),

    USER_TEMPORARY(2, "临时"),

    USER_TRIAL_DELAY(3, "试用延期"),

    USER_LETTING_GO(4, "解聘"),

    USER_RESIGN(5, "离职"),

    USER_retire(6, "退休"),

    USER_invalid(7, "无效");

    private final Integer code;

    private String name = "";

    UserTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name == null ? "" : this.name;
    }

    public static String getName(Integer code) {
        for (UserTypeEnum re : UserTypeEnum.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re.name;
            }
        }
        return "";
    }

    public static UserTypeEnum getRc(Integer code) {
        for (UserTypeEnum re : UserTypeEnum.values()) {
            if (re.code.intValue() == code.intValue()) {
                return re;
            }
        }
        return null;
    }

}
