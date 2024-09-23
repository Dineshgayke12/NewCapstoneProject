import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductsComponent } from './dashboard/products/products.component';
import { ProductOrderComponent } from './dashboard/product-order/product-order.component';
import { TableModule } from 'primeng/table'; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { DropdownModule } from 'primeng/dropdown';
import { SuplierComponent } from './dashboard/suplier/suplier.component'; 
// import { AngularFontAwesomeModule } from 'angular-font-awesome/dist/src/angular-font-awesome.module';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DashboardComponent,
    ProductsComponent,
    ProductOrderComponent,
    SuplierComponent 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TableModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    DropdownModule
    // AngularFontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
