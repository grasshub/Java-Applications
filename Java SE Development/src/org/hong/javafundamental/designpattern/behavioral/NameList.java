package org.hong.javafundamental.designpattern.behavioral;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NameList extends JList<Object> implements ListSelectionListener {

    private static final long serialVersionUID = -8054430790544785604L;
    private final transient MediatorGUI mediator;
    private final transient DefaultListModel<Object> listModel = new DefaultListModel<>();

    public NameList(MediatorGUI mediator) {
        super();
        addListSelectionListener(this);
        readName();
        setModel(listModel);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.mediator = mediator;
        mediator.register(this);
    }

    //read 50 famous man from file
    private void readName() {

        BufferedReader bufferedReader = null;
        String fileName = "Java SE Development/Data File/FiftyMan.txt";

        try {
            //add all the names to default list model
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                listModel.addElement(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void valueChanged(ListSelectionEvent e) {

        //if a name is selected from name list
        JList<?> nameList = (JList<?>) e.getSource();
        if (nameList.getSelectedIndex() >= 0)
            mediator.selectName();
    }

}
