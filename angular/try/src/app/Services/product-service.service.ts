import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';
import { ProductOrderComponent } from '../dashboard/product-order/product-order.component';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  private baseurl = environment.ProductsBase_Url;
  private apiUrl = 'http://localhost:8081'
  private supplierapiUrl = 'http://localhost:8081'

  constructor(private http: HttpClient) {
  }

  // Add produt
  create(data: any): Observable<any> {
    return this.http.post(this.baseurl + "/products", data, { observe: 'response' });
  }

  // get all data Products
  getAll(): Observable<any> {
    return this.http.get(this.baseurl + '/products')
  }

  // Update status data
  updateProduct(id: number, updatedProduct: any): Observable<any> {
    return this.http.put("http://localhost:8081/products/status/"+ id, updatedProduct);
  }

  // ALL SUPPLIER
  // Add Supplier details
  addSeller(data: any): Observable<any> {
    return this.http.post("http://localhost:8082/suplier", data, { observe: 'response' });
  }



  // get all data Products
  getAllSuplierData(): Observable<any> {
    return this.http.get('http://localhost:8082' + '/suplier')
  }

  // update
  updateSuplier(id: any, updatedProduct: any): Observable<any> {
    return this.http.put(`http://localhost:8082/suplier/${id}`, updatedProduct);
  }
  // delete
  deleteSuplier(id: any): Observable<any> {
    return this.http.delete(`http://localhost:8082/suplier/${id}`);
  }

  // *********************Avail
  // get all data Products
  getAllProductAail(): Observable<any> {
    return this.http.get('http://localhost:8081/products/allProdsAvail')
  }

  notificationQty(id:any): Observable<any> {
    return this.http.get('http://localhost:8081/products/notification/'+id)
  }

  // Add produt to substract QTY
  addProd(selectedProductId:any ,data: any): Observable<any> {
    return this.http.put('http://localhost:8081/products/updateItem/'+selectedProductId,data, { observe: 'response' });
  }

  // update
  // subProd(id: any, subProdd: any): Observable<any> {
  //   return this.http.put(`http://localhost:8081/qty/${id}`, subProdd);
  // }
}
