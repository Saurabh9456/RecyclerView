package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TvShowsListener  {

    private Button buttonAddToWatchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView tvShowsRecyclerView = findViewById(R.id.tvShowsRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchlist);


        // list of data locally//
        List<TvShow> tvShows =  new ArrayList<>();

        TvShow the100 = new TvShow();
        the100.image = R.drawable.the_100;
        the100.name = "The 100";
        the100.rating = 5f;
        the100.createdBy = "Jason Rothenberg";
        the100.story = "The series is set 97 years afetr a devastating nuclear war out almost all life on Earth.";
        tvShows.add(the100);

        TvShow lostInSpace = new TvShow();
        lostInSpace.image = R.drawable.lost_in_space;
        lostInSpace.name = "Lost in Space";
        lostInSpace.rating = 4.5f;
        lostInSpace.createdBy = "Irwin Allen, Matt Sazama, Burk Sharpless";
        lostInSpace.story = "set 30 years in the future, colonization in space is now a reality, and the Rubison family is among those.";
        tvShows.add(lostInSpace);

        TvShow vikings = new TvShow();
        vikings.image = R.drawable.vikings;
        vikings.name = "Vikings";
        vikings.rating = 4.5f;
        vikings.createdBy = "Michel Hirst";
        vikings.story = "The adventures of a Ragnar Lothbrok: the greatest hero of his age.";
        tvShows.add(vikings);

        TvShow travelers = new TvShow();
        travelers.image = R.drawable.travellers;
        travelers.name = "Travelers";
        travelers.rating = 4f;
        travelers.createdBy = "Michael Hirst";
        travelers.story = "Hundreds of years from now, the last surviving humans discover the means of sending consciousness back through  time.";
        tvShows.add(travelers);

        TvShow futureMan  = new TvShow();
        futureMan.image = R.drawable.future_man;
        futureMan.name = "Future Man";
        futureMan.rating = 4f;
        futureMan.createdBy = "Kyle Hunter, Howard Overman, Ariel Shaffir";
        futureMan.story = "Josh FutturMan, a janitor bu day a gamer by night, is recruited by mysterious visitors to travel through time.";
        tvShows.add(futureMan);

        TvShow breakingBad = new TvShow();
        breakingBad.image = R.drawable.breaking_bad;
        breakingBad.name = "Breaking Bad";
        breakingBad.rating = 4f;
        breakingBad.createdBy = "Vince Gilligan";
        breakingBad.story = "wwhen Chemistry teacher walter white is diagnosed with Stage III cancer and given only two years to live.";
        tvShows.add(breakingBad);

        TvShow theWalkingDead = new TvShow();
        theWalkingDead.image = R.drawable.the_walking_dead;
        theWalkingDead.name = "The Walking Dead";
        theWalkingDead.rating = 4.5f;
        theWalkingDead.createdBy = "Frank Darabont, Angela kang";
        theWalkingDead.story = "Sheriff Deputy Rick Grimes gets shot and falts into a coma. When awoken he finds himself in a Zombie Apocalyse";
        tvShows.add(theWalkingDead);

        TvShow theRain = new TvShow();
        theRain.image = R.drawable.the_rain;
        theRain.name = "The Rain";
        theRain.rating = 4f;
        theRain.createdBy = "Jannik Tai Mosholt, Christian Potalivo, Esben Toft Jacobsen";
        theRain.story = "The world as we  know it has ended. Six years after a brutal virus carried bu the rain wiped out almost all.";
        tvShows.add(theRain);

        TvShow lost =  new TvShow();
        lost.image = R.drawable.lost;
        lost.name =  "Lost";
        lost.rating = 4.5f;
        lost.createdBy = "J.J. Abrams, Jeffrey Liaber, Damon Lindelof";
        lost.story = "The past, present, and future lives of surviving Oceanic Flight 815 Pasengers are dramatically intertwined as a fight";
        tvShows.add(lost);

        final  TvShowsAdapter tvShowsAdapter = new TvShowsAdapter(tvShows, this);
        tvShowsRecyclerView.setAdapter(tvShowsAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Following is the list of selected items in recycler view.

                List<TvShow> selectedTvShows = tvShowsAdapter.getSelectedTvShow();

                StringBuilder tvShowNames = new StringBuilder();
                for (int i = 0; i< selectedTvShows.size(); i++)
                  {
                      if(i == 0)
                        {
                            tvShowNames.append(selectedTvShows.get(i).name);
                        }else
                            {
                                tvShowNames.append("\n").append(selectedTvShows.get(i).name);
                            }
                  }
                Toast.makeText(MainActivity.this, tvShowNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onTvShowAction(Boolean isSelected) {
        if(isSelected)
         {
             buttonAddToWatchlist.setVisibility(View.VISIBLE);
         }else
           {
               buttonAddToWatchlist.setVisibility(View.GONE);
           }

    }
}