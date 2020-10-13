package com.example.nfc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    private static final int DIALOG_WRITE_URL = 1; //
    private static final int PENDING_INTENT_TECH_DISCOVERED = 1;
    private EditText mMyUrl; //
    private Button myWriteUrlButton ;//
    private boolean mWriteUrl = false;//
    private NfcAdapter mNfceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyUrl = (EditText) findViewById(R.id.myURL);
        myWriteUrlButton = (Button) findViewById(R.id.myWriteUrlButton);
        myWriteUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWriteUrl = true;
                MainActivity.this.showDialog(DIALOG_WRITE_URL);
            }
        });
    }
    protected Dialog onCreateDialog(int id,Bundle args){
        switch (id){
            case DIALOG_WRITE_URL:
                return new AlertDialog.Builder(this)
                        .setTitle("Write URL to Tag...")
                        .setMessage("Touch tag to start writing.")
                        .setCancelable(true)
                        .setNeutralButton(android.R.string.cancel,new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface d,int arg){
                                d.cancel();
                            }
                        })
                        .setOnCancelListener(new DialogInterface.OnCancelListener(){
                            public void onCancel(DialogInterface d){
                                mWriteUrl = false;
                            }
                        }).create();
        }
        return null;
    }
    //BIEN

    @Override
    public void onResume(){
        super.onResume();

        NfcManager nfcManager = (NfcManager) this.getSystemService(Context.NFC_SERVICE);
        mNfceAdapter = nfcManager.getDefaultAdapter();

        PendingIntent pi = createPendingResult(PENDING_INTENT_TECH_DISCOVERED,new Intent(),0);

        mNfceAdapter.enableForegroundDispatch(
                this,
                pi,
                new IntentFilter[]{ new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED)},
                new String[][]{
                        new String[]{"android.nfc.tech.NdefFormatable"},
                        new String[]{"android.nfc.tech.Ndef"}
                });
    }

    @Override
    public void onPause(){
        super.onPause();
        mNfceAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case PENDING_INTENT_TECH_DISCOVERED:
                resolveIntent(data,true);
                break;
        }
    }

    private void resolveIntent(Intent data,boolean foregroundDispatch){
        String action = data.getAction();

        if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)){
            Tag tag = data.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if (foregroundDispatch && mWriteUrl){
                mWriteUrl = false;
                //dismissDialog(DIALOG_WRITE_URL);
                String urlStr = mMyUrl.getText().toString();
                byte[] urlBytes = urlStr.getBytes(Charset.forName("UTF-8"));

                byte[] urlPayload = new byte[urlBytes.length + 1];
                urlPayload[0] = 0;
                System.arraycopy(urlBytes,0,urlPayload,1,urlBytes.length);
                NdefRecord urlRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                        NdefRecord.RTD_URI,
                        new byte[0],
                        urlPayload);
                NdefMessage msg = new NdefMessage(new NdefRecord[]{urlRecord});
                Ndef ndefTag = Ndef.get(tag);
                if (ndefTag != null){
                    try {
                        ndefTag.connect();
                        ndefTag.writeNdefMessage(msg);
                    }catch (Exception e){
                    }finally {
                        try { ndefTag.close();}catch (Exception e){}
                    }
                }else{
                    //Our tag is not NDEF formatted!
                    NdefFormatable ndefFormatableTag = NdefFormatable.get(tag);
                    if (ndefFormatableTag != null){
                        try {
                            ndefFormatableTag.connect();
                        }catch (Exception e){
                        }finally {
                            try {ndefFormatableTag.close(); }catch (Exception e){}
                        }
                    }
                }
            }
        }
    }

}