package com.example.chaingrabs2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;
//maybe, input should be entirely stored in binary


public class MainActivity extends FragmentActivity implements buttonsFragment.buttonsListener, videoFragment.videoListener {
    public chain backhandSlap() {
        chain backhandSlaps = new chain();
        backhandSlaps.setChainName("Backhand Slaps");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        motion.add(2);
        motion.add(3);
        motion.add(6);
        backhandSlaps.setInitialMotion(motion);
        backhandSlaps.setInitialInput(new input(1,1,0,0));

        //SEQUENCE GROUP BOT LEFT
        sequenceGroup SG2 = new sequenceGroup();
        sequence legStretch = new sequence();
        legStretch.setSequenceName("Leg Stretch Arm Lock");
        legStretch.add(new input(chain.ONE));
        legStretch.add(new input(chain.TWO));
        legStretch.add(new input(chain.FOUR));
        legStretch.add(new input(chain.THREE));
        legStretch.add(new input(chain.ONETWOFOUR));
        sequence neckCrush = new sequence();
        neckCrush.setSequenceName("Neck Crusher");
        neckCrush.add(new input(chain.ONE));
        neckCrush.add(new input(chain.THREEFOUR));
        neckCrush.add(new input(chain.ONE));
        neckCrush.add(new input(chain.TWO));
        neckCrush.add(new input(chain.ONETWO));
        SG2.add(legStretch);
        SG2.add(neckCrush);



        //SEQUENCE GROUP TOP
        sequenceGroup SG1 = new sequenceGroup();
        sequence tripleSlaps = new sequence();
        tripleSlaps.setSequenceName("Triple Slaps");
        tripleSlaps.add(new input(chain.TWO));
        tripleSlaps.add(new input(chain.THREE));
        tripleSlaps.add(new input(chain.FOUR));
        tripleSlaps.add(new input(chain.TWO));
        tripleSlaps.add(new input(chain.TWO));
        tripleSlaps.setNextGroup(SG2);
        sequence seoi = new sequence();
        seoi.setSequenceName("Seoi Gyaku Juji-Gatame");
        seoi.add(new input(chain.THREE));
        seoi.add(new input(chain.FOUR));
        seoi.add(new input(chain.THREE));
        seoi.add(new input(chain.ONETWO));
        sequence armBreak = new sequence();
        SG1.add(tripleSlaps);
        SG1.add(seoi);
        backhandSlaps.setCurrentGroup(SG1);
        return backhandSlaps;
    }
    public chain betrayer() {
        chain betrayer = new chain();
        betrayer.setChainName("Betrayer");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        motion.add(2);
        motion.add(1);
        motion.add(4);
        betrayer.setInitialMotion(motion);
        betrayer.setInitialInput(new input(1,0,0,1));

        //SEQUENCE GROUP BOT LEFT
        sequenceGroup SG2 = new sequenceGroup();
        sequence legStretch = new sequence();
        legStretch.setSequenceName("Leg Stretch Arm Lock");
        legStretch.add(new input(chain.ONE));
        legStretch.add(new input(chain.TWO));
        legStretch.add(new input(chain.FOUR));
        legStretch.add(new input(chain.THREE));
        legStretch.add(new input(chain.ONETWOFOUR));
        sequence neckCrush = new sequence();
        neckCrush.setSequenceName("Neck Crusher");
        neckCrush.add(new input(chain.ONE));
        neckCrush.add(new input(chain.THREEFOUR));
        neckCrush.add(new input(chain.ONE));
        neckCrush.add(new input(chain.TWO));
        neckCrush.add(new input(chain.ONETWO));
        SG2.add(legStretch);
        SG2.add(neckCrush);

        //SEQUENCE GROUP BOT RIGHT
        sequenceGroup SG3 = new sequenceGroup();
        sequence falling = new sequence();
        falling.setSequenceName("Falling Arm Break");
        falling.add(new input(chain.TWO));
        falling.add(new input(chain.ONE));
        falling.add(new input(chain.THREE));
        falling.add(new input(chain.FOUR));
        falling.add(new input(chain.ONETWO));
        sequence doubleArm = new sequence();
        doubleArm.setSequenceName("Double Arm Break");
        doubleArm.add(new input(chain.THREE));
        doubleArm.add(new input(chain.ONE));
        doubleArm.add(new input(chain.FOUR));
        doubleArm.add(new input(chain.ONETWO));
        doubleArm.add(new input(chain.ONETWO));
        SG3.add(falling);
        SG3.add(doubleArm);

        //SEQUENCE GROUP TOP
        sequenceGroup SG1 = new sequenceGroup();
        sequence twisted = new sequence();
        twisted.setSequenceName("Twisted Nightmare");
        twisted.add(new input(chain.TWO));
        twisted.add(new input(chain.ONE));
        twisted.add(new input(chain.ONETWO));
        twisted.add(new input(chain.ONETWOTHREE));
        twisted.setNextGroup(SG2);
        sequence armBreak = new sequence();
        armBreak.setSequenceName("Arm Break");
        armBreak.add(new input(chain.ONE));
        armBreak.add(new input(chain.THREE));
        armBreak.add(new input(chain.TWO));
        armBreak.add(new input(chain.ONE));
        armBreak.setNextGroup(SG3);
        SG1.add(twisted);
        SG1.add(armBreak);
        betrayer.setCurrentGroup(SG1);
        return betrayer;
    }
    public chain crabHold() {
        chain crabHold = new chain();
        crabHold.setChainName("Crab Hold");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        motion.add(2);
        motion.add(3);
        motion.add(6);
        crabHold.setInitialMotion(motion);
        crabHold.setInitialInput(new input(1,0,0,1));

        //SEQUENCE GROUP BOT LEFT
        sequenceGroup SG2 = new sequenceGroup();
        sequence doubleSnap = new sequence();
        doubleSnap.setSequenceName("Double Snap");
        doubleSnap.add(new input(chain.THREE));
        doubleSnap.add(new input(chain.ONE));
        doubleSnap.add(new input(chain.FOUR));
        doubleSnap.add(new input(chain.TWOFOUR));
        sequence doubleHeel = new sequence();
        doubleHeel.setSequenceName("Double Heel Hold");
        doubleHeel.add(new input(chain.ONE));
        doubleHeel.add(new input(chain.THREE));
        doubleHeel.add(new input(chain.TWOFOUR));
        doubleHeel.add(new input(chain.THREEFOUR));
        doubleHeel.add(new input(chain.ONETWO));
        SG2.add(doubleSnap);
        SG2.add(doubleHeel);


        //SEQUENCE GROUP TOP
        sequenceGroup SG1 = new sequenceGroup();
        sequence commando = new sequence();
        commando.setSequenceName("Commando Arm Lock");
        commando.add(new input(chain.THREEFOUR));
        commando.add(new input(chain.THREE));
        commando.add(new input(chain.FOUR));
        commando.add(new input(chain.ONETWO));
        sequence heelHold = new sequence();
        heelHold.setSequenceName("Arm Break");
        heelHold.add(new input(chain.THREEFOUR));
        heelHold.add(new input(chain.FOUR));
        heelHold.add(new input(chain.TWO));
        heelHold.add(new input(chain.ONETWO));
        heelHold.setNextGroup(SG2);
        SG1.add(commando);
        SG1.add(heelHold);
        crabHold.setCurrentGroup(SG1);
        return crabHold;
    }
    public chain armBreaker() {
        chain armBreaker = new chain();
        armBreaker.setChainName("Arm Breaker");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        motion.add(6);
        motion.add(5);
        motion.add(2);
        motion.add(3);
        armBreaker.setInitialMotion(motion);
        armBreaker.setInitialInput(new input(1,0,0,1));

        //SEQUENCE GROUP BOT LEFT
        sequenceGroup SG2 = new sequenceGroup();
        sequence dragonSleeper = new sequence();
        dragonSleeper.setSequenceName("Dragon Sleeper Finish");
        dragonSleeper.add(new input(chain.TWO));
        dragonSleeper.add(new input(chain.ONE));
        dragonSleeper.add(new input(chain.THREE));
        dragonSleeper.add(new input(chain.ONETWOFOUR));
        dragonSleeper.add(new input(chain.ONETWOFOUR));
        sequence rdc = new sequence();
        rdc.setSequenceName("Rolling Death Cradle");
        rdc.add(new input(chain.ONETHREE));
        rdc.add(new input(chain.THREEFOUR));
        rdc.add(new input(chain.TWOFOUR));
        rdc.add(new input(chain.ONETWO));
        rdc.add(new input(chain.ONETWOTHREE));
        SG2.add(rdc);
        SG2.add(dragonSleeper);

        sequenceGroup SG3 = new sequenceGroup();
        sequence struggleCombo = new sequence();
        struggleCombo.setSequenceName("Struggle Combination");
        struggleCombo.add(new input(chain.FOUR));
        struggleCombo.add(new input(chain.THREE));
        struggleCombo.add(new input(chain.FOUR));
        struggleCombo.add(new input(chain.THREEFOUR));
        struggleCombo.add(new input(chain.ONETWO));
        SG3.add(struggleCombo);

        //SEQUENCE GROUP TOP
        sequenceGroup SG1 = new sequenceGroup();
        sequence tripleArmBreaker = new sequence();
        tripleArmBreaker.setSequenceName("Triple Arm Breaker");
        tripleArmBreaker.add(new input(chain.ONETWO));
        tripleArmBreaker.add(new input(chain.ONETWO));
        sequence chickenWing = new sequence();
        chickenWing.setSequenceName("Chicken Wing Face Lock");
        chickenWing.add(new input(chain.TWO));
        chickenWing.add(new input(chain.ONE));
        chickenWing.add(new input(chain.ONETWOTHREE));
        chickenWing.setNextGroup(SG2);
        sequence headJam = new sequence();
        headJam.setSequenceName("Head Jammer");
        headJam.add(new input(chain.ONETWO));
        headJam.add(new input(chain.FOUR));
        headJam.add(new input(chain.TWOFOUR));
        headJam.setNextGroup(SG3);
        SG1.add(tripleArmBreaker);
        SG1.add(chickenWing);
        SG1.add(headJam);

        armBreaker.setCurrentGroup(SG1);
        return armBreaker;
    }
    public chain sHeelHold() {
        chain sHeelHold = new chain();
        sHeelHold.setChainName("Standing Heel Hold");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        motion.add(6);
        motion.add(5);
        motion.add(2);
        motion.add(3);
        sHeelHold.setInitialMotion(motion);
        sHeelHold.setInitialInput(new input(0,1,1,0));

        sequenceGroup SG2 = new sequenceGroup();
        sequence kingsBridge = new sequence();
        kingsBridge.setSequenceName("King's Bridge");
        kingsBridge.add(new input(chain.ONE));
        kingsBridge.add(new input(chain.THREE));
        kingsBridge.add(new input(chain.FOUR));
        kingsBridge.add(new input(chain.ONETWO));
        kingsBridge.add(new input(chain.THREEFOUR));
        SG2.add(kingsBridge);

        //SEQUENCE GROUP TOP
        sequenceGroup SG1 = new sequenceGroup();
        sequence STF = new sequence();
        STF.setSequenceName("S. T. F.");
        STF.add(new input(chain.ONE));
        STF.add(new input(chain.TWO));
        STF.add(new input(chain.THREE));
        STF.add(new input(chain.ONETWO));
        sequence indianDeath = new sequence();
        indianDeath.setSequenceName("Indian Death Lock");
        indianDeath.add(new input(chain.ONETWO));
        indianDeath.add(new input(chain.ONE));
        indianDeath.add(new input(chain.THREE));
        indianDeath.add(new input(chain.ONETWO));
        indianDeath.setNextGroup(SG2);
        sequence scorpionDeath = new sequence();
        scorpionDeath.setSequenceName("Scorpion Death Lock");
        scorpionDeath.add(new input(chain.ONETWO));
        scorpionDeath.add(new input(chain.THREE));
        scorpionDeath.add(new input(chain.ONE));
        scorpionDeath.add(new input(chain.ONETHREE));
        SG1.add(STF);
        SG1.add(indianDeath);
        SG1.add(scorpionDeath);

        sHeelHold.setCurrentGroup(SG1);
        return sHeelHold;
    }
    public chain rSStretchBomb() {
        chain rSStretchBomb = new chain();
        rSStretchBomb.setChainName("Reverse Special Stretch Bomb");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        motion.add(3);
        rSStretchBomb.setInitialMotion(motion);
        rSStretchBomb.setInitialInput(new input(0,1,0,1));

        //GS MB
        sequenceGroup SG4 = new sequenceGroup();
        sequence giantSwing = new sequence();
        giantSwing.setSequenceName("Giant Swing");
        giantSwing.add(new input(chain.TWO));
        giantSwing.add(new input(chain.ONE));
        giantSwing.add(new input(chain.THREE));
        giantSwing.add(new input(chain.FOUR));
        sequence muscleBuster = new sequence();
        muscleBuster.setSequenceName("Muscle Buster");
        muscleBuster.add(new input(chain.THREE));
        muscleBuster.add(new input(chain.ONE));
        muscleBuster.add(new input(chain.TWO));
        muscleBuster.add(new input(chain.THREEFOUR));
        muscleBuster.add(new input(chain.ONETWOTHREEFOUR));
        SG4.add(muscleBuster);
        SG4.add(giantSwing);

        //VICbOMB
        sequenceGroup SG3 = new sequenceGroup();
        sequence victoryBomb = new sequence();
        victoryBomb.setSequenceName("Victory Bomb");
        victoryBomb.add(new input(chain.ONE));
        victoryBomb.add(new input(chain.TWO));
        victoryBomb.add(new input(chain.THREEFOUR));
        victoryBomb.add(new input(chain.ONETWO));
        SG3.add(victoryBomb);
        victoryBomb.setNextGroup(SG4);

        //pb AND md
        sequenceGroup SG2 = new sequenceGroup();
        sequence manhattanDrop = new sequence();
        manhattanDrop.setSequenceName("Manhattan Drop");
        manhattanDrop.add(new input(chain.THREEFOUR));
        manhattanDrop.add(new input(chain.ONETWO));
        manhattanDrop.add(new input(chain.ONETWOFOUR));
        manhattanDrop.setNextGroup(SG3);
        sequence powerBomb = new sequence();
        powerBomb.setSequenceName("Power Bomb");
        powerBomb.add(new input(chain.ONE));
        powerBomb.add(new input(chain.TWO));
        powerBomb.add(new input(chain.THREEFOUR));
        powerBomb.setNextGroup(SG4);
        SG2.add(powerBomb);
        SG2.add(manhattanDrop);

        //SEQUENCE GROUP TOP
        sequenceGroup SG1 = new sequenceGroup();
        sequence cBuster = new sequence();
        cBuster.setSequenceName("Cannon Buster");
        cBuster.add(new input(chain.TWO));
        cBuster.add(new input(chain.TWO));
        cBuster.add(new input(chain.ONETWO));
        cBuster.setNextGroup(SG2);
        SG1.add(cBuster);

        rSStretchBomb.setCurrentGroup(SG1);
        return rSStretchBomb;
    }
    public chain reverseArmSlam() {
        chain reverseArmSlam = new chain();
        reverseArmSlam.setChainName("Reverse Arm Slam");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        motion.add(3);
        reverseArmSlam.setInitialMotion(motion);
        reverseArmSlam.setInitialInput(new input(1,0,1,0));

        //GS MB
        sequenceGroup SG6 = new sequenceGroup();
        sequence giantSwing = new sequence();
        giantSwing.setSequenceName("Giant Swing");
        giantSwing.add(new input(chain.TWO));
        giantSwing.add(new input(chain.ONE));
        giantSwing.add(new input(chain.THREE));
        giantSwing.add(new input(chain.FOUR));
        sequence muscleBuster = new sequence();
        muscleBuster.setSequenceName("Muscle Buster");
        muscleBuster.add(new input(chain.THREE));
        muscleBuster.add(new input(chain.ONE));
        muscleBuster.add(new input(chain.TWO));
        muscleBuster.add(new input(chain.THREEFOUR));
        muscleBuster.add(new input(chain.ONETWOTHREEFOUR));
        SG6.add(muscleBuster);
        SG6.add(giantSwing);

        //Vic Bomb
        sequenceGroup SG5 = new sequenceGroup();
        sequence victoryBomb = new sequence();
        victoryBomb.setSequenceName("Victory Bomb");
        victoryBomb.add(new input(chain.ONE));
        victoryBomb.add(new input(chain.TWO));
        victoryBomb.add(new input(chain.THREEFOUR));
        victoryBomb.add(new input(chain.ONETWO));
        victoryBomb.setNextGroup(SG6);
        SG5.add(victoryBomb);

        //just PowerBomb
        sequenceGroup SG4 = new sequenceGroup();
        sequence powerBomb = new sequence();
        powerBomb.setSequenceName("Power Bomb");
        powerBomb.add(new input(chain.ONE));
        powerBomb.add(new input(chain.TWO));
        powerBomb.add(new input(chain.THREEFOUR));
        powerBomb.setNextGroup(SG6);
        SG4.add(powerBomb);

        //Power Bomb and ManhattanDrop
        sequenceGroup SG3 = new sequenceGroup();
        //just reuse powerbomb i guess?
//        sequence powerBomb2 = new sequence();
//        powerBomb2.setSequenceName("Power Bomb");
//        powerBomb2.add(new input(chain.ONE));
//        powerBomb2.add(new input(chain.TWO));
//        powerBomb2.add(new input(chain.THREEFOUR));
//        powerBomb2.setNextGroup(SG6);
        sequence manhattan = new sequence();
        manhattan.setSequenceName("Manhattan Drop");
        manhattan.add(new input(chain.THREEFOUR));
        manhattan.add(new input(chain.ONETWO));
        manhattan.add(new input(chain.ONETWOFOUR));
        manhattan.setNextGroup(SG5);
        SG3.add(manhattan);
        SG3.add(powerBomb);

        //German Suplex and Cannonball Buster
        sequenceGroup SG2 = new sequenceGroup();
        sequence germanSuplex = new sequence();
        germanSuplex.setSequenceName("German Suplex");
        germanSuplex.add(new input(chain.THREEFOUR));
        germanSuplex.add(new input(chain.ONETWO));
        germanSuplex.setNextGroup(SG4);
        sequence cannonball = new sequence();
        cannonball.setSequenceName("Cannonball Buster");
        cannonball.add(new input(chain.TWO));
        cannonball.add(new input(chain.TWO));
        cannonball.add(new input(chain.ONETWO));
        cannonball.setNextGroup(SG3);
        SG2.add(cannonball);
        SG2.add(germanSuplex);

        //Backdrop
        sequenceGroup SG1 = new sequenceGroup();
        sequence backdrop = new sequence();
        backdrop.setSequenceName("Backdrop");
        backdrop.add(new input(chain.TWO));
        backdrop.add(new input(chain.ONE));
        backdrop.add(new input(chain.ONETWO));
        backdrop.setNextGroup(SG2);
        SG1.add(backdrop);

        reverseArmSlam.setCurrentGroup(SG1);
        return reverseArmSlam;
    }
    public chain cobraClutch() {
        chain cobraClutch = new chain();
        cobraClutch.setChainName("Cobra Clutch");
        ArrayList<Integer> motion = new ArrayList<Integer>();
        //no motion, hope this don't cause problems
        cobraClutch.setInitialMotion(motion);
        //unique input, will need to implement unique drawable for unique input
        cobraClutch.setInitialInput(new input(2,2,2,2));

        //SCREWDRIVER
        sequenceGroup SG10 = new sequenceGroup();
        sequence screwdriver1 = new sequence();
        screwdriver1.setSequenceName("Screwdriver");
        screwdriver1.add(new input(chain.TWOFOUR));
        screwdriver1.add(new input(chain.THREEFOUR));
        screwdriver1.add(new input(chain.ONETHREE));
        screwdriver1.add(new input(chain.ONETWO));
        screwdriver1.add(new input(chain.ONETWOTHREE));
        sequence screwdriver2 = new sequence();
        screwdriver2.setSequenceName("Screwdriver");
        screwdriver2.add(new input(chain.TWOFOUR));
        screwdriver2.add(new input(chain.THREEFOUR));
        screwdriver2.add(new input(chain.ONETHREE));
        screwdriver2.add(new input(chain.ONETWO));
        screwdriver2.add(new input(chain.ONETWOTHREE));
        SG10.add(screwdriver1);
        SG10.add(screwdriver2);

        //burning hammer sol naciente
        sequenceGroup SG9 = new sequenceGroup();
        sequence burningHammer1 = new sequence();
        burningHammer1.setSequenceName("Burning Hammer");
        burningHammer1.add(new input(chain.ONETWO));
        burningHammer1.add(new input(chain.THREE));
        burningHammer1.add(new input(chain.FOUR));
        burningHammer1.add(new input(chain.ONETHREE));
        burningHammer1.setNextGroup(SG10);
        sequence burningHammer2 = new sequence();
        burningHammer2.setSequenceName("Burning Hammer");
        burningHammer2.add(new input(chain.ONETWO));
        burningHammer2.add(new input(chain.THREE));
        burningHammer2.add(new input(chain.FOUR));
        burningHammer2.add(new input(chain.TWOFOUR));
        burningHammer2.setNextGroup(SG10);
        sequence solNaciente = new sequence();
        solNaciente.setSequenceName("Sol Naciente");
        solNaciente.add(new input(chain.ONETWO));
        solNaciente.add(new input(chain.FOUR));
        solNaciente.add(new input(chain.ONETWO));
        solNaciente.add(new input(chain.ONETWOTHREE));
        SG9.add(burningHammer1);
        SG9.add(burningHammer2);
        SG9.add(solNaciente);
        //GS MB
        sequenceGroup SG8 = new sequenceGroup();
        sequence giantSwing = new sequence();
        giantSwing.setSequenceName("Giant Swing");
        giantSwing.add(new input(chain.TWO));
        giantSwing.add(new input(chain.ONE));
        giantSwing.add(new input(chain.THREE));
        giantSwing.add(new input(chain.FOUR));
        sequence muscleBuster = new sequence();
        muscleBuster.setSequenceName("Muscle Buster");
        muscleBuster.add(new input(chain.THREE));
        muscleBuster.add(new input(chain.ONE));
        muscleBuster.add(new input(chain.TWO));
        muscleBuster.add(new input(chain.THREEFOUR));
        muscleBuster.add(new input(chain.ONETWOTHREEFOUR));
        SG8.add(muscleBuster);
        SG8.add(giantSwing);

        //Vic Bomb
        sequenceGroup SG7 = new sequenceGroup();
        sequence victoryBomb = new sequence();
        victoryBomb.setSequenceName("Victory Bomb");
        victoryBomb.add(new input(chain.ONE));
        victoryBomb.add(new input(chain.TWO));
        victoryBomb.add(new input(chain.THREEFOUR));
        victoryBomb.add(new input(chain.ONETWO));
        victoryBomb.setNextGroup(SG8);
        SG7.add(victoryBomb);

        //Power Bomb and ManhattanDrop
        sequenceGroup SG6 = new sequenceGroup();
        sequence powerBomb = new sequence();
        powerBomb.setSequenceName("Power Bomb");
        powerBomb.add(new input(chain.ONE));
        powerBomb.add(new input(chain.TWO));
        powerBomb.add(new input(chain.THREEFOUR));
        powerBomb.setNextGroup(SG8);
        sequence manhattan = new sequence();
        manhattan.setSequenceName("Manhattan Drop");
        manhattan.add(new input(chain.THREEFOUR));
        manhattan.add(new input(chain.ONETWO));
        manhattan.add(new input(chain.ONETWOFOUR));
        manhattan.setNextGroup(SG7);
        SG6.add(manhattan);
        SG6.add(powerBomb);

        //backdrop and cannonball buster
        sequenceGroup SG5 = new sequenceGroup();
        sequence backdrop = new sequence();
        backdrop.setSequenceName("Backdrop");
        backdrop.add(new input(chain.THREEFOUR));
        backdrop.add(new input(chain.ONETWO));
        backdrop.setNextGroup(SG9);
        sequence cannonball = new sequence();
        cannonball.setSequenceName("Cannonball Buster");
        cannonball.add(new input(chain.TWO));
        cannonball.add(new input(chain.TWO));
        cannonball.add(new input(chain.ONETWO));
        cannonball.setNextGroup(SG6);
        SG5.add(backdrop);
        SG5.add(cannonball);

        //reverse special stretch bomb and samurai rock
        sequenceGroup SG4 = new sequenceGroup();
        sequence rssb1 = new sequence();
        rssb1.setSequenceName("Reverse Special Stretch Bomb");
        rssb1.add(new input(chain.ONETWO));
        rssb1.add(new input(chain.ONE));
        rssb1.add(new input(chain.TWO));
        rssb1.add(new input(chain.ONETWOTHREE));
        rssb1.setNextGroup(SG5);
        sequence rssb2 = new sequence();
        rssb2.setSequenceName("Reverse Special Stretch Bomb");
        rssb2.add(new input(chain.ONETWO));
        rssb2.add(new input(chain.ONE));
        rssb2.add(new input(chain.TWO));
        rssb2.add(new input(chain.ONETWOFOUR));
        rssb2.setNextGroup(SG5);
        sequence samuraidesu = new sequence();
        samuraidesu.setSequenceName("Samurai Rock");
        samuraidesu.add(new input(chain.TWO));
        samuraidesu.add(new input(chain.THREE));
        samuraidesu.add(new input(chain.ONE));
        samuraidesu.add(new input(chain.ONETWO));
        //no followup
        SG4.add(rssb1);
        SG4.add(rssb2);
        SG4.add(samuraidesu);

        //reverse ddt
        sequenceGroup SG3 = new sequenceGroup();
        sequence rddt1 = new sequence();
        rddt1.setSequenceName("Reverse DDT");
        rddt1.add(new input(chain.TWO));
        rddt1.add(new input(chain.ONE));
        rddt1.add(new input(chain.ONETHREE));
        rddt1.setNextGroup(SG4);
        sequence rddt2 = new sequence();
        rddt2.setSequenceName("Reverse DDT");
        rddt2.add(new input(chain.TWO));
        rddt2.add(new input(chain.ONE));
        rddt2.add(new input(chain.TWOFOUR));
        rddt2.setNextGroup(SG4);
        SG3.add(rddt1);
        SG3.add(rddt2);


        //TRIPLE TROUBLE AND HUMAN NECKTIE
        sequenceGroup SG2 = new sequenceGroup();
        sequence tripleTrouble = new sequence();
        tripleTrouble.setSequenceName("Triple Trouble");
        tripleTrouble.add(new input(chain.ONE));
        tripleTrouble.add(new input(chain.ONE));
        tripleTrouble.add(new input(chain.ONETWO));
        sequence humanNecktie = new sequence();
        humanNecktie.setSequenceName("Human Necktie");
        humanNecktie.add(new input(chain.THREE));
        humanNecktie.add(new input(chain.FOUR));
        humanNecktie.add(new input(chain.ONETWO));
        humanNecktie.add(new input(chain.THREEFOUR));
        SG2.add(tripleTrouble);
        SG2.add(humanNecktie);

        //flinging half nelson, sleeper, cobra twist
        sequenceGroup SG1 = new sequenceGroup();
        sequence halfNelson = new sequence();
        halfNelson.setSequenceName("Flinging Half Nelson");
        halfNelson.add(new input(chain.TWOFOUR));
        halfNelson.add(new input(chain.ONETWO));
        halfNelson.add(new input(chain.ONETWO));
        //NO FOLLOWUPS
        sequence sleeper = new sequence();
        sleeper.setSequenceName("Sleeper");
        sleeper.add(new input(chain.THREEFOUR));
        sleeper.add(new input(chain.THREEFOUR));
        sleeper.add(new input(chain.ONETWO));
        sleeper.setNextGroup(SG2);
        sequence cobraTwist = new sequence();
        cobraTwist.setSequenceName("Cobra Twist");
        cobraTwist.add(new input(chain.ONE));
        cobraTwist.add(new input(chain.FOUR));
        cobraTwist.add(new input(chain.TWO));
        cobraTwist.add(new input(chain.THREE));
        cobraTwist.setNextGroup(SG3);
        SG1.add(halfNelson);
        SG1.add(sleeper);
        SG1.add(cobraTwist);

        cobraClutch.setCurrentGroup(SG1);
        return cobraClutch;
    }

    String INPUT_FRAG_TAG = "input_fragment";
    String VIDEO_FRAG_TAG = "video_fragment";

    private Vibrator myVib;
    int pressed[] = new int[4];
    int currentFragmentSelection = 0;
    int lastPressed[] = new int[4];
    chain currentChain;
    inputsFragment displayFragment;
    videoFragment videoFragment;
    buttonsFragment buttonsFragment;
    Dialog myDialog;
    ProgressBar progressBar;
    long startTime = 0;
    long inputWindow = 3000;
    boolean resetInputs = true;

    //mode 0 = grabInputs
    //mode 1 = grabBreaks
    int mode = 0;
    //final chain[] nextGrab = new chain[1];
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
//            int seconds = (int) (millis / 1000);
//            seconds = seconds % 60;
            int progress = (int)( (float)millis / inputWindow  * 100);
            //Log.d("Progress", "Millis: "+ Long.toString(( ( (float)millis / inputWindow ) * (long)100.0)));
            //Log.d("Progress", "division makes sense: "+ Long.toString((long)((float)millis/inputWindow)));
            //Log.d("Progress", "Millis: "+ Long.toString(millis));
            //Log.d("Progress", "Progress: "+ Integer.toString(progress));
            //Log.d("inputWindow", Long.toString(inputWindow));
            if (currentFragmentSelection == 0)
                progressBar.setProgress(progress);
            if (millis>=inputWindow) {
                Log.d("inputWindow", "times up!");
                //timerHandler.removeCallbacks(timerRunnable);
                if (currentFragmentSelection == 0)
                    ShowPopup(findViewById(android.R.id.content), 0);
                else {
                    if (videoFragment.getBroken()) {
                        Log.d("timerRunnable", "grab broken, swapping visibility");
                        videoFragment.swapVisibility();
                    }
                    Log.d("timerRunnable", "grab not broken");
                    timerHandler.removeCallbacks(timerRunnable);
                }
            } else timerHandler.postDelayed(this, 33);
        }
    };




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);
        //displayFragment = (inputsFragment) getSupportFragmentManager().findFragmentById(R.id.main_inputs_frag);
        //progressBar = findViewById(R.id.progressBar);

        FragmentTransaction ft = (FragmentTransaction) getSupportFragmentManager().beginTransaction();
        ft.add(R.id.button_container, new buttonsFragment(), "buttons_fragment");
        ft.addToBackStack(null);
        ft.commit();
        ft = (FragmentTransaction) getSupportFragmentManager().beginTransaction();
        ft.add(R.id.display_container, new inputsFragment(), "inputs_fragment");
        ft.addToBackStack(null);
        ft.commit();
        currentChain = backhandSlap();
        displayFragment = (inputsFragment) getSupportFragmentManager().findFragmentByTag("inputs_fragment");
        progressBar = findViewById(R.id.progressBar);
//        buttonsFragment = (buttonsFragment) getSupportFragmentManager().findFragmentByTag("buttons_fragment");
        ShowPopup(findViewById(android.R.id.content), -1);
    }

//    public void launchMenuActivity(View view) {
//        Log.d("MENU", "Menu launch button clicked");
//        Intent intent = new Intent(this, MenuActivity.class);
//        startActivity(intent);
//    }

    public boolean newInputValid(int [] input, int[] lastInput) {
//        if (Arrays.equals(input, lastInput)) {
//            return false;
//        }
//        if (Arrays.equals(input, chain.ZERO)) {
//            return false;
//        }
        for (int i = 0; i < 4; i++) {
            if (lastInput[i] ==0 && input[i] == 1) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void handleTouch(int pressedIndex, MotionEvent m) {
        input userInput;
        Log.d("", "Touch event initiated");
        lastPressed = pressed.clone();
        if (pressedIndex != -1) {
            if (pressedIndex == 4) {
                int action = m.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        pressed[0] = 1;
                        pressed[1] = 1;
                        break;
                    case MotionEvent.ACTION_UP:
                        pressed[0] = 0;
                        pressed[1] = 0;
                        break;
                }
            } else {
                int action = m.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        pressed[pressedIndex] = 1;
                        break;
                    case MotionEvent.ACTION_UP:
                        pressed[pressedIndex] = 0;
                        break;
                }
            }
        }
        if (!newInputValid(pressed, lastPressed)) {
            return;
        }
        userInput = new input(pressed[0], pressed[1], pressed[2], pressed[3]);
        myVib.vibrate(50);

        if (currentFragmentSelection == 0) {
            Log.d("ChainName", currentChain.getChainName());
            sequenceGroup cGroup = currentChain.currentGroup;
            int clearResponse = currentChain.clear(userInput);
            if (clearResponse > 0) {
                displayFragment.inputCleared(clearResponse, cGroup);
                Log.d("", "inputCleared()");
                resetInputs = false;
            }
            //if sequence cleared, bring up congratulatory notification then set next sequence
            //using displayFragment.setInputs(currentChain);

            if (currentChain.currentGroup != cGroup) {
                timerHandler.removeCallbacks(timerRunnable);
                displayFragment.clearInputs();
                displayFragment.setInputs(currentChain);
                startTime = System.currentTimeMillis();
                timerHandler.postDelayed(timerRunnable, 0);
            } // else if \/
            if (currentChain.cleared == true) {
                //timerHandler.removeCallbacks(timerRunnable);
                Log.d("", "Time to set new chain");
                ShowPopup(findViewById(android.R.id.content), 1);
            }

            String text = String.format("%d,%d,%d,%d", pressed[0], pressed[1], pressed[2], pressed[3]);
            Log.d("buttons", text);
        } else {
            //input must match exactly
            //only one try allowed
            //currently on video_fragment
            if (videoFragment.isChanceLeft()) {
                if (videoFragment.getBreakInput().match(userInput)) {
                    Log.d("videoFragment", "grab broken successfully");
                    videoFragment.grabBroken();
                }
                videoFragment.chanceLost();
            }
            else  {
                Log.d("chanceLeft", "naw");
            }
        }
    }
    public void setChart(View v, ZoomableImageView chartView, String chainName) {
        Bitmap king_chart = BitmapFactory.decodeResource(v.getContext().getResources(), R.drawable.king_chart);
        Bitmap nina_chart = BitmapFactory.decodeResource(v.getContext().getResources(), R.drawable.nina_chart);
        switch (chainName) {
            case("Backhand Slaps"):
            case("Betrayer"):
            case("Crab Hold"):
                chartView.setImageBitmap(nina_chart);
                break;
            case("Arm Breaker"):
            case("Standing Heel Hold"):
            case("Reverse Special Stretch Bomb"):
            case("Reverse Arm Slam"):
            case("Cobra Clutch"):
                chartView.setImageBitmap(king_chart);
                break;
        }

    }
    //selection 0 = set inputsFragment, selection 1 = set videoFragment
    public void setFragment(int selection) {
        FragmentTransaction ft;
        if (selection == 0) {
            inputsFragment test = (inputsFragment) getSupportFragmentManager().findFragmentByTag("inputs_fragment");
            if (test == null || !test.isVisible()) {
                Log.d("inputsFragment", "test is null  ");
                ft = getSupportFragmentManager().beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.display_container, new inputsFragment(), "inputs_fragment");
                ft.commitNow();
                //displayFragment = (inputsFragment) getSupportFragmentManager().findFragmentByTag("inputs_fragment");
            }
            //progressBar = findViewById(R.id.progressBar);
            //displayFragment = (inputsFragment) getSupportFragmentManager().findFragmentByTag("inputs_fragment");
            currentFragmentSelection = 0;
            displayFragment = (inputsFragment) getSupportFragmentManager().findFragmentByTag("inputs_fragment");
            if (test != null && test.isVisible())
                Log.d("inputsFragment", "exists");
            else
                Log.d("inputsFragment", "not found");
        } else {
            videoFragment test = (videoFragment) getSupportFragmentManager().findFragmentByTag("video_fragment");
            if (test == null || !test.isVisible()) {
                Log.d("videoFragment", "test is null  ");
                ft = getSupportFragmentManager().beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.display_container, new videoFragment(), "video_fragment");
                ft.commitNow();

            }
            //videoFragment = (videoFragment) getSupportFragmentManager().findFragmentByTag("video_fragment");
            currentFragmentSelection = 1;
            videoFragment = (videoFragment) getSupportFragmentManager().findFragmentByTag("video_fragment");
            if (test != null && test.isVisible())
                Log.d("videoFragment", "exists");
            else
                Log.d("videoFragment", "not found");
        }
    }
    public void ShowPopup(View v, int displayMessage) {
        timerHandler.removeCallbacks(timerRunnable);
        //change success to int to create other title options
        TextView successFail;
        TextView chosenGrab;
        Button goNext;
        myDialog.setContentView(R.layout.completion_popup);
        successFail = (TextView) myDialog.findViewById(R.id.successFail);
        chosenGrab = (TextView) myDialog.findViewById(R.id.current_grab_menu);
        String currentSelection;
        if (currentFragmentSelection == 0) {
            currentSelection = currentChain.getChainName();
        } else {
            currentSelection = "Grab Break Practice";
        }
        chosenGrab.setText(currentSelection);
        goNext = (Button) myDialog.findViewById(R.id.go_next_button);
        ZoomableImageView chartView = (ZoomableImageView)myDialog.findViewById(R.id.chartView);
        setChart(v,chartView,chosenGrab.getText().toString());
        switch (displayMessage) {
            case -1:
                successFail.setText("Welcome!");
                break;
            case 0:
                successFail.setText("FAIL");
                break;
            case 1:
                successFail.setText("SUCCESS");
                break;
            case 2:
                successFail.setText("Choose your Grab");
                break;
        }
        chosenGrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu popup = new PopupMenu(v.getContext(), v);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        TextView chosenGrab;
                        chosenGrab = (TextView) myDialog.findViewById(R.id.current_grab_menu);
                        ZoomableImageView chartView = (ZoomableImageView)myDialog.findViewById(R.id.chartView);
                        switch (menuItem.getItemId()) {
                            case R.id.item_backhand:
                                chosenGrab.setText("Backhand Slaps");
                                break;
                            case R.id.item_betrayer:
                                chosenGrab.setText(R.string.grab_betrayer);
                              break;
                            case R.id.item_crab:
                                chosenGrab.setText(R.string.grab_crab);
                                break;
                            case R.id.item_breaker:
                                chosenGrab.setText(R.string.grab_breaker);
                                break;
                            case R.id.item_heel:
                                chosenGrab.setText(R.string.grab_heel);
                                break;
                            case R.id.item_bomb:
                                chosenGrab.setText(R.string.grab_bomb);
                                break;
                            case R.id.item_slam:
                                chosenGrab.setText(R.string.grab_slam);
                                break;
                            case R.id.item_cobra:
                                chosenGrab.setText(R.string.grab_cobra);
                                break;
                            case R.id.item_breaks:
                                chosenGrab.setText(R.string.break_practice);
                                break;
                            default:
                                return false;
                        }
                        setChart(v,chartView,chosenGrab.getText().toString());
                        return true;
                    }
                });
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.grab_selection, popup.getMenu());
                popup.show();
            }
        });
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView chosenGrab;
                chosenGrab = (TextView) myDialog.findViewById(R.id.current_grab_menu);
                currentChain = null;
                int selection = 0;
                switch (chosenGrab.getText().toString()) {
                    case("Backhand Slaps"):
                        Log.d("SetGrab", "Backhand Slaps");
                        currentChain = backhandSlap();
                        break;
                    case("Betrayer"):
                        Log.d("SetGrab", "Betrayer");
                        currentChain = betrayer();
                        break;
                    case("Crab Hold"):
                        Log.d("SetGrab", "Crab Hold");
                        currentChain = crabHold();
                        break;
                    case("Arm Breaker"):
                        Log.d("SetGrab", "Arm Breaker");
                        currentChain = armBreaker();
                        break;
                    case("Standing Heel Hold"):
                        Log.d("SetGrab", "Standing Heel Hold");
                        currentChain = sHeelHold();
                        break;
                    case("Reverse Special Stretch Bomb"):
                        Log.d("SetGrab", "Reverse Special Stretch Bomb");
                        currentChain = rSStretchBomb();
                        break;
                    case("Reverse Arm Slam"):
                        Log.d("SetGrab", "Reverse Arm Slam");
                        currentChain = reverseArmSlam();
                        break;
                    case("Cobra Clutch"):
                        Log.d("SetGrab", "Cobra Clutch");
                        currentChain = cobraClutch();
                        break;
                    case("Grab Break Practice"):
                        Log.d("SetGrab", "Break Practice");
                        selection = 1;
                        break;
                }

                Log.d("selection", Integer.toString(selection));
                buttonsFragment = (buttonsFragment) getSupportFragmentManager().findFragmentByTag("buttons_fragment");
                if (selection == 0) {
                    Log.d("chosenGrab", "chosen Grab is not Grab Break Practice!");
                    setFragment(0);
                    progressBar = findViewById(R.id.progressBar);
                    displayFragment = (inputsFragment) getSupportFragmentManager().findFragmentByTag("inputs_fragment");
                    displayFragment.clearHeader();
                    displayFragment.clearInputs();
                    displayFragment.setHeader(currentChain);
                    displayFragment.setInputs(currentChain);
                    inputWindow = 3000;
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    currentFragmentSelection = 0;

                    buttonsFragment.setFourButtonScene();
                } else {
                    setFragment(1);
                    videoFragment = (videoFragment) getSupportFragmentManager().findFragmentByTag("video_fragment");
                    buttonsFragment.setThreeButtonScene();
                }
                myDialog.dismiss();
                Log.d("myDialog", "dismissed");

            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
        //reset buttons between runs hopefully
        pressed = new int[4];
    }

    @Override
    public void setUpTimer(long inputWindow) {
        startTime = System.currentTimeMillis();
        this.inputWindow = inputWindow;
        Log.d("inputWindow", Long.toString(inputWindow));
        timerHandler.postDelayed(timerRunnable, 0);
    }
}