package kr.tjeit.googleintent_20181222_01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extenzds AppCompatActivity {

    public Context mContext =this;

    public abstract void setupEvents();
    public abstract void setValues ();
    public abstract void bindViews();
}
