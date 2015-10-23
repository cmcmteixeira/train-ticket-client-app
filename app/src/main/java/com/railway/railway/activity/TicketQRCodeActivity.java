package com.railway.railway.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.railway.railway.QRCodeView;
import com.railway.railway.R;
import com.railway.railway.business.api.entity.Ticket;

public class TicketQRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_qrcode);

        Ticket ticket = (Ticket)getIntent().getSerializableExtra("ticket");
        TextView ticketInfo = (TextView)findViewById(R.id.ticketqrcode_lbl_ticket);
        String txt = "From: "
                + ticket.getStart() + "\n"
                + "To: "
                + ticket.getEnd() + "\n"
                + ticket.getPrice() + "€\n"
                + "Train number: " + ticket.getTrain();

        ticketInfo.setText(txt);

        QRCodeView qrCodeView = new QRCodeView(this,txt);
        LinearLayout qrCodeContainer = (LinearLayout)findViewById(R.id.ticketqrcode_container);
        qrCodeContainer.addView(qrCodeView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ticketqrcode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}