package it.francescogastone.todoandroidapp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.francescogastone.todoandroidapp.R;
import it.francescogastone.todoandroidapp.vista.VistaSeconda;

public class ActivitySeconda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_seconda);
    }

    public VistaSeconda getVistaSeconda(){
        return (VistaSeconda)this.getSupportFragmentManager().findFragmentById(R.id.vistaSeconda);
    }
}
