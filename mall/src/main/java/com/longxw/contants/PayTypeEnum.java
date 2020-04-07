package com.longxw.contants;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  PayTypeEnum{
    WX_HONGBAO(100, "微信红包"){
        @Override
        public boolean isWechatPay(){
            return true;
        }
    },
    WX_ZHUANZHANG(101, "微信转账"),
    WX_QUNSHOUKUAN(102, "微信群收款"),
    WX_ERWEIMA(103, "微信二维码收付款"),
    WX_SHANGHUXIAOFEI(104, "微信商户消费"),
    WX_CHONGZHITIXIAN(105, "充值提现"),
    WX_XINYONGKAHUANKUAN(106, "信用卡还款"),
    WX_YOUTUIKUAN(107, "退款"),

    ZFB_ZHUANZHANG(200, "支付宝转账"),
    ZFB_ERWEIMASHOUFUKUAN(201, "支付宝二维码收付款");

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String lable;

    PayTypeEnum(int code, String lable){
        this.code = code;
        this.lable = lable;
    }

    public Integer getCode() {
        return code;
    }

    public String getLable() {
        return lable;
    }

    public boolean isWechatPay(){
        return false;
    }

    public boolean isZfbPay(){
        return false;
    }
}
