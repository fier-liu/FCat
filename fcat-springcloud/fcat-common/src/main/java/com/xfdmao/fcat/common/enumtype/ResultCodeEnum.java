package com.xfdmao.fcat.common.enumtype;

/**
 * Created by xiangfei on 2017/7/3.
 */
public enum ResultCodeEnum {
    SUCCESS("success",0),FAIL("fail",1),NOLOGIN("no login",100),
    EMAILCHECKFAIL("email check fail",1000), USER_EXIST("user exist",101);
    private String key;
    private Integer value;

    private ResultCodeEnum(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 根据value值 获取key值
     *
     * @param value
     * @return
     */
    public static String getString(Integer value) {
        ResultCodeEnum[] values = ResultCodeEnum.values();
        for (ResultCodeEnum alarmStatus : values) {
            if (alarmStatus.getValue() == value) {
                return alarmStatus.getKey();
            }
        }
        return null;
    }

    /**
     * 根据value值 获取key值
     *
     * @param value
     * @return
     */
    public static boolean isContainValue(Integer value) {
        ResultCodeEnum[] values = ResultCodeEnum.values();
        for (ResultCodeEnum obj : values) {
            if (obj.getValue() == value) {
                return true;
            }
        }
        return false;
    }
}
