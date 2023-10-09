package com.kosso.repositories.list;

import java.util.ArrayList;

import com.kosso.entities.ArticleConfection;
import com.kosso.entities.Unite;
import com.kosso.repositories.ITables;

public class TableArticleConfections implements ITables<ArticleConfection> {
    private ArrayList<ArticleConfection> tables = new ArrayList<>();

    @Override
    public int insert(ArticleConfection data) {
        tables.add(data);
        return 1;
    }

    @Override
    public int update(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<ArticleConfection> findAll() {
        return tables;
    }

    @Override
    public ArticleConfection findById(int id) {
        return tables.get(id);
    }

    @Override
    public int delete(int id) {
        tables.remove(id);
        return 0;
    }

    @Override
    public int indexOf(int id) {
        int pos = 0;
        for (ArticleConfection cat : tables) {
            if (cat.getId() == id) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

}
