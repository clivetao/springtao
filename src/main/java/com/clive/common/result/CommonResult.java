package com.clive.common.result;

public class CommonResult<T> {
    private long code;
    private String message;
    private T data;
    public CommonResult() {
    }
    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T>CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    public static <T>CommonResult<T> success(String message,T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),message,data);
    }


    public static CommonResult success(){
        return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
    }

    public static CommonResult success(String message){
        return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
    }

    /**
     * 请求失败
     * @param
     * @return
     */

    public static CommonResult fail(){
        return new CommonResult<>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null);
    }

    public static CommonResult fail(String message){
        return new CommonResult<>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 没有相关权限
     * @param
     * @return
     */
    public static CommonResult unauthorized(){
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),null);
    }
    public static CommonResult unauthorized(String message){
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(),message,null);
    }


    /**
     * 参数验证失败
     * @param
     * @return
     */
    public static  CommonResult validate_fail(){
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(),ResultCode.VALIDATE_FAILED.getMessage(),null);
    }

    public static CommonResult validate_fail(String message){
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }


    /**
     * token已经过期
     * @param
     * @return
     */
    public static  CommonResult forbidden(){
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),null);
    }

    public static  CommonResult forbidden(String message){
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(),message,null);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
