package org.educandoweb.educaweb.enums;

public enum OrderStatusEnum {
    WAITING_PAYMENT(1),
    PAID(2),
    CANCELLED(5),
    SHIPPED(3),
    DELIVERED(4);

    private int code;

     OrderStatusEnum(int code){
        this.code = code;
    }

    public int getCode() {
         return code;
    }

    public static OrderStatusEnum valueOf(int code){
         for(OrderStatusEnum e: OrderStatusEnum.values()){
             if(e.getCode() == code){
                 return e;
             }
         }
         throw new IllegalArgumentException("code " + code + " not found");
    }
}
