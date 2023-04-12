import { Component, OnInit } from '@angular/core';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';
import { WomensServiceService } from './WomensService/womens-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-womens-page',
  templateUrl: './womens-page.component.html',
  styleUrls: ['./womens-page.component.css']
})
export class WomensPageComponent implements OnInit {

  constructor(private womensService: WomensServiceService, private router: Router) { }

  allWomenCloths: Array<ProductInventryDataType>= [];

  ngOnInit(): void {

    const productFor: string= "Women"
    this.womensService.showWomensProduct(productFor).subscribe((womensDetail: Array<ProductInventryDataType>) => {

      this.allWomenCloths= womensDetail;
    })
  }

  productInformation(productId: number) {

    return this.router.navigate(['productPage', productId])
  }
}
