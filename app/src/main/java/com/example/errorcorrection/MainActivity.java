package com.example.errorcorrection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.os.Build.ID;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText type, id;
    TextView display;
    Button add, update,  delete;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageViewID);
        id = findViewById(R.id.ID);
        type = findViewById(R.id.type_ID);
        display = findViewById(R.id.display_ID);
        add = findViewById(R.id.addbtn);
        update = findViewById(R.id.updatebtn);
        delete = findViewById(R.id.deleteID);


        databaseHelper = new DatabaseHelper(this);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(Integer.parseInt(ID), type.getText().toString(), display.getText().toString());
                databaseHelper.ADDDATA(word);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(Integer.parseInt(ID), type.getText().toString(), display.getText().toString());
                databaseHelper.UPDATEDATE(word);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(Integer.parseInt(ID), type.getText().toString(), display.getText().toString());
                databaseHelper.Delete(word);
            }
        });
    }
}
