package com.example.android.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.sqlite.bancodedados.BancoDeDados;

import java.io.InputStream;

public class CriarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anotacao);
    }

    public void voltar (View v) {
        Intent startNewActivity = new Intent(this, TelaInicial.class);
        startActivity(startNewActivity);
    }

    public void criarAnotacao (View v){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo =(EditText) findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        boolean resultado = bancoDeDados.criarAnotacao(titulo.getText().toString(),conteudo.getText().toString());

        if(resultado) {
            Toast.makeText(getApplicationContext(),"Anotação criada com sucesso", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"ERRO: Anotação não criada!!!", Toast.LENGTH_LONG).show();
        }

        voltar(v);
    }

}
