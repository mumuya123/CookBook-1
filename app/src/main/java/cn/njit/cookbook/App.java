package cn.njit.cookbook;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import cn.njit.cookbook.model.UserBean;
import cn.njit.cookbook.sql.DBManager;
import cn.njit.cookbook.sql.DaoSession;
import cn.njit.cookbook.utils.InitializeManager;

/**
 * 作者：赵若位
 * 时间：2018/3/27 16:40
 * 邮箱：1070138445@qq.com
 * 功能：
 */

public class App extends Application
{

    private static Context mContext;
    public static DaoSession mSession = null;
    private static UserBean mUser = null;


    @Override
    public void onCreate()
    {
        super.onCreate();
        mContext = getApplicationContext();
        mSession = DBManager.getManager().init(this);
        InitializeManager.init(mContext);
    }


    public static Context getContext()
    {
        return mContext;
    }


    public static UserBean getCacheUser()
    {
        return mUser;
    }

    public static void setUser(UserBean user)
    {
        mUser = user;
    }

}
