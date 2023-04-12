import { Component, OnInit } from '@angular/core';

import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

import { HomeServiceService } from './HomeService/home-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePage implements OnInit {

  constructor(private homeService: HomeServiceService, private router: Router) { }

  slideStart: number= 1
  allProductInInventory: Array<ProductInventryDataType> = []

  ngOnInit(): void {

    this.slideOperater(this.slideStart)
    this.homeService.showAllProductInInventory().subscribe((allProduct: Array<ProductInventryDataType>) => {
      this.allProductInInventory= allProduct
    })
  }

  nextSlideCoursael(slideNo: number) {

    this.slideStart= slideNo + this.slideStart
    this.slideOperater(this.slideStart)
  }

  nextSlideDot(slideNo: number) {

    this.slideStart= slideNo
    this.slideOperater(this.slideStart)
  }

  slideOperater(slideNo: number): void {

    let slideNumber: any= document.querySelectorAll(".coursaelB")
    let dotNumber: any= document.querySelectorAll(".dotA")

    if(slideNo > slideNumber.length) {

      this.slideStart= 1
    }

    if(slideNo < 1) {

      this.slideStart= slideNumber.length
    }

    slideNumber.forEach((slideIterate: any) => {
      slideIterate.style.display= "none"
    })

    dotNumber.forEach((dotIterate: any) => {
      dotIterate.classList.remove("dotAAffect")
    })

    slideNumber[this.slideStart-1].style.display= "block"
    dotNumber[this.slideStart-1].classList.add("dotAAffect")
  }

  productInformation(productId: number) {

    return this.router.navigate(['productPage', productId])
  }
}
