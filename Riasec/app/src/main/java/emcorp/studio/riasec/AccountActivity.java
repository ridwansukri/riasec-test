package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import emcorp.studio.riasec.Library.ButtonClick;
import emcorp.studio.riasec.Library.Constant;
import emcorp.studio.riasec.Library.SharedPrefManager;

public class AccountActivity extends AppCompatActivity {
    EditText edtNama, edtNis, edtNamaSekolah, edtKelas, edtAlamat;
    ImageButton btnSelanjutnya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().hide();
        edtNama = findViewById(R.id.edtNama);
        edtNis = findViewById(R.id.edtNis);
        edtNamaSekolah = findViewById(R.id.edtNamaSekolah);
        edtKelas = findViewById(R.id.edtKelas);
        edtAlamat = findViewById(R.id.edtAlamat);
        btnSelanjutnya = findViewById(R.id.btnSelanjutnya);

        btnSelanjutnya.setOnTouchListener(new ButtonClick());

        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edtNama.getText().toString();
                String nis = edtNis.getText().toString();
                String namasekolah = edtNamaSekolah.getText().toString();
                String kelas = edtKelas.getText().toString();
                String alamat = edtAlamat.getText().toString();
                if(!nama.equals("")||!nis.equals("")||!namasekolah.equals("")||!kelas.equals("")||!alamat.equals("")){
                    //Proses
                    SharedPrefManager.getInstance(getApplicationContext()).setReferences(Constant.PREFERENCES_NAMA,nama);
                    SharedPrefManager.getInstance(getApplicationContext()).setReferences(Constant.PREFERENCES_NIS,nis);
                    SharedPrefManager.getInstance(getApplicationContext()).setReferences(Constant.PREFERENCES_NAMA_SEKOLAH,namasekolah);
                    SharedPrefManager.getInstance(getApplicationContext()).setReferences(Constant.PREFERENCES_KELAS,kelas);
                    SharedPrefManager.getInstance(getApplicationContext()).setReferences(Constant.PREFERENCES_ALAMAT,alamat);
                    startActivity(new Intent(AccountActivity.this,MulaiActivity.class));
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Data harus diisi semua!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,WelcomeActivity.class));
        finish();
    }
}
