package projet.isn.manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class ConnexionThread extends Thread implements  Runnable{

    private BluetoothSocket blueSocket;
    private BluetoothDevice blueDevice;
    private TextView v;
    private Activity activity;
    private InputStream inpt;
    private OutputStream outp;
    private byte[] outBuf;
    private String uuid = "00001101-0000-1000-8000-00805F9B34FB";

    public ConnexionThread(BluetoothDevice device,TextView view,Activity act)
    {
        blueDevice = device;
        v = view;
        activity = act;
    }

    public void run()
    {
        BluetoothAdapter blueAdapter = BluetoothAdapter.getDefaultAdapter();
        blueAdapter.cancelDiscovery();

        try {
            blueSocket = blueDevice.createRfcommSocketToServiceRecord(UUID.fromString(uuid));


        } catch (IOException e) {

        }
        try {

            blueSocket.connect();

        } catch (IOException e) {

            try {
                blueSocket.close();
            } catch (IOException closeException) { }
        }
        if (blueSocket.isConnected())
        {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    v.setText("Connexion Réussie");
                }
            });
        }
        manageConnectedSocket(blueSocket);
    }

    private void manageConnectedSocket(BluetoothSocket blueSocket)
    {
        try {
            inpt = blueSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            outp = blueSocket.getOutputStream();
        } catch (IOException e){
            e.printStackTrace();
        }
        String s = new String("Hallo I'm a test which finally succeed");
        outBuf = s.getBytes();
        try {
            outp.write(outBuf);
        } catch (IOException e) {
            sendToUi("Echec de connexion");
    }
    }

    // Annule toute connexion en cours et tue le thread
    public void cancel() {
        try {
            blueSocket.close();
        } catch (IOException e) { }
    }

    private void sendToUi(String s)
    {
        final String msg = s;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
