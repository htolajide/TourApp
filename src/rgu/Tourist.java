/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

/**
 *
 * @author Hammed
 */
public class Tourist {
    private final String name;
    private final String country;
    private AudioLanguage audioLanguage;

    public AudioLanguage getAudioLanguage() {
        return audioLanguage;
    }

    public void setAudioLanguage(AudioLanguage audioLanguage) {
        this.audioLanguage = audioLanguage;
    }

    public Tourist(String name, String country, AudioLanguage audioLanguage) {
        this.name = name;
        this.country = country;
        this.audioLanguage = audioLanguage;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name + " from " + country + ", preferred audio guide language is " + audioLanguage;
    }
    
}
