package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] message = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++) {
                message[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            Toast.makeText(context.getApplicationContext(),
                    message[0].getMessageBody(), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
        }



//        throw new UnsupportedOperationException("Not yet implemented");


    }
}