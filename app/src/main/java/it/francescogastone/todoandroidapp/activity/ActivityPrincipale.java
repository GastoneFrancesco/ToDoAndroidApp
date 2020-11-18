package it.francescogastone.todoandroidapp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.francescogastone.todoandroidapp.R;
import it.francescogastone.todoandroidapp.vista.VistaPrincipale;

public class ActivityPrincipale extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_principale);
    }

    public VistaPrincipale getVistaPrincipale() {
        return (VistaPrincipale)this.getSupportFragmentManager().findFragmentById(R.id.vistaPrincipale);
    }

}
