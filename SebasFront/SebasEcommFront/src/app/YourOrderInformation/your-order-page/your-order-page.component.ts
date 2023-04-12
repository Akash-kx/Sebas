import { Component, OnInit } from '@angular/core';
import { YourOrderServiceService } from './YourOrderService/your-order-service.service';
import { YourOrderDataType } from 'src/app/YourOrderDataType.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-your-order-page',
  templateUrl: './your-order-page.component.html',
  styleUrls: ['./your-order-page.component.css']
})
export class YourOrderPageComponent implements OnInit {

  constructor(private yourOrderService: YourOrderServiceService, private router: Router) { }

  allAddInYourOrder: Array<YourOrderDataType>= []

  ngOnInit(): void {

    this.yourOrderService.showAllYourOrderProduct().subscribe((YourOrderDetail: Array<YourOrderDataType>) => {

      this.allAddInYourOrder= YourOrderDetail
    })
  }

  productInformation(productId: number): void {

    this.router.navigate(['productPage', productId])
  }

  removeYourOrder(productId: number): void {

    this.yourOrderService.showAllYourOrderProductAfterDelete(productId).subscribe((YourOrderDetail: Array<YourOrderDataType>) => {

      this.allAddInYourOrder= YourOrderDetail
    })
  }

  continueShopping(): void {

    this.router.navigate(['HomePage'])
  }
}

