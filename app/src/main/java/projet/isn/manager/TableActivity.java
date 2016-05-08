package projet.isn.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {


    String client_str,table_str;
    String[] prod_nom;
    int[] prod_nb;
    int i;
    ImageButton but_Apero,but_Boissons,but_Entrees,but_Plats,but_Desserts,but_Menus;
    private ListView mListView;
    private ArrayList<Produits> produit;
    public TableAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_table);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        but_Apero = (ImageButton)findViewById(R.id.but_apero);
        but_Boissons = (ImageButton)findViewById(R.id.but_boissons);
        but_Entrees = (ImageButton)findViewById(R.id.but_entrees);
        but_Plats = (ImageButton)findViewById(R.id.but_plats);
        but_Desserts = (ImageButton)findViewById(R.id.but_desserts);
        but_Menus = (ImageButton)findViewById(R.id.but_menus);

        mListView = (ListView) findViewById(R.id.recapList);

        produit = new ArrayList<Produits>();
        adapter = new TableAdapter(TableActivity.this,produit);
        mListView.setAdapter(adapter);

        initListeners();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_envoyer) {

            EditText table = (EditText) findViewById(R.id.inpTable);
            table_str = table.getText().toString();

            EditText client = (EditText) findViewById(R.id.inpClient);
            client_str = client.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("table_nb", table_str);
            intent.putExtra("client_nom", client_str);

            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        if (id == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0)
        {
            if (resultCode == RESULT_OK)
            {
                prod_nom = data.getStringArrayExtra("nom");
                prod_nb = data.getIntArrayExtra("nb");
                i = data.getIntExtra("list_nb", 0);

                Toast.makeText(getApplicationContext(), prod_nom[0] + " " + prod_nb[0], Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), prod_nom[1] + " " + prod_nb[1], Toast.LENGTH_SHORT).show();

                for (int j = 0 ; j < i; j++ )
                {
                    Toast.makeText(getApplicationContext(), prod_nom[j] + " " + prod_nb[j], Toast.LENGTH_SHORT).show();

                    if (prod_nom[j] != null && prod_nb[j] !=0)
                    {
                        produit.add(new Produits(prod_nom[j], prod_nb[j]));
                    }

                }


                adapter.notifyDataSetChanged();

            }
        }

    }

    protected  void initListeners()
    {
        but_Apero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, CommandeActivity.class);
                intent.putExtra("type",0);
                startActivityForResult(intent, 0);
            }
        });
        but_Boissons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, CommandeActivity.class);
                intent.putExtra("type",1);
                startActivityForResult(intent,0);
            }
        });
        but_Entrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, CommandeActivity.class);
                intent.putExtra("type",2);
                startActivityForResult(intent,0);
            }
        });
        but_Plats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, CommandeActivity.class);
                intent.putExtra("type",3);
                startActivityForResult(intent,0);
            }
        });
        but_Desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, CommandeActivity.class);
                intent.putExtra("type",4);
                startActivityForResult(intent,0);
            }
        });
        but_Menus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, CommandeActivity.class);
                intent.putExtra("type",5);
                startActivityForResult(intent, 0);
            }
        });

    }

}
