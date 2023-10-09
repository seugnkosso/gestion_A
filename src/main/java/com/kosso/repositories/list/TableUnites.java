package com.kosso.repositories.list;

import java.util.ArrayList;

import com.kosso.entities.Categorie;
import com.kosso.entities.Unite;
import com.kosso.repositories.ITables;

public class TableUnites implements ITables<Unite> {

    private ArrayList<Unite> tables = new ArrayList<>();

    @Override
    public int insert(Unite data) {
        tables.add(data);
        return 1;
    }

    @Override
    public int update(Unite data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<Unite> findAll() {
        return tables;
    }

    @Override
    public Unite findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int indexOf(int id) {
        int pos = 0;
        for (Unite cat : tables) {
            if (cat.getId() == id) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

}
