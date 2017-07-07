package com.example.admin.setswana101;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Greetings extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

//                              BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        Create list of Words
        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("Hello","Dumela",R.raw.hello));
        words.add(new word("Hello Sir, how are you?","Dumela Rra, o tsogile jang?",R.raw.hello_sir));
        words.add(new word("Hello Madam, how are you?","Dumela Mme, o tsogile jang?",R.raw.hello_madam));
        words.add(new word("I am fine, how are you","Ke tsogile sentle, wena o tsogile jang?",R.raw.i_am_fine));
        words.add(new word("knock Knock(Entering a house)","Ko Ko",R.raw.knock_knock));
        words.add(new word("Come in","Tsena",R.raw.come_in));
        words.add(new word("Goodbye","Tsamaya sentle",R.raw.goodbye));
     



        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_Greetings);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.greetings);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                word Word = words.get(position);
                mMediaPlayer = MediaPlayer.create(Greetings.this, Word.getAudioResourceId());
                mMediaPlayer.start();
            }});
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if(item.getItemId()==android.R.home);
//        finish();
//        return super.onOptionsItemSelected(item);
//    }

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
