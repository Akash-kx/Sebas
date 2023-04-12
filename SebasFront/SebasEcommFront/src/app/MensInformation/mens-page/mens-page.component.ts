import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

import { MensServiceService } from './MensService/mens-service.service'

@Component({
  selector: 'app-mens-page',
  templateUrl: './mens-page.component.html',
  styleUrls: ['./mens-page.component.css']
})
export class MensPageComponent implements OnInit {

  constructor(private mensService: MensServiceService, private router: Router) { }

  allMenCloths: Array<ProductInventryDataType>= [];

  ngOnInit(): void {

    const productFor: string= "Men"
    this.mensService.showMensProduct(productFor).subscribe((mensDetail: Array<ProductInventryDataType>) => {
      this.allMenCloths= mensDetail;
    })
  }

  productInformation(productId: number): void {

    this.router.navigate(['productPage', productId])
  }
}
