package sg.edu.rp.c346.id21015463.demol09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView tvTitle;
    EditText etTitle;
    TextView tvSingers;
    EditText etSingers;
    TextView tvRating;
    TextView tvYear;
    EditText etYear;
    RadioGroup rgRating;

    Button btnInsert;
    Button btnShowList;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        etTitle = findViewById(R.id.et3Title);
        tvSingers = findViewById(R.id.tvSingers);
        etSingers = findViewById(R.id.etSingers);
        tvYear = findViewById(R.id.tvYear);
        etYear = findViewById(R.id.etYear);
        tvRating = findViewById(R.id.tvRating);
        rgRating = findViewById(R.id.rgRating);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_2, al);
        lv.setAdapter(aa);

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                Intent x = new Intent(MainActivity.this,
                        MainActivity2.class);
                al.addAll(dbh.getAllSongs());
                startActivity(x);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                DBHelper dbh = new DBHelper(MainActivity.this);
                if (rgRating.getCheckedRadioButtonId() == R.id.radio1) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("*"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgRating.getCheckedRadioButtonId() == R.id.radio2) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("**"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgRating.getCheckedRadioButtonId() == R.id.radio3) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("***"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgRating.getCheckedRadioButtonId() == R.id.radio4) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("****"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgRating.getCheckedRadioButtonId() == R.id.radio5) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("*****"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    };
}