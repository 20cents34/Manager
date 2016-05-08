package projet.isn.manager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TableAdapter extends ArrayAdapter<Produits>{
    CommandeViewHolder viewHolder;
    private List<Produits> cmdList;
    int nb = 1;

    public TableAdapter(Context context, List<Produits> prod)
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
            convertView.setTag(viewHolder);
        }
        viewHolder.nom_produit.setText(products.getNomProd());
        viewHolder.nb_produit.setText(Integer.toString(products.getNb_prod()));
        return convertView;
    }

    public static class CommandeViewHolder
    {
        public TextView nom_produit;
        public TextView nb_produit;
    }
}
