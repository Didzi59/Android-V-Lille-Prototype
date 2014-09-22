package com.example.bossutj.myvlillesimple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class FavorisActivity extends Activity {

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);

        createListFavoris();
        enableButton(R.id.btnStations, MainActivity.class);
        enableButton(R.id.btnCarte, CarteActivity.class);
    }

    private void enableButton(int id, final Class classe) {
        final Button button = (Button) findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(FavorisActivity.this, classe);
              startActivity(intent);
            }
        });
    }

    private void createListFavoris() {
        final ListView listview = (ListView) findViewById(R.id.listFavoris);
        String[] values = new String[] {
                "Jardin Vauban",
                "Massena",
                "Place de Strasbourg"
        };

        mAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, values);

        listview.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.favoris, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
