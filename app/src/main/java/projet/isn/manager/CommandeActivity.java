package projet.isn.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommandeActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Produits> produit;
    private List<Produits> prod;
    public CommandeAdapter adapter;
    private Produits steak,frites,biere,vinrouge,vinblanc,vinrose,coca,fanta,sprite,icetea;
    Produits prd;
    TextView text, text2;
    int rs,i;
    int[] nb_env;
    String[] nom_env;
    int state= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_commande);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        state = intent.getIntExtra("type",0);
        mListView = (ListView) findViewById(R.id.commande_list);
        prod = new ArrayList<Produits>();

        adapter = new CommandeAdapter(CommandeActivity.this, prod);
        mListView.setAdapter(adapter);

        addProduits();




        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                i = parent.getCount();
                initArrays(i);
                text2 =(TextView) view.findViewById(R.id.nom_prod);
                text = (TextView) view.findViewById(R.id.nb_prod);

                rs = (int)text.getTag() + 1;
                text.setTag(rs);
                adapter.notifyDataSetChanged();


                prd = (Produits) parent.getItemAtPosition(position);
                prd.setNb_prod((int) text.getTag());
                String s = prd.getNomProd().toString();
                int k = (int)prd.getNb_prod();

                adapter.notifyDataSetChanged();
                nom_env[position] = s;
                nb_env[position] = k;

                Toast.makeText(getApplicationContext(),position + " " + s +" " + k,Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void initArrays(int i)
    {
        if (nb_env == null && nom_env == null)
        {
            nom_env = new String[i];
            nb_env = new int[i];
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_commande, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_envoyer)
        {
            if (nb_env != null && nom_env != null)
            {
                adapter.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("list_nb", i);
                intent.putExtra("nb", nb_env);
                intent.putExtra("nom", nom_env);
                setResult(RESULT_OK, intent);
                finish();
                return true;
            }
        }
        if (id == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addProduits()
    {
        switch (state)
        {
            case 0 :
                steak = new Produits("Steak",0);
                frites = new Produits("Frites",0);
                prod.add(steak);
                prod.add(frites);
                break;
            case 1 :
                biere = new Produits("Bière",0);
                vinrouge = new Produits("Vin Rouge",0);
                vinblanc = new Produits("Vin Blanc",0);
                vinrose = new Produits("Vin Rosé",0);
                coca = new Produits("Coca Cola",0);
                fanta = new Produits("Fanta",0);
                sprite = new Produits("Sprite",0);
                icetea = new Produits("Lipton Ice Tea",0);

                prod.add(biere);
                prod.add(vinrouge);
                prod.add(vinblanc);
                prod.add(vinrose);
                prod.add(coca);
                prod.add(fanta);
                prod.add(sprite);
                prod.add(icetea);


                break;
            default:

        }
    }
}
