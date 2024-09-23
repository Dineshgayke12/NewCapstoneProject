import { Component, OnInit } from '@angular/core';
import { ProductsComponent } from '../products/products.component';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProductServiceService } from 'src/app/Services/product-service.service';

@Component({
  selector: 'app-product-order',
  templateUrl: './product-order.component.html',
  styleUrls: ['./product-order.component.scss']
})
export class ProductOrderComponent implements OnInit {


  bgColor:any="Delivered";
  selectedProductId: number | null = null; // To hold the currently selected product ID
  UnitDefault: String = "KG";
  form!: FormGroup;
  allproducts: any = [];
  statusform!: FormGroup;
  constructor(private fb: FormBuilder, private service: ProductServiceService) {

  }

  defaultStatus: string = 'Pending';

  // get all
  getAll() {
    this.service.getAll().subscribe(res => {
      this.allproducts = res;
    })
  }


  // product drop
  prductDrop = [
    { value: 'apple', label: 'Apple' },
    { value: 'banana', label: 'Banana' },
    { value: 'cherry', label: 'Cherry' },
    { value: 'date', label: 'Date' },
    { value: 'elderberry', label: 'Elderberry' },
    { value: 'fig', label: 'Fig' },
    { value: 'grape', label: 'Grape' },
    { value: 'honeydew', label: 'Honeydew' },
    { value: 'kiwi', label: 'Kiwi' },
    { value: 'lemon', label: 'Lemon' },
    { value: 'mango', label: 'Mango' },
    { value: 'nectarine', label: 'Nectarine' },
    { value: 'orange', label: 'Orange' },
    { value: 'pear', label: 'Pear' },
    { value: 'plum', label: 'Plum' }

  ];

  // unit drop
  UnitDrop = [
    { value: 'KG', label: 'KG' },
    { value: 'Dozen', label: 'Dozen' }
  ];

  ngOnInit() {
    this.form = this.fb.group({
      productName: [],
      suplierName: [],
      productQty: [],
      price: [],
      date: [],
      status: [this.defaultStatus, { disabled: true }],
      unit: [this.UnitDefault],

    })

    this.service.getAll().subscribe(res => {
      this.allproducts = res;
    })

    this.getAll();

    bgColor:this.selectedOption;
    console.log(this.selectedstatus)

  }



  onSubmit() {
    if (this.form.valid) {
      this.getAll();
      this.service.create(this.form.value).subscribe(res => {
        console.log('Success', res)

        alert("product added");
      })
    }

  }

  //  
  selectedOption?: string;
  statusoption = [
    { id: '1', label: 'Pending', value: 'Pending' },
    { id: '2', label: 'Delivered', value: 'Delivered' },
    { id: '3', label: 'canceled', value: 'canceled' },

  ];

  selectedstatus: any;
  onOptionChange(event: any) {
    this.selectedstatus = event.target.value;
    // this.service.updateProduct(this.selectedstatus);
    console.log('Selected ID:', this.selectedstatus);
  }

  rowdata: any;
  updateuserID: any;
  userId(data: any) {
    this.rowdata = data;
    this.updateuserID = data.id;
    console.log(data)
  }
 
  globalFilter: string = '';
  getValue($event: any) {
    return $event.target.value
  }

  updateStatus() {

    const payload = {
      "productName": this.rowdata.productName,
      "price": this.rowdata.price,
      "productQty": this.rowdata.productQty,
      "date": this.rowdata.data,
      "suplierName": this.rowdata.suplierName,
      "status": this.selectedstatus,
      "unit": this.rowdata.unit
    }

    this.service.updateProduct(this.updateuserID, payload).subscribe({
      next:(res)=>{
        this.getAll();
      }
    });

    bgColor:this.selectedOption; 
  }


 




}
