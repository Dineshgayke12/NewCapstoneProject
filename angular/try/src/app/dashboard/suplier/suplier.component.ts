import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProductServiceService } from 'src/app/Services/product-service.service';

@Component({
  selector: 'app-suplier',
  templateUrl: './suplier.component.html',
  styleUrls: ['./suplier.component.scss']
})
export class SuplierComponent implements OnInit {

  selectedProductId: number | null = null; // To hold the currently selected product ID
  form!: FormGroup;
  allproducts: any = [];
  updateform!: FormGroup;
  constructor(private fb: FormBuilder, private service: ProductServiceService) {

  }


  addData() {

    if (this.form.valid) {
     
      this.service.addSeller(this.form.value).subscribe({
        next:(res)=>{
          this.getAllSuplierData();
          alert("New suplier Added");
        }
      });
    }

  }


  defaultStatus: string = 'Pending';

  // get all
  getAllSuplierData() {
    this.service.getAllSuplierData().subscribe(res => {
      this.allproducts = res;
    })
  }

  ngOnInit() {
    this.form = this.fb.group({
      id: [],
      suplierName: [],
      contact: [],
      address: [],
    })

    this.getAllSuplierData();
  }


  updateSupliar(productId: any): void {
    this.selectedProductId = productId;

  }

  // update suplier API
  onUpdateFrom() {
    this.service.updateSuplier(this.selectedProductId, this.form.value).subscribe(
      {
        next:(res)=>{
          this.getAllSuplierData();
        }
      }
    );
  }

  // delete API
  onDeleteFrom(id: any) {
    this.service.deleteSuplier(id).subscribe({
      next:(res)=>{
        this.getAllSuplierData();
      }
    }); 
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
    debugger
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




}
