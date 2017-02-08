package com.ce.switchlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar _Toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(_Toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int _ItemId=item.getItemId();
        switch (_ItemId) {
            case R.id.chinese:
                if (LocaleUtils.needUpdateLocale(this, LocaleUtils.LOCALE_CHINESE)) {
                    LocaleUtils.updateLocale(this, LocaleUtils.LOCALE_CHINESE);
                    restartAct();
                }
               break;
            case R.id.english:
                if (LocaleUtils.needUpdateLocale(this, LocaleUtils.LOCALE_ENGLISH)) {
                    LocaleUtils.updateLocale(this, LocaleUtils.LOCALE_ENGLISH);
                    restartAct();
                }
                break;
            case R.id.russian:
                if (LocaleUtils.needUpdateLocale(this, LocaleUtils.LOCALE_RUSSIAN)) {
                    LocaleUtils.updateLocale(this, LocaleUtils.LOCALE_RUSSIAN);
                    restartAct();
                }
        }
        return true;
    }

    /**
     * 重启当前Activity
     */
    private void restartAct() {
        finish();
        Intent _Intent = new Intent(this, MainActivity.class);
        startActivity(_Intent);
        //清除Activity退出和进入的动画
        overridePendingTransition(0, 0);
    }
}
