package br.desenvolvedor.michelatz.aplcativosolar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class AdicionaDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_dados);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HCC SOLAR");
        toolbar.setSubtitle("Adiciona Dados da Unidade");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    public void finalizaInsercao(View v) {
        Intent it = new Intent(this, Proposta4.class);
        startActivity(it);
        finish();
    }

    //Metodo que pega ação do botão voltar no toolbar bem em cima da tela
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent it = new Intent(this, Proposta4.class);
                startActivity(it);
                finish();

                break;
            default:break;
        }
        return true;
    }

    //Metodo responsavel por pegar ação do botão nativo "Voltar" do smartfone
    @Override
    public void onBackPressed() {
        Intent it = new Intent(this, Proposta4.class);
        startActivity(it);
        finish();
    }

}
