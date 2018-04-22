package com.example.hilmylazuardi.studykasus;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;

public class Kost extends AppCompatActivity {
    private ImageSwitcher imgSwitcher;
    private TextSwitcher textSwitcher;
    private Button btnGold, btnSilver, btnBronze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kost);

        imgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);
        imgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        imgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setInAnimation(this,android.R.anim.fade_in);
        textSwitcher.setInAnimation(this,android.R.anim.fade_out);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(Kost.this);
                textView.setTextSize(18);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        btnGold = (Button) findViewById(R.id.btnGold);
        btnSilver = (Button) findViewById(R.id.btnSilver);
        btnBronze = (Button) findViewById(R.id.btnBronze);

        imgSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT
                ));
                return myView;
            }
        });
        btnGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "View Kost Gold", Toast.LENGTH_LONG).show();
                imgSwitcher.setImageResource(R.mipmap.k);
                textSwitcher.setCurrentText("Alamat Kost: Jl. Bendi IV No. 12 Tanah Kusir Jakarta Selatan 12240\n" +
                        "    No. Telepon: 021-7397171; 021-7293644; 0818772983\n" +
                        "    Harga Sewa: Rp 1.450.000 per bulan;\n" +
                        "    Tempat Kost Untuk: Pria\n" +
                        "    Mayoritas Penghuni: Mahasiswa/i\n" +
                        "    Ukuran Kamar: Type A: 3,5 x 4 m; Type B: 3 x 4 m; Type C: 3 x 4 m\n" +
                        "    Sekamar Boleh Berdua: Ya\n" +
                        "    Biaya Tambahan Sekamar Berdua: Ada, negotiable.\n" +
                        "    Fasilitas: Type A: 1 tempat tidur single, 1 lemari pakaian, 1 meja rias, 1 AC, kamar mandi di dalam, garasi untuk 1 mobil, laundry (Rp 100.000 per bulan per orang);\n" +
                        "    Fasilitas Umum: Alat Listrik Ringan – Pantry – Ruang Makan – Ruang Duduk – Tempat Jemuran.\n" +
                        "    Fasilitas Sekitar: Dekat Jalan Raya – Akses Ke Tol Jorr – Angkutan Umum – Pusat Perbelanjaan (Gandaria City, Pondok Indah Mall, Carrefour Lebak Bulus) –\n" +
                        "        Tempat Ibadah : Masjid – Lapangan Basket – Minimarket – Apotik – Klinik 24 Jam.\n" +
                        "    Parkir Mobil: Ada, terbatas.\n" +
                        "    Parkir Motor: Ada\n" +
                        "    Waktu Bertamu: Jam 07:00 - 21:00\n" +
                        "    Akses Lokasi: Mudah\n" +
                        "    Info Tambahan: Bangunan Kost Baru, Bersih, Nyaman dan Aman.\n" +
                        "    E-mail: miruna1310@yahoo.com");
            }
        });

        btnSilver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "View Kost Silver", Toast.LENGTH_LONG).show();
                imgSwitcher.setImageResource(R.mipmap.s);
                textSwitcher.setText("Alamat Kost: Jl. Bendi IV No. 12 Tanah Kusir Jakarta Selatan 12240\n" +
                        "    No. Telepon: 021-7397171; 021-7293644; 0818772983\n" +
                        "    Harga Sewa: Rp 1.100.000 per bulan;\n" +
                        "    Tempat Kost Untuk: Pria\n" +
                        "    Mayoritas Penghuni: Mahasiswa/i\n" +
                        "    Ukuran Kamar: Type A: 3,5 x 4 m; Type B: 3 x 4 m; Type C: 3 x 4 m\n" +
                        "    Sekamar Boleh Berdua: Ya\n" +
                        "    Biaya Tambahan Sekamar Berdua: Ada, negotiable.\n" +
                        "    Fasilitas: Type B: 1 tempat tidur single, 1 lemari pakaian, 1 meja rias, 1 AC, kamar mandi di luar untuk 2 orang, parkir untuk motor, laundry (Rp 100.000 per bulan per orang);\n" +
                        "    Fasilitas Umum: Alat Listrik Ringan – Pantry – Ruang Makan – Ruang Duduk – Tempat Jemuran.\n" +
                        "    Fasilitas Sekitar: Dekat Jalan Raya – Akses Ke Tol Jorr – Angkutan Umum – Pusat Perbelanjaan (Gandaria City, Pondok Indah Mall, Carrefour Lebak Bulus) – Tempat Ibadah : Masjid – Lapangan Basket – Minimarket – Apotik – Klinik 24 Jam.\n" +
                        "    Parkir Mobil: Ada, terbatas.\n" +
                        "    Parkir Motor: Ada\n" +
                        "    Waktu Bertamu: Jam 07:00 - 21:00\n" +
                        "    Akses Lokasi: Mudah\n" +
                        "    Info Tambahan: Bangunan Kost Baru, Bersih, Nyaman dan Aman.\n" +
                        "    E-mail: miruna1310@yahoo.com");
            }
        });

        btnBronze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "View Kost Bronze", Toast.LENGTH_LONG).show();
                imgSwitcher.setImageResource(R.mipmap.o);
                textSwitcher.setText("Alamat Kost: Jl. Bendi IV No. 12 Tanah Kusir Jakarta Selatan 12240\n" +
                        "    No. Telepon: 021-7397171; 021-7293644; 0818772983\n" +
                        "    Harga Sewa: Rp. 700.000 per bulan\n" +
                        "    Tempat Kost Untuk: Pria\n" +
                        "    Mayoritas Penghuni: Mahasiswa/i\n" +
                        "    Ukuran Kamar: Type A: 3,5 x 4 m; Type B: 3 x 4 m; Type C: 3 x 4 m\n" +
                        "    Sekamar Boleh Berdua: Ya\n" +
                        "    Biaya Tambahan Sekamar Berdua: Ada, negotiable.\n" +
                        "    Fasilitas: Type C: 1 tempat tidur single, 1 lemari pakaian, 1 meja rias, kamar mandi di luar untuk 2 orang, parkir untuk motor, laundry (Rp 100.000 per bulan per orang).\n" +
                        "    Fasilitas Umum: Alat Listrik Ringan – Pantry – Ruang Makan – Ruang Duduk – Tempat Jemuran.\n" +
                        "    Fasilitas Sekitar: Dekat Jalan Raya – Akses Ke Tol Jorr – Angkutan Umum – Pusat Perbelanjaan (Gandaria City, Pondok Indah Mall, Carrefour Lebak Bulus) – Tempat Ibadah : Masjid – Lapangan Basket – Minimarket – Apotik – Klinik 24 Jam.\n" +
                        "    Parkir Mobil: Ada, terbatas.\n" +
                        "    Parkir Motor: Ada\n" +
                        "    Waktu Bertamu: Jam 07:00 - 21:00\n" +
                        "    Akses Lokasi: Mudah\n" +
                        "    Info Tambahan: Bangunan Kost Baru, Bersih, Nyaman dan Aman.\n" +
                        "    E-mail: miruna1310@yahoo.com");
            }
        });
    }
}
