import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { WishListDataType } from 'src/app/WishListDataType.module';
import { WishListServiceService } from './WishListService/wish-list-service.service';

@Component({
  selector: 'app-wish-list-page',
  templateUrl: './wish-list-page.component.html',
  styleUrls: ['./wish-list-page.component.css']
})
export class WishListPageComponent implements OnInit {

  constructor(private router: Router, private wishListService: WishListServiceService) { }

  allWishListProduct: Array<WishListDataType>= []
  tokenAvailable: boolean= false

  ngOnInit(): void {

    if(sessionStorage.getItem('Token')) {

      this.tokenAvailable= true
    }
    else {

      this.router.navigate(['LoginPage'])
    }

    this.wishListService.showAllWishListProduct().subscribe((wishListDetail: Array<WishListDataType>) => {

      this.allWishListProduct= wishListDetail;
    })
  }

  productInformation(productId: number): void {

    this.router.navigate(['productPage', productId])
  }

  addToCart(productId: number): void {

    this.wishListService.addProductInAddToBagFromWishListProduct(productId)
    .subscribe((wishListDetail: Array<WishListDataType>) => {

      this.allWishListProduct= wishListDetail;
    })
  }

  deleteProductWishList(productId: number): void {

    this.wishListService.deleteSpecificWishListProduct(productId).subscribe((wishListDetail: Array<WishListDataType>) => {

      this.allWishListProduct= wishListDetail;
    })
  }

  continueShopping(): void {

    this.router.navigate(['HomePage'])
  }
}
