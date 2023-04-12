import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SearchedServiceService } from './SearchedService/searched-service.service';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

@Component({
  selector: 'app-searched-page',
  templateUrl: './searched-page.component.html',
  styleUrls: ['./searched-page.component.css']
})
export class SearchedPageComponent implements OnInit {

  constructor(private searchedService: SearchedServiceService, private activatedRouter: ActivatedRoute, private router: Router) {
  }

  allSearchedProduct: Array<ProductInventryDataType>= [];

  searchedProduct: string= ''

  ngOnInit(): void {

    this.activatedRouter.params.subscribe((searchedValue: any): void => {

      this.searchedProduct = searchedValue['searchValue']

      if(this.searchedProduct != null) {

        this.searchedService.showSearchedProduct(this.searchedProduct)
        .subscribe((searchedDetail: Array<ProductInventryDataType>) => {
          this.allSearchedProduct= searchedDetail;
        })
      }
    })
  }

  productInformation(productId: number) {

    return this.router.navigate(['productPage', productId])
  }
}
