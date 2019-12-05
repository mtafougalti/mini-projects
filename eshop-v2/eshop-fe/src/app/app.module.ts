import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import {HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ListProductsComponent } from './components/products/list-products/list-products.component';
import { ProductsComponent } from './components/products/products/products.component';
import { CategoriesComponent } from './components/products/categories/categories.component';
import { ContactComponent } from './components/others/contact/contact.component';
import { from } from 'rxjs';
import { EditProductComponent } from './components/products/edit-product/edit-product.component';
import { EditCategoryComponent } from './components/products/edit-category/edit-category.component';
import { ListCategoriesComponent } from './components/products/list-categories/list-categories.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ListProductsComponent,
    ProductsComponent,
    CategoriesComponent,
    ContactComponent,
    EditProductComponent,
    EditCategoryComponent,
    ListCategoriesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
