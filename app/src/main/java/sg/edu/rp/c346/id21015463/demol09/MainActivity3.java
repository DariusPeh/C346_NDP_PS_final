package sg.edu.rp.c346.id21015463.demol09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    TextView tvID;
    TextView tvFixID;
    TextView tvTitle;
    EditText etTitle;
    TextView tvSingers;
    EditText etSingers;
    TextView tvYear;
    EditText etYear;
    TextView tvRating;
    RadioGroup rgRating;
    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;
    Song data;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvID = findViewById(R.id.tvID);
        tvFixID = findViewById(R.id.tvIDnum);
        tvTitle = findViewById(R.id.tvTitle);
        etTitle = findViewById(R.id.etTitle);
        tvSingers = findViewById(R.id.tvSingers);
        etSingers = findViewById(R.id.etSingers);
        tvYear = findViewById(R.id.tvYear);
        etYear = findViewById(R.id.etYear);
        tvRating = findViewById(R.id.tvRating);
        rgRating = findViewById(R.id.rgRating);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent x = getIntent();
        data = (Song) x.getSerializableExtra("id");

        tvFixID.setText(data.getId());
        etTitle.setText(data.getSongTitle());
        etSingers.setText(data.getSongSinger());
        etYear.setText(data.getSongYear());
    }
}