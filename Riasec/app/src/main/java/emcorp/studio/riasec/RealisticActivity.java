package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import emcorp.studio.riasec.Library.ButtonClick;

public class RealisticActivity extends AppCompatActivity {
    ImageButton btnSelanjutnya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realistic);
        getSupportActionBar().hide();
        btnSelanjutnya = findViewById(R.id.btnSelanjutnya);
        btnSelanjutnya.setOnTouchListener(new ButtonClick());
        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RealisticActivity.this,InvestigativeActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
