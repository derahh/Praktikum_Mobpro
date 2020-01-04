package id.co.derah.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int jumlahScoreA, jumlahScoreB;
    private TextView scoreA, scoreB;
    private Button tigaPointA, duaPointA, freeThrowA, tigaPointB, duaPointB, freeThrowB, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumlahScoreA = jumlahScoreB = 0;
        scoreA = findViewById(R.id.textScoreA);
        scoreB = findViewById(R.id.textScoreB);
        tigaPointA = findViewById(R.id.buttonTigaPointA);
        tigaPointA.setOnClickListener(klik);
        duaPointA = findViewById(R.id.buttonDuaPointA);
        duaPointA.setOnClickListener(klik);
        freeThrowA = findViewById(R.id.buttonFreeThrowA);
        freeThrowA.setOnClickListener(klik);
        tigaPointB = findViewById(R.id.buttonTigaPointB);
        tigaPointB.setOnClickListener(klik);
        duaPointB = findViewById(R.id.buttonDuaPointB);
        duaPointB.setOnClickListener(klik);
        freeThrowB = findViewById(R.id.buttonFreeThrowB);
        freeThrowB.setOnClickListener(klik);
        reset = findViewById(R.id.buttonReset);
        reset.setOnClickListener(klik);
    }

    private View.OnClickListener klik = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.buttonTigaPointA:
                    jumlahScoreA += 3;
                    scoreA.setText(jumlahScoreA+"");
                    break;
                case R.id.buttonDuaPointA:
                    jumlahScoreA += 2;
                    scoreA.setText(jumlahScoreA+"");
                    break;
                case R.id.buttonFreeThrowA:
                    jumlahScoreA += 1;
                    scoreA.setText(jumlahScoreA+"");
                    break;
                case R.id.buttonTigaPointB:
                    jumlahScoreB += 3;
                    scoreB.setText(jumlahScoreB+"");
                    break;
                case R.id.buttonDuaPointB:
                    jumlahScoreB += 2;
                    scoreB.setText(jumlahScoreB+"");
                    break;
                case R.id.buttonFreeThrowB:
                    jumlahScoreB += 1;
                    scoreB.setText(jumlahScoreB+"");
                    break;
                case R.id.buttonReset:
                    jumlahScoreA = jumlahScoreB = 0;
                    scoreA.setText(jumlahScoreA+"");
                    scoreB.setText(jumlahScoreB+"");
            }
        }
    };
}
