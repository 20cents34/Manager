package projet.isn.manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class SettingsActivity extends AppCompatActivity
{
    final BluetoothAdapter blueAdapter = BluetoothAdapter.getDefaultAdapter();
    private BluetoothDevice device;
    private BluetoothSocket mmSocket;
    private ConnexionThread connect;
    public TextView txt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (blueAdapter == null) {
            Toast.makeText(SettingsActivity.this, "Vous n'avez pas le Bluetooth", Toast.LENGTH_SHORT).show();
        }

        final Switch bt = (Switch) findViewById(R.id.switch_bt);
        final Button but_Bt = (Button) findViewById(R.id.button_bt);
        txt = (TextView) findViewById(R.id.result_connexion);

        if(blueAdapter.isEnabled())
        {
            bt.setChecked(true);
        }
        bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (blueAdapter != null) {
                    if (!blueAdapter.isEnabled()) {
                        blueAdapter.enable();
                        bt.setChecked(true);
                    } else {
                        blueAdapter.disable();
                        bt.setChecked(false);
                    }
                }
            }
        });

        but_Bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                device = blueAdapter.getRemoteDevice("9C:2A:70:D1:2F:B8");
                connect = new ConnexionThread(device,txt,SettingsActivity.this);
                connect.start();
            }
        });


    }

    public void initBtConnexion()
    {
        device = blueAdapter.getRemoteDevice("00:26:83:3B:25:2E");
        /*9C:2A:70:D1:2F:B8*/

    }

    public void onDestroy()
    {
        super.onDestroy();
        connect.cancel();
    }
}
