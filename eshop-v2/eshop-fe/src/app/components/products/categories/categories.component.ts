import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/model/Category.model';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories : Category[];

  constructor(private categoryService : CategoryService) { }

  ngOnInit() {
    this.categoryService.getAllCategories().subscribe(
      (data : Category[]) => {
        this.categories = data;
      }
    );
  }

}
