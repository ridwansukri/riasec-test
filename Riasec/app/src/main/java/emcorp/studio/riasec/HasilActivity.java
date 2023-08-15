package emcorp.studio.riasec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HasilActivity extends AppCompatActivity {
    ImageView img1, img2, img3;
    int score_r = 0;
    int score_a = 0;
    int score_i = 0;
    int score_s = 0;
    int score_e = 0;
    int score_c = 0;
    int[] big_3_score = new int[3];
    String[] big_3_text = new String[3];
    private BarChart chart;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet set;
    BarData data;
    ImageButton btnSelanjutnya,btnDownload;
    TextView tvScoreR, tvScoreI, tvScoreA, tvScoreS, tvScoreE, tvScoreC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        getSupportActionBar().hide();

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        chart = findViewById(R.id.chart);
        tvScoreR = findViewById(R.id.tvScoreR);
        tvScoreI = findViewById(R.id.tvScoreI);
        tvScoreA = findViewById(R.id.tvScoreA);
        tvScoreS = findViewById(R.id.tvScoreS);
        tvScoreE = findViewById(R.id.tvScoreE);
        tvScoreC = findViewById(R.id.tvScoreC);
        btnSelanjutnya = findViewById(R.id.btnSelanjutnya);
        btnDownload = findViewById(R.id.btnDownload);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            score_r = extras.getInt("R");
            score_i = extras.getInt("I");
            score_a = extras.getInt("A");
            score_s = extras.getInt("S");
            score_e = extras.getInt("E");
            score_c = extras.getInt("C");

            int arr[] = {score_r, score_i, score_a, score_s, score_e, score_c};
            String kode[] = {"R", "I", "A", "S", "E", "C"};
            int n = arr.length;
            print3largest(kode, arr, n);

            BARENTRY = new ArrayList<>();
            BarEntryLabels = new ArrayList<String>();

//            BARENTRY.add(new BarEntry(score_r, 0));
//            BARENTRY.add(new BarEntry(score_i, 1));
//            BARENTRY.add(new BarEntry(score_a, 2));
//            BARENTRY.add(new BarEntry(score_s, 3));
//            BARENTRY.add(new BarEntry(score_e, 4));
//            BARENTRY.add(new BarEntry(score_c, 5));

            BARENTRY.add(new BarEntry(0, score_r));
            BARENTRY.add(new BarEntry(1, score_i));
            BARENTRY.add(new BarEntry(2, score_a));
            BARENTRY.add(new BarEntry(3, score_s));
            BARENTRY.add(new BarEntry(4, score_e));
            BARENTRY.add(new BarEntry(5, score_c));

            BarEntryLabels.add("R");
            BarEntryLabels.add("I");
            BarEntryLabels.add("A");
            BarEntryLabels.add("S");
            BarEntryLabels.add("E");
            BarEntryLabels.add("C");

            set = new BarDataSet(BARENTRY, "Result");
//            set.setDrawValues(false);


            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set);

            data = new BarData(dataSets);
//            set.setColors(ColorTemplate.COLORFUL_COLORS);
//            set.setColors(new int[] { R.color.colorR, R.color.colorI, R.color.colorA, R.color.colorS, R.color.colorE, R.color.colorC});
            set.setColors(
                    ContextCompat.getColor(chart.getContext(), R.color.colorR),
                    ContextCompat.getColor(chart.getContext(), R.color.colorI),
                    ContextCompat.getColor(chart.getContext(), R.color.colorA),
                    ContextCompat.getColor(chart.getContext(), R.color.colorS),
                    ContextCompat.getColor(chart.getContext(), R.color.colorE),
                    ContextCompat.getColor(chart.getContext(), R.color.colorC)
            );
            chart.setData(data);
            chart.getAxisLeft().setDrawLabels(false);
            chart.getAxisRight().setDrawLabels(false);
            chart.getXAxis().setDrawLabels(false);
            chart.getLegend().setEnabled(false);
            chart.getXAxis().setDrawGridLines(false);
            chart.getXAxis().setDrawAxisLine(false);
            chart.getXAxis().setDrawAxisLine(false);
            chart.getAxisLeft().setDrawGridLines(false);
            chart.getAxisLeft().setDrawAxisLine(false);
            chart.getAxisRight().setDrawGridLines(false);
            chart.getAxisRight().setDrawAxisLine(false);
            chart.getDescription().setEnabled(false);
            chart.setDrawGridBackground(false);
            chart.setDrawBorders(false);

            chart.animateY(300);

            int total = score_r + score_i + score_a + score_s + score_e + score_c;
            tvScoreR.setText(String.format("%.2f", (Double.valueOf(score_r)/Double.valueOf(total))*100)+" %");
            tvScoreI.setText(String.format("%.2f", (Double.valueOf(score_i)/Double.valueOf(total))*100)+" %");
            tvScoreA.setText(String.format("%.2f", (Double.valueOf(score_a)/Double.valueOf(total))*100)+" %");
            tvScoreS.setText(String.format("%.2f", (Double.valueOf(score_s)/Double.valueOf(total))*100)+" %");
            tvScoreE.setText(String.format("%.2f", (Double.valueOf(score_e)/Double.valueOf(total))*100)+" %");
            tvScoreC.setText(String.format("%.2f", (Double.valueOf(score_c)/Double.valueOf(total))*100)+" %");
        }

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureScreen();
            }
        });

        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilActivity.this,SaranActivity.class);
                intent.putExtra("terbesar",big_3_text[0]);
                intent.putExtra("hasil",big_3_text[0]+big_3_text[1]+big_3_text[2]);
                startActivity(intent);
                finish();
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

    private void print3largest(String kode[], int arr[], int arr_size)
    {
        int i, first = 0, second = 0, third = 0;

        int [] value = arr;
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int k=0;k<value.length;k++)
            map.put(k, value[k]);

        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(
                    Map.Entry<Integer, Integer> e1,
                    Map.Entry<Integer, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        int ke = 0;
        for(Map.Entry<Integer, Integer> lValue:list){
            if(ke<3){
                if(ke==0){
                    first = lValue.getValue();
                }else if(ke==1){
                    second = lValue.getValue();
                }else if(ke==2){
                    third = lValue.getValue();
                }
                big_3_score[ke] = lValue.getValue();
                big_3_text[ke] = kode[lValue.getKey()];
                System.out.println("CETAK value = "+lValue.getValue() +" , CETAK index = "+lValue.getKey());
                ke = ke+1;
            }
        }

        Log.d("CETAK","Three largest elements are " + first + " " + second + " " + third);
        Log.d("CETAK","Three largest elements are " + big_3_text[0] + " " + big_3_text[1]+ " " + big_3_text[2]);
        Log.d("CETAK","Three largest elements are " + big_3_score[0] + " " + big_3_score[1]+ " " + big_3_score[2]);

        //Menampilkan Gambar
        img1.setImageDrawable(getResources().getDrawable(findPicture(big_3_text[0])));
        img2.setImageDrawable(getResources().getDrawable(findPicture(big_3_text[1])));
        img3.setImageDrawable(getResources().getDrawable(findPicture(big_3_text[2])));

    }

    private int findPicture(String kode){
        int image = 0;
        switch (kode){
            case "R":
                image = R.drawable.ic_r;
                break;
            case "I":
                image = R.drawable.ic_i;
                break;
            case "A":
                image = R.drawable.ic_a;
                break;
            case "S":
                image = R.drawable.ic_s;
                break;
            case "E":
                image = R.drawable.ic_e;
                break;
            case "C":
                image = R.drawable.ic_c;
                break;
        }
        return image;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HasilActivity.this,WelcomeActivity.class));
        finish();
    }
}
