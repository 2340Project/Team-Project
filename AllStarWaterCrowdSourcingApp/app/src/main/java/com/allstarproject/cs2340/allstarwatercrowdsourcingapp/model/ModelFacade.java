package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Facade for the Model that allows us to load and save the necessary data using
 * the Model object as the top level object to be saved through serialization
 * Created by Austin on 3/21/17.
 */

public class ModelFacade implements Serializable {
    public static final String DEFAULT_BINARY_FILE_NAME = "data.bin";
    private static final ModelFacade modelFacade = new ModelFacade();
    private Model m;

    /**
     * default constructor to instantiate an instance of model
     */
    public ModelFacade() {
        m = new Model();
    }

    /**
     * Loads all the data from the binary file for persistence.
     * @param file the file that stores all the data for persistence
     */
    public void loadBinary(File file) {
        boolean success = true;
        String success1 = "true";
        try {
            /*
              To read, we must use the ObjectInputStream since we want to read
              our model in with a single read.
             */
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with
            // one line of code.
            m = (Model) in.readObject();
            in.close();
        } catch (IOException e) {

            //Log.e("UserManagementFacade", "Error reading an entry from binary file");
            //e.printStackTrace();
            success = false;
            success1 = "false";
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
        //Log.d("Status of load", success1);
    }

    /**
     * saves all data from recent session to the binary file for persistence
     * @param file the same file that data is saved to and loaded from for
     * persistence.
     */
    public void saveBinary(File file) {
        boolean success = true;
        String success1 = "true";
        try {
            /*
           For binary, we use Serialization, so everything we write has to
           implement the Serializable interface.  Fortunately all the
           collection classes and APi classes that we might use are already
           Serializable.  You just have to make sure your classes implement
           Serializable.

           We have to use an ObjectOutputStream to write objects.

           One thing to be careful of:  You cannot serialize static data.
         */


            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
            // We basically can save our entire data model with one write,
            // since this will follow all the links and pointers to save
            // everything.  Just save the top level object.
            out.writeObject(m);
            out.close();

        } catch (IOException e) {
            Log.e("UserManagerFacade",
                    "Error writing an entry from binary file");
            e.printStackTrace();
            success = false;
            success1 = "false";
        }
        Log.d("Status of save", success1);
    }

    /**
     * gets the instance of ModelFacade
     * @return the instance of ModelFacade
     */
    public static ModelFacade getModelFacade() {
        return modelFacade;
    }

    /**
     * gets the instance of Model
     * @return the instance of model.
     */
    public Model getModelInstance() {
        File file = new File(ModelFacade.DEFAULT_BINARY_FILE_NAME);
        modelFacade.loadBinary(file);
        return m;
    }
}
