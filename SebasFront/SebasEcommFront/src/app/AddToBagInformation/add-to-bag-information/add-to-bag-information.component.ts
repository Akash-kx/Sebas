import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddToBagDataType } from 'src/app/AddToBagDataType.module';
import { AddToBagServiceService } from './AddToBagService/add-to-bag-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-to-bag-information',
  templateUrl: './add-to-bag-information.component.html',
  styleUrls: ['./add-to-bag-information.component.css']
})
export class AddToBagInformationComponent implements OnInit {

  constructor(private router: Router, private addToBagService: AddToBagServiceService) { }

  allAddToCartProduct: Array<AddToBagDataType>= []
  tokenAvailable: boolean= false
  updateAddToCart: {productId: number, productSize: string, productQuantity: number}= {
    productId: 0,
    productSize: '',
    productQuantity: 0
  }
  totalProductPrice: number = 0;
  allProductIdInBag: Array<number>= []
  cardDetailError: boolean= false

  ngOnInit(): void {

    if(sessionStorage.getItem('Token')) {

      this.tokenAvailable= true
    }
    else {

      this.router.navigate(['LoginPage'])
    }

    this.addToBagService.showAllAddToCartProduct().subscribe((addToCartDetail: Array<AddToBagDataType>) => {

      if(addToCartDetail != null) {

        this.totalProductPrice= 0
        addToCartDetail.forEach( productDetail => {
          this.totalProductPrice += productDetail.productPrice * productDetail.productQuantity
        })
      }

      this.allAddToCartProduct= addToCartDetail
    })

  }

  productInformation(productId: number) {

    return this.router.navigate(['productPage', productId])
  }

  removeAddToBag(productId: number): void {

    this.addToBagService.deleteSpecificAddToCartProduct(productId).subscribe((addToCartDetail: Array<AddToBagDataType>) => {

      if(addToCartDetail != null) {

        this.totalProductPrice= 0
        addToCartDetail.forEach( productDetail => {
          this.totalProductPrice += productDetail.productPrice * productDetail.productQuantity
        })
      }

      this.allAddToCartProduct= addToCartDetail
    })
  }

  moveToWishList(productId: number): void {

    this.addToBagService.moveSpecificAddToCartProduct(productId).subscribe((addToCartDetail: Array<AddToBagDataType>) => {

      if(addToCartDetail != null) {

        this.totalProductPrice= 0
        addToCartDetail.forEach( productDetail => {
          this.totalProductPrice += productDetail.productPrice * productDetail.productQuantity
        })
      }

      this.allAddToCartProduct= addToCartDetail
    })
  }

  changeInValue(productId: number, productSize: string, productQuantity: number): void {

    this.updateAddToCart= {productId: productId, productSize: productSize, productQuantity: productQuantity}

    this.addToBagService.updateSpecificProductInAddToCart(this.updateAddToCart)
    .subscribe((addToCartDetail: Array<AddToBagDataType>) => {

      if(addToCartDetail != null) {

        this.totalProductPrice= 0
        addToCartDetail.forEach( productDetail => {
          this.totalProductPrice += productDetail.productPrice * productDetail.productQuantity
        })
      }

      this.allAddToCartProduct= addToCartDetail
    })
  }

  buyAllProduct(): void {

    let paymentGateway: any= document.querySelector(".container")
    let addToBagCart: any= document.querySelector(".addToCart")

    this.addToBagService.showAllProductIdInAddToBag().subscribe((allProductId: Array<number>) => {

      this.allProductIdInBag = allProductId;
      paymentGateway.style.display = "block"
      addToBagCart.style.display = "none"
    })
  }

  payCardDetail(cardDetail: NgForm): void {

    this.addToBagService.cardDetailValidate(cardDetail.value).subscribe((validationError: any) => {

      if(validationError == 'true') {

        this.addToBagService.moveProductToYourOrder(this.allProductIdInBag)
        .subscribe((addToCartDetail: Array<AddToBagDataType>) => {

          this.allAddToCartProduct= addToCartDetail
          this.router.navigate(['HomePage'])
        })
        this.cardDetailError= false
      }
      else {

        this.cardDetailError= true
      }
    })
  }

  continueShopping(): void {

    this.router.navigate(['HomePage'])
  }

  cancelPayment(): void {

    let paymentGateway: any= document.querySelector(".container")
    let addToBagCart: any= document.querySelector(".addToCart")

    document.querySelector(".cancelMark")?.addEventListener('click', () => {

      paymentGateway.style.display= "none"
      addToBagCart.style.display= "block"
    })
  }
}
