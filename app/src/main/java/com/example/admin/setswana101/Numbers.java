package com.example.admin.setswana101;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;



public class Numbers extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

//                  BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Create list of Words
        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("One","Ngwe",R.drawable.number_one,R.raw.one));
        words.add(new word("Two","Pedi",R.drawable.number_two,R.raw.two));
        words.add(new word("Three","Tharo",R.drawable.number_three,R.raw.three));
        words.add(new word("Four","Nne",R.drawable.number_four,R.raw.four));
        words.add(new word("Five","Thlano",R.drawable.number_five,R.raw.five));
        words.add(new word("Six","Thataro",R.drawable.number_six,R.raw.six));
        words.add(new word("Seven","Supa",R.drawable.number_seven,R.raw.seven));
        words.add(new word("Eight","Robedi",R.drawable.number_eight,R.raw.eight));
        words.add(new word("Nine","Robongwe",R.drawable.number_nine,R.raw.nine));
        words.add(new word("Ten","Lesome",R.drawable.number_ten,R.raw.ten));



        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_Numbers);

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

                               mMediaPlayer = MediaPlayer.create(Numbers.this, Word.getAudioResourceId());

                               mMediaPlayer.start();

               mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                   @Override
                   public void onCompletion(MediaPlayer mp) {
                       releaseMediaPlayer();

                   }
               });
           }});
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
