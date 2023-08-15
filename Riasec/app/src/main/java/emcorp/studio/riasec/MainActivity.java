package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import emcorp.studio.riasec.Library.ButtonClick;

public class MainActivity extends AppCompatActivity {
    ImageButton btnRealistic, btnInvestigative, btnArtistic, btnSocial, btnEnterprising, btnConventional;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btnRealistic = findViewById(R.id.btnRealistic);
        btnInvestigative = findViewById(R.id.btnInvestigative);
        btnArtistic = findViewById(R.id.btnArtistic);
        btnSocial = findViewById(R.id.btnSocial);
        btnEnterprising = findViewById(R.id.btnEnterprising);
        btnConventional = findViewById(R.id.btnConventional);

        btnRealistic.setOnTouchListener(new ButtonClick());
        btnInvestigative.setOnTouchListener(new ButtonClick());
        btnArtistic.setOnTouchListener(new ButtonClick());
        btnSocial.setOnTouchListener(new ButtonClick());
        btnEnterprising.setOnTouchListener(new ButtonClick());
        btnConventional.setOnTouchListener(new ButtonClick());

        btnRealistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RealisticActivity.class));
                finish();
            }
        });

        btnInvestigative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InvestigativeActivity.class));
                finish();
            }
        });

        btnArtistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ArtisticActivity.class));
                finish();
            }
        });

        btnSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SocialActivity.class));
                finish();
            }
        });

        btnEnterprising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EnterprisingActivity.class));
                finish();
            }
        });

        btnConventional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ConventionalActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,WelcomeActivity.class));
        finish();
    }
}
