export interface WishListDataType {

  productPrice: number,
  productName: string,
  productSize: string,
  productQuantity: number,
  productImagePath: string,
  wishListClusterId:
  {
      userEmail: string,
      productId: number
  },
  productClass: string,
  productDescription: string
}
