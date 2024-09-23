import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProductServiceService } from 'src/app/Services/product-service.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent {

  ProdNameStore?: String;
  allAvailProducts: any = [];
  selectedProductId: any;
  constructor(private fb: FormBuilder, private AvailService: ProductServiceService) {

  }

  // Get all avail 
  getAllAvail() {
    this.AvailService.getAllProductAail().subscribe(res => {
      this.allAvailProducts = res;

    })
  }


  storeClickedData(val: any) {
    this.ProdNameStore = val.productName
  }

  form!: FormGroup;

  ngOnInit() {
    this.form = this.fb.group({

      prodid: [],
      productName: [],
      productQty: [],
      price: [],
      unit: [],
    })



    // Call fun 
    this.getAllAvail();
  }

  // Add product
  AddProd() {
    if (this.form.valid) {
      this.AvailService.addProd(this.selectedProductId, this.form.value).subscribe({
        next: (res) => {
          this.getAllAvail()
        }
      });

    }

    // gett all
    this.AvailService.getAllProductAail().subscribe(res => {
      this.allAvailProducts = res;
    })

    this.AvailService.notificationQty(this.selectedProductId).subscribe({
      next: (product: any) => {
        console.log(product.qty);
        if(product.qty<11){
          alert("Only few products left please order")
        }
      }
    }

    );

    console.log(this.AvailService.notificationQty(this.selectedProductId).subscribe());

    // get all
    this.getAllAvail();
  }

  updateQT(productId: any): void {
    this.selectedProductId = productId;
    console.log(productId)
  }

  // update prod API
  // onUpdateFrom() {
  //   this.AvailService.subProd(this.selectedProductId, this.form.value).subscribe();
  // }


  globalFilter: string = '';
  getValue($event: any) {
    return $event.target.value
  }


  storeQty = 0;
  qtyStore(val: any) {
    this.storeQty = val;
  }



}
function next(value: any): void {
  throw new Error('Function not implemented.');
}

