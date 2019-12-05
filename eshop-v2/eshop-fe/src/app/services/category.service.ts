import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Category } from '../model/Category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  
  constructor(private http : HttpClient) { }

  getAllCategories(){
    return this.http.get("http://localhost:8080/categories/list");
  }

  addNewCategory(c : Category) {
    return this.http.post("http://localhost:8080/categories/add", c);
  }
}
