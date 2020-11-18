package it.francescogastone.todoandroidapp.controllo;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import it.francescogastone.todoandroidapp.Applicazione;
import it.francescogastone.todoandroidapp.activity.ActivityPrincipale;
import it.francescogastone.todoandroidapp.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneAggiungiToDo = new AzioneAggiungiToDo();
    private AdapterView.OnItemClickListener azioneClickListViewItem = new  AzioneClickListViewItem();

    public View.OnClickListener getAzioneAggiungiToDo() {
        return azioneAggiungiToDo;
    }

    public AdapterView.OnItemClickListener getAzioneClickListViewItem() {
        return azioneClickListViewItem;
    }

    private class AzioneAggiungiToDo implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            List<String> listaToDo = (List<String>) Applicazione.getInstance().getModello().getBean("LISTA");
            String testoToDo = vistaPrincipale.getTestoToDo();

            if(!testoToDo.trim().isEmpty()){
                listaToDo.add(testoToDo);
                vistaPrincipale.aggiornaListView();
                vistaPrincipale.clearEditText();
                Applicazione.getInstance().getModello().putBean("LISTA", listaToDo);

            } else {
                Log.d("Button add", "Edit text vuoto");
            }
        }
    }

    private class AzioneClickListViewItem implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            List<String> listaToDo = (List<String>) Applicazione.getInstance().getModello().getBean("LISTA");

            String str = parent.getItemAtPosition(position).toString();
            listaToDo.remove(str);
            vistaPrincipale.aggiornaListView();

            Applicazione.getInstance().getModello().putBean("LISTA", listaToDo);
            
        }
    }

}
