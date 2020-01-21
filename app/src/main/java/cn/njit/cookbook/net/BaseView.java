package cn.njit.cookbook.net;

/**
 * 作者：赵若位
 * 时间：2018/10/24 10:40
 * 邮箱：1070138445@qq.com
 * 功能：
 */
public interface BaseView
{
    /*显示错误信息*/
    void showErrorMsg(String msg);

    /*显示错误页面*/
    void showError();

    /*显示加载页面*/
    void showLoading();

    /*关闭加载页面*/
    void dissLoading();

    /*显示主页面*/
    void showContent();

    /*加载数据*/
    void showData(Object o);
}
