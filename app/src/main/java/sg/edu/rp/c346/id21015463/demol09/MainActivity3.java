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

        tvID = findViewById(R.id.tv3ID);
        tvFixID = findViewById(R.id.tv3IDnum);
        tvTitle = findViewById(R.id.tv3Title);
        etTitle = findViewById(R.id.et3Title);
        tvSingers = findViewById(R.id.tv3Singers);
        etSingers = findViewById(R.id.et3Singers);
        tvYear = findViewById(R.id.tv3Year);
        etYear = findViewById(R.id.et3Year);
        tvRating = findViewById(R.id.tv3Rating);
        rgRating = findViewById(R.id.rg3Rating);
        btnUpdate = findViewById(R.id.btn3Update);
        btnDelete = findViewById(R.id.btn3Delete);
        btnCancel = findViewById(R.id.btn3Cancel);

        Intent x = getIntent();
        data = (Song) x.getSerializableExtra("id");

        tvFixID.setText(data.getId());
        etTitle.setText(data.getSongTitle());
        etSingers.setText(data.getSongSinger());
        etYear.setText(data.getSongYear());
    }
}