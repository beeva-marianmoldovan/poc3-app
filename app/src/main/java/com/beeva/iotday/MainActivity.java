package com.beeva.iotday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.beeva.ubiqlibrary.UbiqonsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UbiqonsManager.register(this, "fac62835-9bx6-46e0-9d11-a7ac02929660", "xyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX3JvbGUiOiJVc2VyIiwidXVpZCI6ImZhYzYyODM1LTliZTYtNDZlMC05ZDExLWE3YWMwMjkyOTY2MCIsImlhdCI6MTQ0MDA2MDczN30.8vFpAZWDP3drITO3OFY_Jclc0jHGgl2aa0srVTPeol4", "test_group", "test_user");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
