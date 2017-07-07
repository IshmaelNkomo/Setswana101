package com.example.admin.setswana101;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Food extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;


    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        public void onAudioFocusChange(int focusChange){
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();

            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();

            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {

        }


        public void  OnCompletion(MediaPlayer mp){

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

//                           BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        Create list of Words
        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("Meat","Nama",R.drawable.food_meat,R.raw.meat));
        words.add(new word("Sorghum meal","Bogobe ba mabele",R.drawable.food_sorgum,R.raw.sorgum_meal));
        words.add(new word("Maize meal","Phaletshe",R.drawable.food_maize_meal,R.raw.maize_meal));
        words.add(new word("Soft porridge","Motogo",R.drawable.food_soft_porridge,R.raw.motogo));
        words.add(new word("Greens","Morogo",R.drawable.food_greens,R.raw.morogo));
        words.add(new word("Watermelon","Legapu",R.drawable.food_watermelon,R.raw.legapu));
        words.add(new word("Grapes","Moretlwa",R.drawable.food_grapes,R.raw.grapes));
        words.add(new word("Carrot","Segwete",R.drawable.food_carrot,R.raw.carrot));
        words.add(new word("Fish","Tlhapi",R.drawable.food_fish,R.raw.fish));
        words.add(new word("Tomato","Tamati",R.drawable.food_tamati,R.raw.tomato));





        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.

        WordAdapter adapter = new WordAdapter(this, words,  R.color.category_Food);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                word Word = words.get(position);
                mMediaPlayer = MediaPlayer.create(Food.this, Word.getAudioResourceId());
                mMediaPlayer.start();
            }});
    }

    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}
