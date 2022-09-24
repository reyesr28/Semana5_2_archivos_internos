package com.example.semana5_2_archivos_internos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText txtTexto;
    Button btnGrabar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto=findViewById(R.id.txtTexto);
        btnGrabar=findViewById(R.id.btnGrabar);

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=txtTexto.getText().toString();

                try{
                    OutputStreamWriter fout=new OutputStreamWriter(
                            openFileOutput("archivo.txt",
                                    Context.MODE_APPEND));
                    fout.write(str+"\n");
                    fout.close();
                    txtTexto.setText(null);
                    txtTexto.requestFocus();
                }catch(Exception e){}
            }
        });

    }
}