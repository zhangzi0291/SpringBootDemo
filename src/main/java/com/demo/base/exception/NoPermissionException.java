package com.demo.base.exception;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2017/12/1 10:22
 */
public class NoPermissionException extends Exception {

    public NoPermissionException(){

    }

    public NoPermissionException(String message){
        super(message);
    }

}
