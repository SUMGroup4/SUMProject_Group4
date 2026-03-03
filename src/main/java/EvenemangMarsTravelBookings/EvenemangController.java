package EvenemangMarsTravelBookings;

import com.sun.source.tree.Tree;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class EvenemangController {
TreeMap<Integer, String> checkIfMovieTrue = new TreeMap<>();
    @FXML
    private CheckBox chooseChbxFilmJumanji;

    @FXML
    private CheckBox chooseChbxFilmTerminator;

    @FXML
    private CheckBox chooseChbxFilmTitanic;

    @FXML
    private CheckBox chooseChbxKonsertGwenStefani;

    @FXML
    private CheckBox chooseChbxKonsertStefanLoven;

    @FXML
    private CheckBox chooseChbxKonsertTheLeatherNuns;

    @FXML
    private CheckBox chooseChbxTeaterDracula;

    @FXML
    private CheckBox chooseChbxTeaterHamlet;

    @FXML
    private CheckBox chooseChbxTeaterRomeoOchJulia;

    public void checkBoxFunction()
    {
        // filmer
        boolean[] check = {false,false,false,false,false,false,false,false,false};
        if(chooseChbxFilmTitanic.isSelected()){
            check[0] = true;

        } else if (chooseChbxFilmTitanic.isDisabled()) {
            check[0] = false;
        }

        if(chooseChbxFilmJumanji.isSelected()){
            check[1] = true;
        }

        if(chooseChbxFilmTerminator.isSelected()){
            check[2] = true;
        }

        //Konserter
        if(chooseChbxKonsertGwenStefani.isSelected()){
            check[3] = true;
        }
        if(chooseChbxKonsertStefanLoven.isSelected()){
            check[4] = true;
        }
        if(chooseChbxKonsertTheLeatherNuns.isSelected()){
            check[5] = true;
        }

        //Teater
        if(chooseChbxTeaterDracula.isSelected()){
            check[6] = true;
        }
        if(chooseChbxTeaterHamlet.isSelected()){
            check[7] = true;
        }
        if(chooseChbxTeaterRomeoOchJulia.isSelected()){
            check[8] = true;
        }

        for(boolean selection : check){
            if(selection){

            }
    }


    }

}
