package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import emcorp.studio.riasec.Library.ButtonClick;
import emcorp.studio.riasec.Library.Constant;
import emcorp.studio.riasec.Library.SharedPrefManager;

public class MulaiActivity extends AppCompatActivity {
    ImageButton btnMulai;
    TextView tvNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai);
        getSupportActionBar().hide();
        btnMulai = findViewById(R.id.btnMulai);
        tvNama = findViewById(R.id.tvNama);
        tvNama.setText(SharedPrefManager.getInstance(getApplicationContext()).getReferences(Constant.PREFERENCES_NAMA));
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},00);
        btnMulai.setOnTouchListener(new ButtonClick());
        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MulaiActivity.this,PertanyaanActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,AccountActivity.class));
        finish();
    }
}
