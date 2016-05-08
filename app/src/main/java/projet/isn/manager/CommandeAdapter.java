package projet.isn.manager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CommandeAdapter extends ArrayAdapter<Produits>
{
    CommandeViewHolder viewHolder;
    private List<Produits> cmdList;
    int nb = 1;

    public CommandeAdapter(Context context, List<Produits> prod)
    {
        super(context, 0, prod);
        this.cmdList = prod;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Produits products = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.commande_list_layout,parent, false);
        }


        viewHolder = (CommandeViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new CommandeViewHolder();
            viewHolder.nom_produit = (TextView) convertView.findViewById(R.id.nom_prod);
            viewHolder.nb_produit = (TextView) convertView.findViewById(R.id.nb_prod);
            viewHolder.nb_produit.setTag(products.getNb_prod());
            viewHolder.nom_produit.setTag(products.getNomProd());

            convertView.setTag(viewHolder);
        }
        products.setNb_prod((int)viewHolder.nb_produit.getTag());
        viewHolder.nom_produit.setText(products.getNomProd());
        viewHolder.nb_produit.setText(viewHolder.nb_produit.getTag().toString());
        return convertView;
    }

    public static class CommandeViewHolder
    {
        public TextView nom_produit;
        public TextView nb_produit;
    }



}
