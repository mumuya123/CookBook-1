package cn.njit.cookbook.net;

/**
 * 作者：赵若位
 * 时间：2018/11/28 17:21
 * 邮箱：1070138445@qq.com
 * 功能：
 */
public class ApiException extends Exception
{
    public static final int NO_LOGIN = 401;//未登录


    private int code;

    public ApiException(String message)
    {
        super(message);
    }

    public ApiException(String message, int code)
    {
        super(message);
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }
}
