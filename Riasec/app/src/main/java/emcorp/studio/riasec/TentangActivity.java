package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import emcorp.studio.riasec.Library.ButtonClick;

public class TentangActivity extends AppCompatActivity {
    ImageButton btnSelanjutnya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        getSupportActionBar().hide();

        btnSelanjutnya = findViewById(R.id.btnSelanjutnya);
        btnSelanjutnya.setOnTouchListener(new ButtonClick());
        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TentangActivity.this,WelcomeActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
        finish();
    }
}
