import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/model/Category.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-category',
  templateUrl: './edit-category.component.html',
  styleUrls: ['./edit-category.component.css']
})
export class EditCategoryComponent implements OnInit {
  categoryForm : FormGroup;
  constructor(private fb : FormBuilder, 
    private categoryService : CategoryService,
    private router : Router) { }

  ngOnInit() {
    this.initForm();
  }

  initForm(){
    this.categoryForm = this.fb.group({
      name: this.fb.control(""),
      description : this.fb.control("")
    });
  }

  addNewCategory(){
    let p = new Category(null, this.categoryForm.value.name, this.categoryForm.value.description);
    this.categoryService.addNewCategory(p).subscribe(
      data => {
        console.log("Category saved successfully.");
        this.router.navigate(["/categoriesList"]);
      },
      error => {
        console.log("Error : " + error);
      }
    );
  }

}
