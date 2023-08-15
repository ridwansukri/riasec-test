package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaranActivity extends AppCompatActivity {
    String[][] saran = {
            {"Automotive Engineer","RIE","R"},
            {"Electrician","RIE","R"},
            {"Solar-Energy Systems Designer","RIC","R"},
            {"Wildlife Control Agent","RSE","R"},
            {"Airplane Inspector","RES","R"},
            {"Audiovisual Technician","RCI","R"},
            {"Surgeon","IRA","R"},
            {"Radiologist","IRS","R"},
            {"Environmental Analyst","IRE","R"},
            {"Commercial Airplane Pilot","RIE","R"},
            {"Optical Engineer","RIC","R"},
            {"Cook","RAS","R"},
            {"Ship Pilot","REI","R"},
            {"Locomotive Engineer","RES","R"},
            {"Marine Services Manager","RCE","R"},
            {"Biochemist","IRS","R"},
            {"Anthropologist","IRE","R"},
            {"Park Superintendent","ERA","R"},
            {"Surgeon","IRA","I"},
            {"Aeronautical Engineer","IRS","I"},
            {"Meteorologist","IRS","I"},
            {"Astronomer","IRE","I"},
            {"Civil Engineer","IRE","I"},
            {"Computer Programmer","IRC","I"},
            {"Biologist","IAR","I"},
            {"Dentist","ISR","I"},
            {"Physician Assistant","ISA","I"},
            {"Translator","ISC","I"},
            {"Systems Analyst","IER","I"},
            {"Pharmacist","IES","I"},
            {"Curator","IRS","I"},
            {"Neurologist","IRS","I"},
            {"Anthropologist","IRE","I"},
            {"Environmental Analyst","IRE","I"},
            {"Pilot","IRE","I"},
            {"Structural Drafter","IRC","I"},
            {"Art Appraiser","IAS","I"},
            {"Nurse Practitioner","ISA","I"},
            {"Actuary","ISE","I"},
            {"Chief Information Officer","IER","I"},
            {"Surveyor","IEA","I"},
            {"Cytotechnologist","ICR","I"},
            {"Costumer","ARI","A"},
            {"Floral Designer","ARE","A"},
            {"Architect","AIR","A"},
            {"Fashion Designer","ASR","A"},
            {"Composer","ASE","A"},
            {"Graphic Designer","AER","A"},
            {"Audiovisual Production","AES","A"},
            {"Choreographer","AES","A"},
            {"Wedding Consultant","AES","A"},
            {"Still Photographer","ARS","A"},
            {"Cake Decorator","ARE","A"},
            {"Writer","AIE","A"},
            {"Exhibit Artist","ASI","A"},
            {"Dancing Instructor","ASE","A"},
            {"Screen Writer","AEI","A"},
            {"Choral Director","AES","A"},
            {"News Editor","AES","A"},
            {"Photojournalist","AEC","A"},
            {"Custom Special Agent","SRI","S"},
            {"Recruiter","SRE","S"},
            {"Nurse/Midwife","SIR","S"},
            {"Dietitian","SIE","S"},
            {"Dental Hygienist","SAI","S"},
            {"Teacher","SAE","S"},
            {"Loan Officer","SER","S"},
            {"Television Director","SEA","S"},
            {"Appraiser","SCE","S"},
            {"Athletic Trainer","SRE","S"},
            {"Professional Athlete","SRC","S"},
            {"Psychologist","SIA","S"},
            {"Physical Therapist","SIE","S"},
            {"Career Counselor","SAE","S"},
            {"Police Officer","SER","S"},
            {"School Principal","SEI","S"},
            {"Paralegal","SEC","S"},
            {"Politician","ESA","S"},
            {"Special Agent","ERI","E"},
            {"Construction Superintendent","ERS","E"},
            {"Production Manager","ERC","E"},
            {"Industrial Engineer","EIR","E"},
            {"Environmental Project Manager","EIS","E"},
            {"Patent Agent","EIA","E"},
            {"Museum or Zoo Director","ESR","E"},
            {"Human Resource Advisor","ESR","E"},
            {"President (any industry)","ESR","E"},
            {"Tax Attorney","ESI","E"},
            {"Politician","ESA","E"},
            {"Financial Planner","ESC","E"},
            {"Park Superintendent","ERA","E"},
            {"Intelligence Specialist","ERS","E"},
            {"Business Enterprise Officer","EIR","E"},
            {"Communications Consultant","EIA","E"},
            {"Foreign-Exchange Trader","EIC","E"},
            {"Fashion Coordinator","EAS","E"},
            {"Claim Adjuster","ESR","E"},
            {"Media Marketing Director","ESR","E"},
            {"Real Estate Agent","ESR","E"},
            {"Urban Planner","ESI","E"},
            {"E-Commerce Manager","ESA","E"},
            {"Social Director","ESC","E"},
            {"Desktop Publisher","CRA","C"},
            {"Mail Carrier","CRS","C"},
            {"Underwriter","CSE","C"},
            {"Child Development Specialist","SEC","C"},
            {"Financial Planner","ESC","C"},
            {"Golf Club Manager","ECS","C"},
            {"Credit Analyst","CRS","C"},
            {"Website Editor","CIA","C"},
            {"Computer Programmer","IRC","C"},
            {"Telecommunications Specialist","ECS","C"},
            {"Safety Manager","SEC","C"},
            {"Travel Agent","ECS","C"},
    };
    String saran_utama = "";
    String saran_lainnya = "";
    TextView tvJurusan, tvJurusanLain, tvAlasan;
    String hasil = "";
    String terbesar = "";
    String nama_hasil = "";
    ImageButton btnDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);
        getSupportActionBar().hide();
        tvJurusan = findViewById(R.id.tvJurusan);
        tvJurusanLain = findViewById(R.id.tvJurusanLain);
        tvAlasan = findViewById(R.id.tvAlasan);
        btnDownload = findViewById(R.id.btnDownload);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            terbesar = extras.getString("terbesar");
            hasil = extras.getString("hasil");
            for(int i=0;i<saran.length;i++){
                //Saran Utama
                if(saran[i][1].equals(hasil)){
                    if(saran_utama.equals("")){
                        saran_utama = saran[i][0];
                    }else{
                        saran_utama = saran_utama + ", " + saran[i][0];
                    }
                }
                //Saran Lainnnya
                if(saran[i][2].equals(terbesar)){
                    if(saran_lainnya.equals("")){
                        saran_lainnya = saran[i][0];
                    }else{
                        saran_lainnya = saran_lainnya + ", " + saran[i][0];
                    }

                }
            }
            tvJurusan.setText(saran_utama);
            tvJurusanLain.setText(saran_lainnya);
            switch (terbesar){
                case "R" :
                    nama_hasil = "REALISTIC";
                    break;
                case "I" :
                    nama_hasil = "INVESTIGATIVE";
                    break;
                case "A" :
                    nama_hasil = "ARTISTIC";
                    break;
                case "S" :
                    nama_hasil = "SOCIAL";
                    break;
                case "E" :
                    nama_hasil = "ENTERPRISING";
                    break;
                case "C" :
                    nama_hasil = "CONVENTIONAL";
                    break;
            }

            tvAlasan.setText("Karena kamu cukup berminat pada tipe kepribadian karier "+nama_hasil+", kamu bisa mempertimbangkan kuliah di jurusan ini :");
        }

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureScreen();
            }
        });

    }

    private void captureScreen() {
        View v = getWindow().getDecorView().getRootView();
        v.setDrawingCacheEnabled(true);
        Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false);
        try {
            FileOutputStream fos = new FileOutputStream(new File(Environment
                    .getExternalStorageDirectory().toString(), "SCREEN"
                    + System.currentTimeMillis() + ".png"));
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(getApplicationContext(),"Download screenshot success, please check your gallery",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SaranActivity.this,WelcomeActivity.class));
        finish();
    }
}
