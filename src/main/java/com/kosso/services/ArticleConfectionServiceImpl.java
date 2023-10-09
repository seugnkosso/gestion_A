package com.kosso.services;

import java.util.ArrayList;

import com.kosso.entities.ArticleConfection;
import com.kosso.repositories.ITables;
import com.kosso.repositories.list.TableArticleConfections;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {

    private ITables<ArticleConfection> articleConfRep;

    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articleConfRep) {
        this.articleConfRep = articleConfRep;
    }

    @Override
    public int add(ArticleConfection data) {
        return articleConfRep.insert(data);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleConfRep.findAll();
    }

    @Override
    public int update(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArticleConfection show(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public int index(int id) {
        return articleConfRep.indexOf(id);
    }

    @Override
    public int remove(int id) {
        return articleConfRep.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

}
