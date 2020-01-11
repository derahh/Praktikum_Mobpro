package org.d3ifcool.bmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DefaultActivity extends AppCompatActivity {

    private int beratBadan;
    private double hasiHitung = 0, tinggiBadan;
    private String jenisKelamin;
    private EditText edtBeratBadan, edtTinggiBadan;
    private RadioButton rdPria, rdWanita;
    private Button btnHitung, btnLihatSaran, btnBagikan;
    private TextView nilaiBMI, kategoriIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
    }

    public void hitung(View view){
        edtBeratBadan = findViewById(R.id.beraBadan);
        edtTinggiBadan = findViewById(R.id.tinggiBadan);
        nilaiBMI = findViewById(R.id.nilaiBMI);
        kategoriIdeal = findViewById(R.id.kategoriIdeal);
        rdPria = findViewById(R.id.rdPria);
        rdWanita = findViewById(R.id.rdWanita);
        btnLihatSaran = findViewById(R.id.btnLihatSaran);
        btnBagikan = findViewById(R.id.btnBagikan);

        nilaiBMI.setVisibility(View.VISIBLE);
        kategoriIdeal.setVisibility(View.VISIBLE);
        btnLihatSaran.setVisibility(View.VISIBLE);
        btnBagikan.setVisibility(View.VISIBLE);

        if (TextUtils.isEmpty(edtBeratBadan.getText().toString())){
            Toast.makeText(this, "Masukkan Berat Badan", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(edtTinggiBadan.getText().toString())){
            Toast.makeText(this, "Masukkan Tinggi Badan", Toast.LENGTH_SHORT).show();
        }

        beratBadan = Integer.parseInt(edtBeratBadan.getText().toString());
        tinggiBadan = Integer.parseInt(edtTinggiBadan.getText().toString());
        double tinggiBadanMeter = tinggiBadan / 100;
        hasiHitung = (int) beratBadan / (tinggiBadanMeter*tinggiBadanMeter);
        nilaiBMI.setText(hasiHitung+"");

        if (rdPria.isChecked()){
            if (hasiHitung < 20.5){
                kategoriIdeal.setText("KURUS");
            }else if(hasiHitung >= 20.5 && hasiHitung <= 26.99){
                kategoriIdeal.setText("IDEAL");
            }else {
                kategoriIdeal.setText("GEMUK");
            }
            jenisKelamin = "Pria";
        }else if (rdWanita.isChecked()){
            if (hasiHitung < 18.5){
                kategoriIdeal.setText("KURUS");
            }else if(hasiHitung >= 18.5 && hasiHitung <= 24.99){
                kategoriIdeal.setText("IDEAL");
            }else {
                kategoriIdeal.setText("GEMUK");
            }
            jenisKelamin = "Wanita";
        }
//
//        if (kategoriIdeal.getText().toString().equalsIgnoreCase("KURUS")){
//            kategoriIdeal.setTextColor(R.color.kategori_kurus);
//        }else if(kategoriIdeal.getText().toString().equalsIgnoreCase("IDEAL")){
//            kategoriIdeal.setTextColor(R.color.kategori_ideal);
//        }else {
//            kategoriIdeal.setTextColor(R.color.kategori_gemuk);
//        }
    }

    public void bagikan(View view){
        String subject = "Berat Saya "+ kategoriIdeal.getText();
        String message = "Berat Badan : " + beratBadan + " kg\n" +
                "Tinggi Badan : " + tinggiBadan + " cm\n" +
                "Jenis Kelamin : " + jenisKelamin + "\n" +
                "nilai BMI : " + hasiHitung + "\n" +
                "kategori : " + kategoriIdeal.getText();

        composeEmail(new String[] {"mobpro.d3if@gmail.com"}, subject, message);
    }

    public void listSaran(View view){

    }

    public void composeEmail(String[] addresses, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("from:derahh@student.telkomuniversity.ac.id"));
//        intent.putExtra(Intent.EXTRA_EMAIL, "derahh@student.telkomuniversity.ac.id");
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
