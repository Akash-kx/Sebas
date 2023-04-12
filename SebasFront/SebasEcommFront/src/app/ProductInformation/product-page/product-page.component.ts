import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

import { ProductServiceService } from './ProductService/product-service.service';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private productService: ProductServiceService, private router: Router) {
  }

  productId: number= 0
  searchProduct: Partial<ProductInventryDataType>= {}

  size:string= "L"
  quantity:number= 1

  @ViewChild('formValue') productDetail!: NgForm

  @ViewChild('showBag') showGoToBag!: ElementRef
  @ViewChild('showCart') showAddToCart!: ElementRef

  @ViewChild('showWishList') showWishList!: ElementRef
  @ViewChild('showHeart') showHeart!: ElementRef

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(data => {

      this.productId= data['id']
    })

    this.productService.showSearchedProduct(this.productId).subscribe((productDetail: ProductInventryDataType) => {

      this.searchProduct= productDetail
    })
  }

  addToCart(): void {

    if(sessionStorage.getItem('Token')) {

      this.showAddToCart.nativeElement.style.display ="none"
      this.showGoToBag.nativeElement.style.display ="block"
      this.productService.addProductInAddToBag(this.productDetail.value)
    }
    else {

      this.router.navigate(['LoginPage'])
    }
  }

  wishList(): void {

    if(sessionStorage.getItem('Token')) {

      this.showWishList.nativeElement.style.display ="none"
      this.showHeart.nativeElement.style.display ="block"
      this.productService.addProductInWishList(this.productDetail.value)
    }
    else {

      this.router.navigate(['LoginPage'])
    }
  }
}
