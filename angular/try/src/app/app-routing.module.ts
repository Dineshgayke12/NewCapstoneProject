import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './dashboard/products/products.component';
import { ProductOrderComponent } from './dashboard/product-order/product-order.component';
import { SuplierComponent } from './dashboard/suplier/suplier.component';

const routes: Routes = [

  {
    path: 'products',
    component: ProductsComponent,
    title: 'products'
  },

  {
    path: 'orders',
    component: ProductOrderComponent,
    title: 'orders'
  },

  {
    path: 'suplier',
    component: SuplierComponent,
    title: 'suplier'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
