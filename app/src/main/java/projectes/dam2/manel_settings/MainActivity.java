package projectes.dam2.manel_settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    TextView lbl, txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.tvMail);
        lbl = (TextView) findViewById(R.id.lblMail);
        rl = (RelativeLayout) findViewById(R.id.rl);

actualitza();
    }

    @Override
    protected void onResume(){
        super.onResume();
        actualitza();
    }

    public void actualitza(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String txtColor = sp.getString("opt2", "#000000");
        String mail = sp.getString("opt1", "-");
        String bgColor = sp.getString("opt3", "#ffffff");

        int text = Color.parseColor(txtColor);
        int bckg = Color.parseColor(bgColor);

        txt.setTextColor(text);
        lbl.setTextColor(text);
        txt.setText(mail);
        rl.setBackgroundColor(bckg);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.options) {
           Intent i = new Intent(getApplicationContext(), Settings.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
