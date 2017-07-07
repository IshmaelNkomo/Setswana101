package com.example.admin.setswana101;

/**
 * Created by Admin on 6/27/2017.
 */

public class word {

//    Default translation for a word
    private String mDefaultTranslation;

//    Setswana Translation for the word
    private String mSetswanaTranslation;

// Image resource ID for the word
    private  int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

//    Audio Resource ID for the word
    private int mAudioResourceId;

//    Create a new word object

    public word(String defaultTranslation,String setswanaTranslation, int audioResourceId ) {

        mDefaultTranslation = defaultTranslation;
        mSetswanaTranslation = setswanaTranslation;
        mAudioResourceId = audioResourceId;


    }
    //    Create a new word object

    public word(String defaultTranslation,String setswanaTranslation, int imageResourceId, int audioResourceId) {

        mDefaultTranslation = defaultTranslation;
        mSetswanaTranslation = setswanaTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;


    }

    public String getSetswanaTranslation(){

        return mSetswanaTranslation;
    }
    public String getDefaultTranslation(){

        return mDefaultTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;

    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
