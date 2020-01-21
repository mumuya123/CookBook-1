package cn.njit.cookbook.model;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：赵若位
 * 时间：2019/1/2 17:19
 * 邮箱：1070138445@qq.com
 * 功能：
 */
public class BaseBean<T>
{
    @SerializedName("resultcode")
    private int code;
    @SerializedName("reason")
    private String msg;
    @SerializedName("result")
    private T t;


    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getT()
    {
        return t;
    }

    public void setT(T t)
    {
        this.t = t;
    }
}
