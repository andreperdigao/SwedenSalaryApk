package andre.perdigao.cursoandroid.salaryinsweden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class InitActivity extends AppCompatActivity {

    int waitTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        changeScreen();
    }

    private void changeScreen(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent changeScreenInt = new Intent(InitActivity.this, MainActivity.class);
                startActivity(changeScreenInt);
                finish();
            }
        },waitTime);

    }

}