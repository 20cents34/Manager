package projet.isn.manager;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainAdapter extends ArrayAdapter<Commande>
{
    //tweets est la liste des models à afficher
    public MainAdapter(Context context, List<Commande> commandes) {
        super(context, 0, commandes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent, false);
        }

        CommandeViewHolder viewHolder = (CommandeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CommandeViewHolder();
            viewHolder.client = (TextView) convertView.findViewById(R.id.client_list);
            viewHolder.client_nom = (TextView) convertView.findViewById(R.id.client_list_nom);
            viewHolder.table = (TextView) convertView.findViewById(R.id.table_list);
            viewHolder.table_nb = (TextView) convertView.findViewById(R.id.table_list_nb);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status);
            viewHolder.status_img = (ImageView) convertView.findViewById(R.id.status_img);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Commande cmd = getItem(position);


        viewHolder.status.setText("Status :");
        viewHolder.client_nom.setText(cmd.getClient_nom());
        viewHolder.client.setText(cmd.getClient());
        viewHolder.table_nb.setText(cmd.getTable_nb());
        viewHolder.table.setText(cmd.getTable());
        //viewHolder.status_img.setImageDrawable();

        return convertView;
    }

    private class CommandeViewHolder{
        public TextView table;
        public TextView client;
        public TextView client_nom;
        public TextView table_nb;
        public TextView status;
        public ImageView status_img;
    }
}
