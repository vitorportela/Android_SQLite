package com.example.android.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.sqlite.bancodedados.BancoDeDados;

public class EditarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_anotacao);

        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        final Cursor cursor = bancoDeDados.consultarAnotacaoPeloId(this.getIntent().getIntExtra("id", 0));

        EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        conteudo.setText(cursor.getString(cursor.getColumnIndexOrThrow("conteudo")));
    }

    public void voltar (View v) {
        Intent startNewActivity = new Intent(this, TelaInicial.class);
        startActivity(startNewActivity);
    }

        public void atualizarAnotacao (View v){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo =(EditText) findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudo);
       try{
           bancoDeDados.atualizaAnotacao(this.getIntent().getIntExtra("id",0),titulo.getText().toString(), conteudo.getText().toString());
           Toast.makeText(getApplicationContext(),"Anotação atualizada com sucesso!",Toast.LENGTH_LONG).show();
       }catch (Exception ex){
           Toast.makeText(getApplicationContext(),"Não foi possivel atualizar a anotação!",Toast.LENGTH_LONG).show();
       }
       voltar(v);
    }

    public void excluiAnotacao (View v){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo =(EditText) findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudo);
        try{
            bancoDeDados.excluiAnotacao(this.getIntent().getIntExtra("id",0));
            Toast.makeText(getApplicationContext(),"Anotação excluida com sucesso!",Toast.LENGTH_LONG).show();
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Não foi possivel excluir a anotação!",Toast.LENGTH_LONG).show();
        }
        voltar(v);
    }

}
