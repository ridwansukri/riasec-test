package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import emcorp.studio.riasec.Library.ButtonClick;

public class PertanyaanActivity extends AppCompatActivity {
    ImageButton btnSelanjutnya;
    TextView tvPertanyaan1, tvPertanyaan2, tvPertanyaan3, tvPertanyaan4, tvPertanyaan5, tvPertanyaan6;
    RadioButton radYa1, radTidak1, radYa2, radTidak2, radYa3, radTidak3, radYa4, radTidak4, radYa5, radTidak5, radYa6, radTidak6;
    String[][] butir_tes = {
        //No Urut Soal, Kategori Soal, Soal, Jawaban
        {"1","R","Saya suka mengutak-atik motor atau mobil",""},
        {"2","R","Saya suka menciptakan sesuatu hal",""},
        {"3","R","Saya suka merawat hewan",""},
        {"4","R","Saya suka membangun dan membongkar sesuatu",""},
        {"5","R","Saya suka memasak",""},
        {"6","R","Saya lebih suka praktek daripada teori",""},
        {"7","R","Saya suka bekerja di lapangan",""},
        {"8","R","Saya suka mengerjakan barang elektronik",""},
        {"9","R","Saya suka berburu atau memancing",""},
        {"10","R","Saya suka melihat permainan sepakbola",""},
        {"1","I","Saya suka sesuatu yang berbau teka-teki",""},
        {"2","I","Saya suka melakukan eksperimen/percobaan",""},
        {"3","I","Saya senang belajar Fisika dan biologi",""},
        {"4","I","Saya suka mencari tahu bagaimana sesuatu dapat bekerja",""},
        {"5","I","Saya suka menganalisa situasi dan masalah",""},
        {"6","I","Saya suka mengerjakan tugas dengan angka dan diagram",""},
        {"7","I","Matematika saya bagus",""},
        {"8","I","Saya suka bekerja sendirian",""},
        {"9","I","Saya suka praktek di laboratorium",""},
        {"10","I","Saya merasa tertantang dalam memecahkan suatu masalah",""},
        {"1","A","Saya suka seni dan musik",""},
        {"2","A","Saya suka menulis",""},
        {"3","A","Saya orang yang kreatif",""},
        {"4","A","Saya suka menyanyi atau memainkan alat music",""},
        {"5","A","Saya suka bermain peran dalam drama",""},
        {"6","A","Saya suka menggambar",""},
        {"7","A","Saya suka fotografi (mengambil gambar)",""},
        {"8","A","Saya suka berbicata menggunakan Bahasa asing",""},
        {"9","A","Saya suka membuat kerajinan tangan",""},
        {"10","A","Saya suka menghadiri konser, teater atau pameran seni",""},
        {"1","S","Saya suka bekerja sama dengan orang lain",""},
        {"2","S","Saya suka mengajar atau melatih orang lain",""},
        {"3","S","Saya suka membantu teman menyelesaikan masalahnya",""},
        {"4","S","Saya tertarik dalam penyembuhan orang lain",""},
        {"5","S","Saya tertarik mempelajari budaya lain",""},
        {"6","S","Saya suka berdiskusi terhadap suatu masalah",""},
        {"7","S","Saya tertarik menjadi relawan",""},
        {"8","S","Saya suka hadir dalam suatu rapat",""},
        {"9","S","Saya ingin menjadi guru",""},
        {"10","S","Saya suka mengutarakan pendapat",""},
        {"1","E","Saya orangnya ambisius dan punya tujuan sendiri",""},
        {"2","E","Saya suka membujuk atau mempengaruhi orang lain",""},
        {"3","E","Saya suka berjualan atau berdagang",""},
        {"4","E","Saya ingin memulai bisnis sendiri",""},
        {"5","E","Saya tertarik memimpin suatu organisasi",""},
        {"6","E","Saya suka berpidato",""},
        {"7","E","Saya ingin menjadi penjabat publik",""},
        {"8","E","Saya suka mendapat penghargaan dan pengakuan",""},
        {"9","E","Saya tertarik memimpin suatu rapat",""},
        {"10","E","Saya suka dunia politik",""},
        {"1","C","Saya suka mengumpulkan dan merapikan sesuatu",""},
        {"2","C","Saya suka mengikuti petunjuk yang diberikan",""},
        {"3","C","Saya suka memperhatikan hal-hal yang kecil/detail",""},
        {"4","C","Saya suka mencatat penjelasan dari guru",""},
        {"5","C","Saya suka menyimpan dan merapikan catatan",""},
        {"6","C","Saya ingin bekerja di kantor",""},
        {"7","C","Saya suka bermain kartu dan komputer",""},
        {"8","C","Saya suka bekerja dengan data",""},
        {"9","C","Jika ada PR, saya segera mengerjakannya",""},
        {"10","C","Saya suka merangkum pelajaran",""},
    };
    int soalKe = 1;
    ArrayList<String> listSoal = new ArrayList<String>();
    ArrayList<String> listNomorUrut = new ArrayList<String>();
    String[] listJawaban = new String[6];
    RadioGroup radGroup1,radGroup2,radGroup3,radGroup4,radGroup5,radGroup6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);
        getSupportActionBar().hide();

        btnSelanjutnya = findViewById(R.id.btnSelanjutnya);
        tvPertanyaan1 = findViewById(R.id.tvPertanyaan1);
        radYa1 = findViewById(R.id.radYa1);
        radTidak1 = findViewById(R.id.radTidak1);
        tvPertanyaan2 = findViewById(R.id.tvPertanyaan2);
        radYa2 = findViewById(R.id.radYa2);
        radTidak2 = findViewById(R.id.radTidak2);
        tvPertanyaan3 = findViewById(R.id.tvPertanyaan3);
        radYa3 = findViewById(R.id.radYa3);
        radTidak3 = findViewById(R.id.radTidak3);
        tvPertanyaan4 = findViewById(R.id.tvPertanyaan4);
        radYa4 = findViewById(R.id.radYa4);
        radTidak4 = findViewById(R.id.radTidak4);
        tvPertanyaan5 = findViewById(R.id.tvPertanyaan5);
        radYa5 = findViewById(R.id.radYa5);
        radTidak5 = findViewById(R.id.radTidak5);
        tvPertanyaan6 = findViewById(R.id.tvPertanyaan6);
        radYa6 = findViewById(R.id.radYa6);
        radTidak6 = findViewById(R.id.radTidak6);
        radGroup1 = findViewById(R.id.radGroup1);
        radGroup2 = findViewById(R.id.radGroup2);
        radGroup3 = findViewById(R.id.radGroup3);
        radGroup4 = findViewById(R.id.radGroup4);
        radGroup5 = findViewById(R.id.radGroup5);
        radGroup6 = findViewById(R.id.radGroup6);

        btnSelanjutnya.setOnTouchListener(new ButtonClick());

        tampilSoal(soalKe);

        radYa1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[0] = "Y";
                }
            }
        });
        radYa2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[1] = "Y";
                }
            }
        });
        radYa3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[2] = "Y";
                }
            }
        });
        radYa4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[3] = "Y";
                }
            }
        });
        radYa5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[4] = "Y";
                }
            }
        });
        radYa6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[5] = "Y";
                }
            }
        });
        radTidak1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[0] = "T";
                }
            }
        });
        radTidak2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[1] = "T";
                }
            }
        });
        radTidak3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[2] = "T";
                }
            }
        });
        radTidak4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[3] = "T";
                }
            }
        });
        radTidak5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[4] = "T";
                }
            }
        });
        radTidak6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listJawaban[5] = "T";
                }
            }
        });

        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cek apakah semua sudah diisi?
                boolean complete = true;
                for(int i=0;i<6;i++){
                    if(listJawaban[i].equals("")){
                        complete = false;
                        break;
                    }
                }
                if(complete){
                    //Complete, lanjut memasukkan jawaban ke dalam kolom yang sesuai
                    for(int i=0;i<listNomorUrut.size();i++){
                        butir_tes[Integer.valueOf(listNomorUrut.get(i))][3] = listJawaban[i];
                    }
                    if(soalKe<10){
                        soalKe = soalKe + 1;
                        tampilSoal(soalKe);
                    }else{
                        //Calculation
                        int score_r = 0;
                        int score_a = 0;
                        int score_i = 0;
                        int score_s = 0;
                        int score_e = 0;
                        int score_c = 0;
                        for(int i=0;i<butir_tes.length;i++){
                            Log.d("JAWABAN",butir_tes[i][2] +" <> "+butir_tes[i][3]);
                            if(butir_tes[i][1]=="R"&&butir_tes[i][3]=="Y"){
                                score_r = score_r + 1;
                            }
                            if(butir_tes[i][1]=="A"&&butir_tes[i][3]=="Y"){
                                score_a = score_a + 1;
                            }
                            if(butir_tes[i][1]=="I"&&butir_tes[i][3]=="Y"){
                                score_i = score_i + 1;
                            }
                            if(butir_tes[i][1]=="S"&&butir_tes[i][3]=="Y"){
                                score_s = score_s + 1;
                            }
                            if(butir_tes[i][1]=="E"&&butir_tes[i][3]=="Y"){
                                score_e = score_e + 1;
                            }
                            if(butir_tes[i][1]=="C"&&butir_tes[i][3]=="Y"){
                                score_c = score_c + 1;
                            }
                        }
                        Toast.makeText(getApplicationContext(),"FINISH",Toast.LENGTH_SHORT).show();
                        Log.d("JAWABAN","R:"+String.valueOf(score_r));
                        Log.d("JAWABAN","A:"+String.valueOf(score_a));
                        Log.d("JAWABAN","I:"+String.valueOf(score_i));
                        Log.d("JAWABAN","S:"+String.valueOf(score_s));
                        Log.d("JAWABAN","E:"+String.valueOf(score_e));
                        Log.d("JAWABAN","C:"+String.valueOf(score_c));
                        Intent intent = new Intent(PertanyaanActivity.this,HasilActivity.class);
                        intent.putExtra("R",score_r);
                        intent.putExtra("A",score_a);
                        intent.putExtra("I",score_i);
                        intent.putExtra("S",score_s);
                        intent.putExtra("E",score_e);
                        intent.putExtra("C",score_c);
                        startActivity(intent);
                        finish();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Semua pertanyaaan harus dijawab!",Toast.LENGTH_SHORT).show();
                }

//                Intent intent = new Intent(PertanyaanActivity.this,HasilActivity.class);
//                intent.putExtra("R",8);
//                intent.putExtra("I",7);
//                intent.putExtra("A",10);
//                intent.putExtra("S",0);
//                intent.putExtra("E",7);
//                intent.putExtra("C",7);
//                startActivity(intent);
//                finish();


            }

        });

    }

    public void tampilSoal(int ke){
        radGroup1.clearCheck();
        radGroup2.clearCheck();
        radGroup3.clearCheck();
        radGroup4.clearCheck();
        radGroup5.clearCheck();
        radGroup6.clearCheck();

        listNomorUrut.clear();
        listSoal.clear();
        listJawaban = new String[6];
        for(int i=0;i<listJawaban.length;i++){
            listJawaban[i] = "";
        }
        for(int i=0;i<butir_tes.length;i++){
            if(butir_tes[i][0].equals(String.valueOf(ke))){
                listSoal.add(butir_tes[i][2]);
                listNomorUrut.add(String.valueOf(i));
            }
        }
        for(int i=0;i<listSoal.size();i++){
            Log.d("CETAK",listSoal.get(i));
        }

        tvPertanyaan1.setText(listSoal.get(0));
        tvPertanyaan2.setText(listSoal.get(1));
        tvPertanyaan3.setText(listSoal.get(2));
        tvPertanyaan4.setText(listSoal.get(3));
        tvPertanyaan5.setText(listSoal.get(4));
        tvPertanyaan6.setText(listSoal.get(5));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PertanyaanActivity.this,AccountActivity.class));
        finish();
    }
}
