package com.example.littlebigendian;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.littlebigendian.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    class Vector {
        String littleEndian;
        String bigEndian;
        String hexValue;
        int numberOfBytes;
    }

    ArrayList<Vector> vectors = new ArrayList<Vector>();

    void startCalculation() {
        Library library = new Library();
        for (int i = 0; i < vectors.size(); i++) {
            System.out.println(String.format("--------> ================ %d vector test ================", i));
            String hexToLittleEndianResult = library.hexToLittleEndian(vectors.get(i));
            System.out.println("--------> hexToLittleEndian " + hexToLittleEndianResult);

            String hexToBigEndianResult = library.hexToBigEndian(vectors.get(i));
            System.out.println("--------> hexToBigEndianResult " + hexToBigEndianResult);

            String littleEndianToHexResult = library.littleEndianToHex(vectors.get(i));
            System.out.println("--------> littleEndianToHexResult " + littleEndianToHexResult);

            String bigEndianToHexResult = library.bigEndianToHex(vectors.get(i));
            System.out.println("--------> bigEndianToHexResult " + bigEndianToHexResult);
        }

    }

    void initializeInputData() {
        Vector firstVector = new Vector();
        firstVector.bigEndian = "115339776388732929035197660848497720713218148788040405586178452820382218977280";
        firstVector.littleEndian = "255";
        firstVector.hexValue = "ff00000000000000000000000000000000000000000000000000000000000000";
        firstVector.numberOfBytes = 32;
        vectors.add(firstVector);

        Vector secondVector = new Vector();
        secondVector.bigEndian = "77193548260167611359494267807458109956502771454495792280332974934474558013440";
        secondVector.littleEndian = "43690";
        secondVector.hexValue = "aaaa000000000000000000000000000000000000000000000000000000000000";
        secondVector.numberOfBytes = 32;
        vectors.add(secondVector);

        Vector thirdVector = new Vector();
        thirdVector.bigEndian = "4294967295";
        thirdVector.littleEndian = "4294967295";
        thirdVector.hexValue = "FFFFFFFF";
        thirdVector.numberOfBytes = 4;
        vectors.add(thirdVector);

        Vector fourthVector = new Vector();
        fourthVector.bigEndian = "979114576324830475023518166296835358668716483481922294110218890578706788723335115795775136189060210944584475044786808910613350098299181506809283832360654948074334665509728123444088990750984735919776315636114949587227798911935355699067813766573049953903257414411690972566828795693861196044813729172123152193769005290826676049325224028303369631812105737593272002471587527915367835952474124875982077070337970837392460768423348044782340688207323630599527945406427226264695390995320400314062984891593411332752703846859640346323687201762934524222363836094053204269986087043470117703336873406636573235808683444836432453459818599293667760149123595668832133083221407128310342064668595954073131257995767262426534143159642539179485013975461689493733866106312135829807129162654188209922755829012304582671671519678313609748646814745057724363462189490278183457296449014163077506949636570237334109910914728582640301294341605533983878368789071427913184794906223657920124153256147359625549743656058746335124502376663710766611046750739680547042183503568549468592703882095207981161012224965829605768300297615939788368703353944514111011011184191740295491255291545096680705534063721012625490368756140460791685877738232879406346334603566914069127957053440";
        fourthVector.littleEndian = "240";
        fourthVector.numberOfBytes = 255;
        fourthVector.hexValue = "F000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        vectors.add(fourthVector);
    }

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initializeInputData();
        startCalculation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}