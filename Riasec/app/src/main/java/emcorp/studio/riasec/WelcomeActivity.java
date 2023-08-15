package emcorp.studio.riasec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import emcorp.studio.riasec.Library.ButtonClick;

public class WelcomeActivity extends AppCompatActivity {
    ImageButton btnCariTahu,btnPelajari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();

        btnCariTahu = findViewById(R.id.btnCariTahu);
        btnPelajari = findViewById(R.id.btnPelajari);
        btnPelajari.setOnTouchListener(new ButtonClick());
        btnCariTahu.setOnTouchListener(new ButtonClick());
        btnPelajari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        });
        btnCariTahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,AccountActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,TentangActivity.class));
        finish();
    }
}
