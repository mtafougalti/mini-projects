import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsComponent } from './components/products/products/products.component';
import { ContactComponent } from './components/others/contact/contact.component';
import { EditProductComponent } from './components/products/edit-product/edit-product.component';
import { ListCategoriesComponent } from './components/products/list-categories/list-categories.component';
import { EditCategoryComponent } from './components/products/edit-category/edit-category.component';

const routes: Routes = [
  { path: '', component: ProductsComponent },
  { path: 'productsList', component: ProductsComponent },
  { path: 'addNewProduct', component: EditProductComponent },
  { path: 'categoriesList', component: ListCategoriesComponent },
  { path: 'addNewCategory', component: EditCategoryComponent },
  { path: 'contact', component: ContactComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
