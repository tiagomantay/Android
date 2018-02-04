package com.teste.agileprocess.testlistview;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaração da ListView
        ListView lista = (ListView) findViewById(R.id.list);

        final ArrayList<String> Lista_aL = new ArrayList<String>();


        //Método importa lista do arquivo txt
        importar(Lista_aL);

        //Adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                Lista_aL);

        lista.setAdapter(adapter);

        //método que gera o toast na tela
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), "Posição: " + (i + 1) + "  Motivo:  " +
                        Lista_aL.get(i).toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void importar(ArrayList<String> Lista_aL) {

        AssetManager assetManager = getResources().getAssets();
        InputStream inputStream;

        String temp_string = null;

        try {
            inputStream = assetManager.open("arquivoLista.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            Toast.makeText(getApplicationContext(), "Arquivo importado com sucesso",
                    Toast.LENGTH_SHORT).show();
            while ((temp_string = bufferedReader.readLine()) != null) {
                Lista_aL.add(temp_string);
            }

            inputStream.close();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Erro na importação do arquivo",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
