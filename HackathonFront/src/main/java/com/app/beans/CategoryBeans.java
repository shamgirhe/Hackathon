package com.app.beans;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.CategoryDao;
import com.app.pojos.Categories;

public class CategoryBeans {
    private List<Categories> cantegoryList;
    
    public CategoryBeans() {
		cantegoryList = new ArrayList<>();
	}
    public void fetchCategory() {
    	try(CategoryDao cd = new CategoryDao()) {
			 cantegoryList =  cd.showCategories();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public String categoryName(int id) {
    	try(CategoryDao cd = new CategoryDao()) {
			 return cd.Categories(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
     
    
    public List<Categories> getCantegoryList() {
		return cantegoryList;
	}
    public void setCantegoryList(List<Categories> cantegoryList) {
		this.cantegoryList = cantegoryList;
	}
}
